package applauncher;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.PipedOutputStream;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import util.logs.AnsiColors;

public class ConsolePane extends JTextPane {

    private Color currentForeground;
    private boolean isBold;
    private int userInputStart = 0;


    private void writeToPane(String content, Color color, boolean bold) {
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setForeground(attrs, color);
        StyleConstants.setBold(attrs, bold);

        StyledDocument doc = getStyledDocument();
        try {
            doc.insertString(doc.getLength(), content, attrs);

            setCaretPosition(doc.getLength());
        } catch(BadLocationException e) {
            e.printStackTrace();
        }
        userInputStart = doc.getLength();
    }

    private void sendUserInput(PipedOutputStream out) {
        try {
            StyledDocument doc = getStyledDocument();
            int length = doc.getLength() - userInputStart;
            if(length > 0) {
                String command = doc.getText(userInputStart, length) + "\n";
                out.write(command.getBytes());
                out.flush();

                writeToPane("\n", currentForeground, isBold);
                userInputStart = doc.getLength();
            } else {
                out.write("\n".getBytes());
                out.flush();
                writeToPane("\n", currentForeground, isBold);
                userInputStart = doc.getLength();
            } 
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ConsolePane() {
        setEditable(true);
        setBackground(new Color(30, 31, 34));

        currentForeground = Color.WHITE;
        isBold = false;

        setFont(new Font("Consolas", Font.PLAIN, 30));
    }

    public void parseANSI(String text) {
        
        String[] parts = text.split("(?=\u001B\\[)|(?<=\\w?m)");
        for(String part : parts) {
            if(part.isEmpty()) continue;

            if(part.startsWith("\u001B[")) {
                AnsiColors style = AnsiColors.fromCode(part);

                if(style != null && style == AnsiColors.RESET) {
                    currentForeground = Color.WHITE;
                    isBold = false;
                } else if(style != null && style == AnsiColors.BOLD) {
                    isBold = true;
                } else if(style != null && style.swingColor() != null) {
                    currentForeground = style.swingColor();
                }
            } else {
                writeToPane(part, currentForeground, isBold);
            }
        }
    }

    public void setUpInteractiveConsole(PipedOutputStream out) {
        this.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
            int caretPosition = getCaretPosition();

            if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                if(caretPosition <= userInputStart) {
                    e.consume();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                e.consume();
                sendUserInput(out);
            }
           } 

        });
    }


}