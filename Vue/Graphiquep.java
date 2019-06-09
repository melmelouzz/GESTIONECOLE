package Vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Control.Connexion;
import DAO.AnneeScolaireDAO;
import DAO.BulletinDAO;
import DAO.ClasseDAO;
import DAO.DAO;
import DAO.DetailBulletinDAO;
import DAO.DisciplineDAO;
import DAO.EnseignementDAO;
import DAO.EvaluationDAO;
import DAO.InscriptionDAO;
import DAO.NiveauDAO;
import DAO.PersonneDAO;
import DAO.TrimestreDAO;
import Model.AnneeScolaire;
import Model.Bulletin;
import Model.Classe;
import Model.DetailBulletin;
import Model.Discipline;
import Model.Enseignement;
import Model.Evaluation;
import Model.Inscription;
import Model.Niveau;
import Model.Personne;
import Model.Trimestre;
import javax.swing.JLabel;

public class Graphiquep implements ActionListener, MouseListener {

	private JFrame frame;
	private JTable table;
	private Personne eleve;
	private Classe classe;
	private Inscription inscription;
	private Niveau niveau;
	private Connexion connect;

	private DAO<Personne> personneDAO; 
	private DAO<Niveau> niveauDAO;
	private DAO<Classe> classeDAO;
	private DAO<Inscription> inscriptionDAO;
	private DAO<Discipline> disciplineDAO;
	private DAO<Enseignement> enseignementDAO;
	private DAO<Evaluation> evaluationDAO;
	private DAO<Bulletin> bulletinDAO;
	private DAO<AnneeScolaire> anneescolaireDAO;
	private DAO<Trimestre> trimestreDAO;
	private DAO<DetailBulletin> detailbulletinDAO;
	

	private ArrayList<Bulletin> list;
	private Object[][] data;
	private String titles[];
	private ArrayList<DetailBulletin> list2;
	private Object[][] data2;
	private String titles2[];
	private ArrayList<Enseignement> list3;
	private Object[][] data3;
	private String titles3[];
	
	private JTextField textField;
	private JButton btnAjouter;
	private JComboBox comboBox, comboBox_1;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private int indice;
	private JTable table_2;
	private JScrollPane scrollPane_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton_1;
	/**
	 * 
	 * @param connect
	 * @param eleve
	 * @param classe
	 * @param niveau
	 * @param inscription
	 * @param inscription
	 */
	public Graphiquep(Connexion connect, Personne eleve, Classe classe, Niveau niveau, Inscription inscription) 
	{
		this.connect=connect;
		this.eleve=eleve;
		this.classe=classe;
		this.niveau=niveau;
		this.inscription=inscription;
		
		frame = new JFrame();
		frame.setTitle("Suivi de l'élève "+eleve.getPrenom_personne()+" "+eleve.getNom_personne());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setVisible(true);
		frame.setBounds(100, 100, 745, 526);

		evaluationDAO = new EvaluationDAO(connect.getConn());
		personneDAO = new PersonneDAO(connect.getConn());
		niveauDAO = new NiveauDAO(connect.getConn());
		classeDAO = new ClasseDAO(connect.getConn());
		inscriptionDAO = new InscriptionDAO(connect.getConn());
		disciplineDAO = new DisciplineDAO(connect.getConn());
		enseignementDAO = new EnseignementDAO(connect.getConn());
		bulletinDAO = new BulletinDAO(connect.getConn());
		anneescolaireDAO = new AnneeScolaireDAO(connect.getConn());
		trimestreDAO = new TrimestreDAO(connect.getConn());
		detailbulletinDAO = new DetailBulletinDAO(connect.getConn());
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 511, 114);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(345, 140, 97, 25);
		panel.add(btnAjouter);
		btnAjouter.addActionListener(this);
		
