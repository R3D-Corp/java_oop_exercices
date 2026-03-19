package labs.starwars;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Implémentation Swing d'une vue sur la méelée.
 * 
 * */
public class SwingMeleeView extends JPanel {
	private static final long serialVersionUID = -8493715512783198945L;

	private final Melee melee;

	private final JTextField nameField;
	private final JComboBox<String> kindsCombo;
	private final JSpinner hpSpinner;
	private final JSpinner dpSpinner;
	
	private final JButton addFighterButton;
	private final JButton nextActionButton;
	
	private final DefaultTableModel fightersModel;



	private final JTextArea messages;
	
	static {
		try {
			UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			e.printStackTrace ();
			System.exit(-1);
		}
	}
	
	public SwingMeleeView(Melee melee) {
		super(new  GridBagLayout());
		
		this.melee = melee;
		
		var constraint = new GridBagConstraints();
		constraint.insets = new Insets(4, 4, 4, 4);
		
		var membersLabel = new JLabel(String.format("%-30s", "Nom :"));
		constraint.fill = GridBagConstraints.NONE;
		constraint.anchor = GridBagConstraints.LINE_START;
		constraint.gridwidth = 1;
		
		add(membersLabel, constraint);
		
		var kindLabel = new JLabel(String.format("%-30s", "Type :"));
		constraint.gridx = 1;
		
		add(kindLabel, constraint);
		
		var hpLabel = new JLabel(String.format("%-30s", "Points de vie :"));;		
		constraint.gridx = 2;
		
		add(hpLabel, constraint);
		
		var dpLabel = new JLabel(String.format("%-30s", "Points de Dégâts :"));
		constraint.gridx = 3;
		
		add(dpLabel, constraint);
		
		nameField = new JTextField(25);
		constraint.gridx = 0;
		constraint.gridy = 1;
		
		add(nameField, constraint);
		
		kindsCombo = new JComboBox<>();
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 1;
		constraint.gridy = 1;
		
		add(kindsCombo, constraint);
		
		hpSpinner = new JSpinner(new SpinnerNumberModel(250, 100, 500, 1));
		constraint.gridx = 2;
		constraint.gridy = 1;
		
		add(hpSpinner, constraint);
		
		dpSpinner = new JSpinner(new SpinnerNumberModel(50, 10, 100, 1));
		constraint.gridx = 3;
		constraint.gridy = 1;
		
		add(dpSpinner, constraint);
		
		addFighterButton = new JButton("Ajouter combattant");
		addFighterButton.addActionListener(this::onAddFighter);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridwidth = 4;
		constraint.gridx = 0;
		constraint.gridy = 2;
		
		add(addFighterButton, constraint);
		
		fightersModel = new DefaultTableModel(new String[] {"Nom", "Sorte", "Points de vie", "Points de dégâts"}, 0);
		
		JTable fightersTable = new JTable(fightersModel);
		fightersTable.setShowVerticalLines(false);
		
		constraint.gridx = 0;
		constraint.gridy = 3;
		constraint.gridheight = 2;
		constraint.fill = GridBagConstraints.HORIZONTAL;
		add(new JScrollPane(fightersTable), constraint);
		
		nextActionButton = new JButton("Action suivante");
		nextActionButton.addActionListener(this::onMakeAction);
		nextActionButton.setEnabled(false);
		
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridwidth = 4;
		constraint.gridx = 0;
		constraint.gridy = 6;
		
		add(nextActionButton, constraint);
		
		messages = new JTextArea(4,50);
		messages.setEditable(false);
		
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridwidth = 4;
		constraint.gridx = 0;
		constraint.gridy = 8;
		constraint.gridheight = 3;
		constraint.fill = GridBagConstraints.BOTH;
		add(new JScrollPane(messages), constraint);
		
		fillKindsCombo();
		fillComponents();
	}

	private void fillComponents() {
		boolean valideTable = fillTable();
		
		nextActionButton.setEnabled(valideTable && fightersModel.getRowCount() >= 2);
		
		this.updateUI();
	}

	private boolean fillTable() {
		String[][] tableData = melee.getFightersArray();
		boolean validData = checkNoNull(tableData);
		if(validData) {
			fightersModel.setRowCount(0);
			
			for(var rowData : tableData) {
				fightersModel.addRow(rowData);
			}
		} else {
			showErrorMessage("Il faut fournir des lignes de 4 colonnes");
		}
		return validData;
	}

	private boolean fillKindsCombo() {
		String[] names = melee.getFightersKind();
		boolean validNames = checkNoNull(names, 1);
		if(validNames) {
			kindsCombo.removeAllItems();
			for(var name : names) {
				kindsCombo.addItem(name);
			}
			kindsCombo.setSelectedIndex(0);
		} else {
			showErrorMessage("Il faut au moins un type de combattants");
		}
		return validNames;
	}

	private void onAddFighter(ActionEvent event) {
		if(event == null) {
			return;
		}
		this.melee.addFighter(new AddFighterRequest(
				(String)kindsCombo.getSelectedItem(), nameField.getText(), (Integer)hpSpinner.getValue(), (Integer)dpSpinner.getValue()));
		
		fillComponents();
	}

	private boolean checkNoNull(String[]... table) {
		return Arrays.stream(table)
				.allMatch(row -> checkNoNull(row, 4));
	}
	
	private boolean checkNoNull(String[] row, int minLength) {
		return row != null && row.length >= minLength 
				&& Arrays.stream(row).allMatch(col -> col != null);
	}
	
	private void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, 
				message, 
				"Initialization error",
				JOptionPane.ERROR_MESSAGE);
	}

	private void onMakeAction(ActionEvent event) {
		if(event == null) {
			return;
		}
		addFighterButton.setEnabled(false);
		
		melee.makeNextAction();
		messages.append(melee.getLastMessage());
		
		fillComponents();
	}
}