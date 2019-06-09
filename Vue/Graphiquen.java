package Vue;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import Control.Connexion;
import DAO.AnneeScolaireDAO;
import DAO.BulletinDAO;
import DAO.ClasseDAO;
import DAO.DAO;
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

public class Graphiquen implements ActionListener, MouseListener{

	private JFrame frmBulletins;
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

	private ArrayList<Evaluation> list1;
	private Object[][] data1;
	private String titles1[];
	
	private JLabel lblInfos;
	private JSpinner spinner;
	private JButton btnAjouterNote1;
	private JTextPane txtpnAppreciation1_1;
	private JComboBox comboBoxCours1;
	
	private int id_selectionne_1;
	private JSpinner spinner_1;
	private JTextPane txtAppreciation1_2;
	private JButton btnModifier1;
	private JComboBox comboBox3_1;
	private JComboBox comboBox3_2;
	private JLabel lbltrim;
	private JButton btnAjouterBulletin3;
	private JTextPane textPane3;
	private JScrollPane scrollPane_1;
	private JTable table3;
	
	private ArrayList<DetailBulletin> list2;
	private Object[][] data2;
	private String titles[];
	private JScrollPane scrollPane;
	private JTable table2;
	private ArrayList<Bulletin> list3;
	private Object[][] data3;
	private String titles3[];
	private String titles2[];

	
	
	/**
	 * Initialise la classe graphique n
	 * 
	 * @param connect
	 * @param eleve
	 * @param inscription
	 * @param classe
	 * @param niveau
	 */
	public Graphiquen(Connexion connect, Personne eleve, Inscription inscription, Classe classe, Niveau niveau)
	{
		this.connect=connect;
		this.eleve=eleve;
		this.classe=classe;
		this.niveau=niveau;
		this.inscription=inscription;
		
		frmBulletins = new JFrame();
		frmBulletins.setTitle("Suivi de l'élève "+eleve.getPrenom_personne()+" "+eleve.getNom_personne());
		frmBulletins.setVisible(true);
		frmBulletins.setBounds(100, 100, 745, 526);
		frmBulletins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBulletins.getContentPane().setLayout(new BorderLayout(0, 0));

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
		
		
		
		JTabbedPane tabbedPane1 = new JTabbedPane(JTabbedPane.TOP);
		frmBulletins.getContentPane().add(tabbedPane1, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		tabbedPane1.addTab("Notes", null, panel_1, null);
		panel_1.setLayout(null);

		lblInfos = new JLabel("");
		lblInfos.setBounds(39, 13, 56, 16);
		panel_1.add(lblInfos);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(10.0, 0.0, 20.0, 1.0));
		spinner.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		spinner.setBounds(39, 300, 67, 32);
		panel_1.add(spinner);
		
		btnAjouterNote1 = new JButton("Ajouter");
		btnAjouterNote1.setBounds(351, 300, 97, 25);
		panel_1.add(btnAjouterNote1);
		btnAjouterNote1.addActionListener(this);
		
		txtpnAppreciation1_1 = new JTextPane();
		txtpnAppreciation1_1.setText("Appreciation...");
		txtpnAppreciation1_1.setBounds(118, 300, 221, 59);
		panel_1.add(txtpnAppreciation1_1);
		
		comboBoxCours1 = new JComboBox();
		comboBoxCours1.setModel(new DefaultComboBoxModel(new String[] {"Fran\u00E7ais", "Math\u00E9matiques", "Histoire-G\u00E9ographie", "Anglais", "Musique"}));
		comboBoxCours1.setBounds(379, 13, 110, 32);
		panel_1.add(comboBoxCours1);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(39, 372, 67, 32);
		panel_1.add(spinner_1);
		
		txtAppreciation1_2 = new JTextPane();
		txtAppreciation1_2.setText("Appreciation...");
		txtAppreciation1_2.setBounds(118, 372, 221, 59);
		panel_1.add(txtAppreciation1_2);
		
		btnModifier1 = new JButton("Modifier");
		btnModifier1.setBounds(351, 372, 97, 25);
		panel_1.add(btnModifier1);

		JPanel panel_2 = new JPanel();
		tabbedPane1.addTab("Détails bulletins", null, panel_2, null);
		panel_2.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 698, 303);
		panel_2.add(scrollPane);
		
