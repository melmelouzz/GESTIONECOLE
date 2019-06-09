package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Control.Connexion;


public class ConnecGraph {

	private JFrame frame;
	private JTextField txtDatabaseconnec;
	private JTextField txtUserconnec;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnecGraph window = new ConnecGraph();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnecGraph() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 372, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDatabase = new JLabel("Database");
		lblDatabase.setBounds(45, 64, 69, 20);
		panel.add(lblDatabase);
		
		txtDatabaseconnec = new JTextField();
		txtDatabaseconnec.setText("gestion_ecole");
		txtDatabaseconnec.setBounds(139, 61, 146, 26);
		panel.add(txtDatabaseconnec);
		txtDatabaseconnec.setColumns(10);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBackground(Color.RED);
		lblUser.setForeground(Color.BLACK);
		lblUser.setBounds(45, 106, 69, 20);
		panel.add(lblUser);
		
		txtUserconnec = new JTextField();
		txtUserconnec.setBounds(139, 103, 146, 26);
		panel.add(txtUserconnec);
		txtUserconnec.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(45, 156, 69, 20);
		panel.add(lblPassword);
		
		JButton btnConnect = new JButton("Connect");
		
		btnConnect.setBounds(149, 199, 115, 29);
		panel.add(btnConnect);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 153, 146, 26);
		panel.add(passwordField);
		
		JLabel lblConnectToDatabase = new JLabel("Connect to database");
		lblConnectToDatabase.setBackground(SystemColor.activeCaption);
		lblConnectToDatabase.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblConnectToDatabase.setBounds(109, 11, 211, 37);
		panel.add(lblConnectToDatabase);
		
		
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connexion c = new Connexion(txtDatabaseconnec.getText(), txtUserconnec.getText(), "");
					System.out.println("accès bdd");
					//this.dispose()
					
				}
				catch (ClassNotFoundException | SQLException e) {
					JOptionPane jop3 = new JOptionPane();
					jop3.showMessageDialog(null, "BDD et/ou user incorrects", "Erreur connexion", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