		textField = new JTextField();
		textField.setBounds(211, 140, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox.setBounds(146, 141, 53, 22);
		panel.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2018/2019", "2017/2018"}));
		comboBox_1.setBounds(43, 140, 79, 22);
		panel.add(comboBox_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 232, 356, 234);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		

		list = new ArrayList<Bulletin>();
		data = new Object[list.size()][4];
		
		list2 = new ArrayList<DetailBulletin>();
		data2 = new Object[list2.size()][4];
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(380, 232, 233, 77);
		panel.add(scrollPane_2);
		
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		lblNewLabel = new JLabel("Enseignements de l'\u00E9l\u00E8ve");
		lblNewLabel.setBounds(380, 203, 186, 16);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("D\u00E9tail des bulletins de l'\u00E9l\u00E8ve");
		lblNewLabel_1.setBounds(12, 203, 170, 16);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(390, 322, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(380, 357, 143, 25);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Id enseignement");
		lblNewLabel_2.setBounds(518, 325, 95, 16);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Appreciation");
		lblNewLabel_3.setBounds(552, 360, 103, 16);
		panel.add(lblNewLabel_3);
		
		btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(380, 395, 97, 25);
		panel.add(btnNewButton);
		
		lblNewLabel_4 = new JLabel("Bulletin n\u00B0 ");
		lblNewLabel_4.setBounds(618, 144, 97, 16);
		panel.add(lblNewLabel_4);
		
		btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.setBounds(380, 441, 97, 25);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		lblNewLabel_4.setVisible(false);
		
		table_2.addMouseListener(this);
		
		list3 = new ArrayList<Enseignement>();
		data3 = new Object[list3.size()][2];
		
		table.addMouseListener(this);
		btnNewButton.addActionListener(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		list = bulletinDAO.findAll_Perso(inscription.getId_inscription());
		data = new Object[list.size()][4];		
		for(int i=0; i<list.size();i++)
		{
			Trimestre tri = trimestreDAO.find(list.get(i).getId_trimestre());
			AnneeScolaire ann = anneescolaireDAO.find(tri.getId_anneescolaire());
			data[i][0] = list.get(i).getId_bulletin();
			data[i][1] = ann.getAnneeScol();
			data[i][2] = tri.getNumero();
			data[i][3] = list.get(i).getAppreciation();
		}
		String titles[] = {"Id","Annee Scolaire","Numéro de trimestre","Appreciation"};
		table.setModel(new DefaultTableModel(data,titles)
		{
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		list2 = detailbulletinDAO.findAll(indice);
		data2 = new Object[list2.size()][4];		
		for(int i=0; i<list2.size();i++)
		{
			data2[i][0] = list2.get(i).getId_detailbulletin();
			data2[i][1] = list2.get(i).getId_bulletin();
			data2[i][2] = list2.get(i).getId_enseignement();
			data2[i][3] = list2.get(i).getAppreciation();
		}
		String titles2[] = {"Id","Id bulletin","Id enseignement","Appreciation"};
		table_1.setModel(new DefaultTableModel(data2,titles2)
		{
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		list3 = enseignementDAO.findAll_classes(classe.getId_classe());
		data3 = new Object[list3.size()][2];		
		for(int i=0; i<list3.size();i++)
		{
			
			data3[i][0] = list3.get(i).getId_enseignement();
			Discipline ni = disciplineDAO.find(list3.get(i).getId_discipline());
			data3[i][1] = ni.getNom_discipline();
		}
		String titles3[] = {"Id","Enseignement"};
		table_2.setModel(new DefaultTableModel(data3,titles3)
		{
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnAjouter)
		{
			ajout_bulletin();
		}
		else if (e.getSource()==btnNewButton)
		{
			ajout_detail();
		}
		else if(e.getSource()==btnNewButton_1)
		{
			frame.setVisible(false);
		}
		
		initialize();
	}
	
	public void ajout_detail()
	{
		DetailBulletin db = new DetailBulletin(indice, Integer.parseInt(textField_1.getText()), textField_2.getText());
		detailbulletinDAO.create(db);
	}
	
	public void ajout_bulletin()
	{
		int id_trim;	
		Bulletin bulle = new Bulletin();
		id_trim=Integer.parseInt(comboBox.getSelectedItem().toString()); 
		bulle = new Bulletin(id_trim,inscription.getId_inscription(),textField.getText());
		bulletinDAO.create(bulle);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==table)
		{
			int ligne = table.getSelectedRow();
			indice = (int) table.getModel().getValueAt(ligne, 0);
			lblNewLabel_4.setVisible(true);
			lblNewLabel_4.setText("Bulletin n°"+indice);
		}
		initialize();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