		table2 = new JTable();
		scrollPane.setViewportView(table2);
		list2 = new ArrayList<DetailBulletin>();
		data2 = new Object[list2.size()][4];

		JPanel panel_3 = new JPanel();
		tabbedPane1.addTab("Bulletins", null, panel_3, null);
		panel_3.setLayout(null);
		
		comboBox3_1 = new JComboBox();
		comboBox3_1.setModel(new DefaultComboBoxModel(new String[] {"2019/2020", "2018/2019"}));
		comboBox3_1.setBounds(107, 13, 86, 22);
		panel_3.add(comboBox3_1);
		
		comboBox3_2 = new JComboBox();
		comboBox3_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox3_2.setBounds(288, 13, 51, 22);
		panel_3.add(comboBox3_2);
		
		lbltrim = new JLabel("Trimestre");
		lbltrim.setBounds(223, 16, 56, 16);
		panel_3.add(lbltrim);
		
		btnAjouterBulletin3 = new JButton("Ajouter un bulletin");
		btnAjouterBulletin3.setBounds(560, 12, 150, 25);
		panel_3.add(btnAjouterBulletin3);
		btnAjouterBulletin3.addActionListener(this);
		
		textPane3 = new JTextPane();
		textPane3.setBounds(351, 13, 193, 65);
		panel_3.add(textPane3);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 92, 651, 300);
		panel_3.add(scrollPane_1);
		
		table3 = new JTable();
		scrollPane_1.setViewportView(table3);
		list3 = new ArrayList<Bulletin>();
		data3 = new Object[list3.size()][4];



	}

	/**
	 * Initialise les tables d'affichage
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		System.out.println(inscription.getId_inscription());
		list3 = bulletinDAO.findAll_Perso(inscription.getId_inscription());
		data3 = new Object[list3.size()][4];		
		for(int i=0; i<list3.size();i++)
		{
			Trimestre tri = trimestreDAO.find(list3.get(i).getId_trimestre());
			
			AnneeScolaire ann = anneescolaireDAO.find(tri.getId_anneescolaire());
			data2[i][0]=list3.get(i).getId_bulletin();
			data2[i][1] = ann.getAnneeScol();
			data2[i][2] = tri.getNumero();
			data2[i][3] = list3.get(i).getAppreciation();
		}
		String titles3[] = {"Id","Annee Scolaire","Numéro de trimestre","Appreciation"};
		table3.setModel(new DefaultTableModel(data2,titles)
		{
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		
		list2 = detailbulletinDAO.findAll_Perso(inscription.getId_inscription());
		data3 = new Object[list3.size()][4];		
		for(int i=0; i<list3.size();i++)
		{
			Trimestre tri = trimestreDAO.find(list3.get(i).getId_trimestre());
			
			AnneeScolaire ann = anneescolaireDAO.find(tri.getId_anneescolaire());
			data2[i][0]=list3.get(i).getId_bulletin();
			data2[i][1] = ann.getAnneeScol();
			data2[i][2] = tri.getNumero();
			data2[i][3] = list3.get(i).getAppreciation();
		}
		String titles3[] = {"Id","Annee Scolaire","Numéro de trimestre","Appreciation"};
		table3.setModel(new DefaultTableModel(data2,titles)
		{
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		String titles2[] = {"Id", "Id bulletin","Matière", "Appreciation"};

		
	}

	@Override
	/**
	 * Méthode d'actions des boutons
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAjouterNote1)
		{
					
		}
		else if (e.getSource() == btnAjouterBulletin3)
		{
			AnneeScolaire an = anneescolaireDAO.findS(comboBox3_1.getSelectedItem().toString());
			int i = Integer.parseInt(comboBox3_2.getSelectedItem().toString());
			Trimestre tri = trimestreDAO.findQ(i, an.getId_anneescolaire());
			Bulletin bull = new Bulletin (tri.getId_trimestre(),inscription.getId_inscription(),textPane3.getText());
			bulletinDAO.create(bull);
		}
		initialize();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
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

