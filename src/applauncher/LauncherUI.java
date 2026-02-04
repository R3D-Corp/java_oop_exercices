package applauncher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class LauncherUI extends JFrame {
    private JList<String> programsList;
    private DefaultListModel<String> model;
    private static PipedOutputStream out;
    private static PipedInputStream in;

    public void refreshProgramList() {
        List<String> classes = ProgramExecutor.findPrograms("src");

        model.clear();
        for(String className : classes) {
            if(ProgramExecutor.isReadyToRun(className) && ProgramExecutor.hasMainMethod(className)) {
                model.addElement(className);
            }
        }
    }

    // Etablit un tuyau de donnée input/output
    public void initalizePipe() {
        try {
            out = new PipedOutputStream();
            in = new PipedInputStream(out);

            System.setIn(in);

            // Ce thread empêche le "Read end dead" car il garde pipe (in) actif
            Thread keepAlive = new Thread(() -> {
                try {
                    while(true) {
                        Thread.sleep(10000);
                    }
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            });
            keepAlive.setDaemon(true);
            keepAlive.start();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Méthode qui crée un moyen de communication entre les sorties print et erreurs et la console de l'application
    public void inializeConsolePipe(ConsolePane consolePane) {
        ConsoleStream consoleStream = new ConsoleStream(consolePane);
        PrintStream printStream = new PrintStream(consoleStream, true);
        System.setOut(printStream);
        System.setErr(printStream);
    }


    public LauncherUI() {

        initalizePipe();
        setTitle("Java Portfolio");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        model = new DefaultListModel<>();
        refreshProgramList();

        programsList = new JList<>(model);
        
        
        ConsolePane console = new ConsolePane();
        inializeConsolePipe(console);
        console.setUpInteractiveConsole(out);
        
        JScrollPane programsScroll = new JScrollPane(programsList);
        JScrollPane consoleScroll = new JScrollPane(console); 
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, programsScroll, consoleScroll);
        splitPane.setDividerLocation(150);
        add(splitPane, BorderLayout.CENTER);

        JPanel userActionsPanel = new JPanel(new BorderLayout());
        
        /* Zone de texte pour les entrées utilisateurs */
        JTextField consoleTextField = new JTextField();
        consoleTextField.setPreferredSize(new Dimension(400, 30));
        consoleTextField.addActionListener(e -> {
            String text = consoleTextField.getText() + "\n";
            try {
                out.write(text.getBytes());
                out.flush();
                consoleTextField.setText("");
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        });

        /* Bouton pour lancer les différents projets */
        JButton launchButton = new JButton("Lancer le programme");
        launchButton.addActionListener(e -> {

            // long memoryUsed = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);
            // System.out.println("Utilisation réelle : " + memoryUsed + " Mo");

            System.out.flush();

            consoleTextField.requestFocusInWindow();
            consoleTextField.setText("");
            String selection = programsList.getSelectedValue();;
            if(selection != null) {
                ProgramExecutor.executeClass(selection);
            }
            
            
        });
        

        userActionsPanel.add(launchButton, BorderLayout.NORTH);
        userActionsPanel.add(consoleTextField, BorderLayout.SOUTH);        
        add(userActionsPanel, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {

        com.formdev.flatlaf.FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new LauncherUI().setVisible(true));
    }
}

