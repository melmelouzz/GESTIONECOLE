package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Control.Connexion;

public class Graphique {

	private JFrame frame;
	private JTextField txtPrenom;
	private JTextField txtNom;
	private JTextField txtPrenom_1;
	private JTextField txtNom_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphique window = new Graphique();
			    	Connexion c = new Connexion("gestion_ecole", "root", "");
					window.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}

	

		
	
	/**
	 * Create the application.
	 */
	public Graphique() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 818, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelEleves = new JPanel();
		panelEleves.setToolTipText("");
		tabbedPane.addTab("Eleves", null, panelEleves, null);
		panelEleves.setLayout(null);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(25, 267, 115, 29);
		panelEleves.add(btnSupprimer);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(146, 267, 277, 191);
		panelEleves.add(panel_4);
		panel_4.setLayout(null);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(107, 16, 146, 26);
		txtPrenom.setText("Prenom");
		panel_4.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(107, 64, 146, 26);
		txtNom.setText("Nom");
		panel_4.add(txtNom);
		txtNom.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setEnabled(false);
		btnAjouter.setBounds(107, 146, 117, 29);
		panel_4.add(btnAjouter);
		
		JComboBox comboBoxNiveau = new JComboBox();
		comboBoxNiveau.setBounds(80, 106, 56, 24);
		comboBoxNiveau.addItem("6ème");
		comboBoxNiveau.addItem("5ème");
		comboBoxNiveau.addItem("4ème");
		comboBoxNiveau.addItem("3ème");
		comboBoxNiveau.addItem("2nde");

		panel_4.add(comboBoxNiveau);
		
		JComboBox comboBoxClasse = new JComboBox();
		comboBoxClasse.setBounds(211, 106, 42, 24);
		comboBoxClasse.addItem("A");
		comboBoxClasse.addItem("B");
		comboBoxClasse.addItem("C");
		comboBoxClasse.addItem("D");

		panel_4.add(comboBoxClasse);
		
		JLabel lblNiveau = new JLabel("Niveau :");
		lblNiveau.setBounds(15, 108, 69, 20);
		panel_4.add(lblNiveau);
		
		JLabel lblClasse = new JLabel("Classe :");
		lblClasse.setBounds(151, 108, 69, 20);
		panel_4.add(lblClasse);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setBounds(23, 19, 69, 20);
		panel_4.add(lblPrnom);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(23, 67, 69, 20);
		panel_4.add(lblNom);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(438, 267, 338, 191);
		panelEleves.add(panel_5);
		panel_5.setLayout(null);
		
		txtPrenom_1 = new JTextField();
		txtPrenom_1.setText("Prenom");
		txtPrenom_1.setBounds(15, 16, 146, 26);
		panel_5.add(txtPrenom_1);
		txtPrenom_1.setColumns(10);
		
		txtNom_1 = new JTextField();
		txtNom_1.setText("Nom");
		txtNom_1.setBounds(15, 58, 146, 26);
		panel_5.add(txtNom_1);
		txtNom_1.setColumns(10);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(46, 146, 115, 29);
		panel_5.add(btnModifier);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(25, 106, 56, 24);
		panel_5.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(109, 105, 49, 24);
		panel_5.add(comboBox_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.RED);
		separator.setForeground(Color.RED);
		separator.setBounds(15, 249, 761, 22);
		panelEleves.add(separator);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(25, 16, 751, 217);
		panelEleves.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 751, 217);
		panel_6.add(scrollPane);
		
		table = new JTable();
		table.setSelectionBackground(Color.YELLOW);
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Prenom", "Nom", "Classe", "Niveau", "Inscription n\u00B0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JPanel panelProfs = new JPanel();
		tabbedPane.addTab("Professeurs", null, panelProfs, null);
		panelProfs.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Editer un bulletin", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
	}
}
