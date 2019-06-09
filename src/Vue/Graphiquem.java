package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Control.Connexion;
import DAO.BulletinDAO;
import DAO.ClasseDAO;
import DAO.DAO;
import DAO.DisciplineDAO;
import DAO.EnseignementDAO;
import DAO.InscriptionDAO;
import DAO.NiveauDAO;
import DAO.PersonneDAO;
import Model.Bulletin;
import Model.Classe;
import Model.Discipline;
import Model.Enseignement;
import Model.Evaluation;
import Model.Inscription;
import Model.Niveau;
import Model.Personne;

public class Graphiquem implements ActionListener, MouseListener{

	private JFrame frame;
	private JTextField txtPrenom1_1;
	private JTextField txtNom1_1;
	private JTextField txtPrenom1_2;
	private JTextField txtNom1_2;
	private JTable table;
	private int id_selectionne, id_selectionne2;
	private JPanel panel1;
	private JPanel panel1_1;
	private JPanel panel1_2;
	private JPanel panel1_3;
	private JOptionPane jpop3;
	private JComboBox comboBoxNiveau1_1;
	private JComboBox comboBoxClasse1_1;

	private JLabel lblNiveau1_1;
	private JLabel lblClasse1_1 ;
	private JLabel lblPrnom1_1 ;
	private JLabel lblNom1_1;

	private JButton btnAjouter1_1;
	private JButton btnModifier1_2;
	private JButton btnSupprimer1_3;
	private JButton btnBulletins1_2;
	private JButton btnModifier2_3;
	private JButton btnSupprimer2_3;

	JLabel lbInscription1_2;

	private Connexion connect;
	
	
	//Variables DAO
	private DAO<Personne> personneDAO; 
	private DAO<Niveau> niveauDAO;
	private DAO<Classe> classeDAO;
	private DAO<Inscription> inscriptionDAO;
	private DAO<Discipline> disciplineDAO;
	private DAO<Enseignement> enseignementDAO;
	private DAO<Evaluation> evaluationDAO;
	private DAO<Bulletin> bulletinDAO;

	//Lists de recuperation
	private ArrayList<Personne> list;
	private Object[][] data;
	private String titles[];
	private JTable table_2;
	
	private JTextField textFieldNiveau1_2;
	private JTextField textFieldClasse1_2;
	private JTabbedPane tabbedPane_1;
	private JPanel panel2;
	private JPanel panel2_1;
	private JPanel panel2_2;
	private JTextField textFieldPrenom2_2;
	private JTextField textFieldNom2_2;
	private JButton btnAjouter2_2;
	private JComboBox comboBoxDiscipline2_2;
	private JLabel lblDiscipline;
	private JLabel lblPrenom2_2;
	private JLabel lblNom2_2;
	private JList listNiveaux2_2;
	private JScrollPane scrollPane_1;
	private JList listClasse2_2;
	private JTextField textFieldPrenom2_3;
	private JTextField textFieldNom2_3;
	private JButton btnEnseignements2_3;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion c = new Connexion("gestion_ecole", "root", "");
					Graphiquem window = new Graphiquem(c);
					window.initialize(c);
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
	public Graphiquem(Connexion c) {
		this.connect=c;
		frame = new JFrame();
		frame.setBounds(100, 100, 818, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		jpop3=new JOptionPane();

		///Panel1
		panel1 = new JPanel();
		panel1.setToolTipText("");
		tabbedPane.addTab("Eleves", null, panel1, null);
		panel1.setLayout(null);


		///Panel 1_1 : ajout d'un eleve
		panel1_1 = new JPanel();
		panel1_1.setBorder(new LineBorder(new Color(255, 0, 0), 2));
		panel1_1.setBounds(25, 267, 277, 191);
		panel1.add(panel1_1);
		panel1_1.setLayout(null);

		txtPrenom1_1 = new JTextField();
		txtPrenom1_1.setBounds(107, 16, 146, 26);
		panel1_1.add(txtPrenom1_1);
		txtPrenom1_1.setColumns(10);

		txtNom1_1 = new JTextField();
		txtNom1_1.setBounds(107, 64, 146, 26);
		panel1_1.add(txtNom1_1);
		txtNom1_1.setColumns(10);

		btnAjouter1_1 = new JButton("Ajouter");
		btnAjouter1_1.setBounds(107, 146, 117, 29);
		panel1_1.add(btnAjouter1_1);
		btnAjouter1_1.addActionListener(this);

		comboBoxNiveau1_1 = new JComboBox();
		comboBoxNiveau1_1.setBounds(80, 106, 56, 24);
		comboBoxNiveau1_1.addItem("CP");
		comboBoxNiveau1_1.addItem("CE1");
		comboBoxNiveau1_1.addItem("CE2");
		comboBoxNiveau1_1.addItem("CM1");
		comboBoxNiveau1_1.addItem("CM2");

		panel1_1.add(comboBoxNiveau1_1);

		comboBoxClasse1_1 = new JComboBox();
		comboBoxClasse1_1.setBounds(211, 106, 42, 24);
		comboBoxClasse1_1.addItem("A");
		comboBoxClasse1_1.addItem("B");
		comboBoxClasse1_1.addItem("C");


		panel1_1.add(comboBoxClasse1_1);

		lblNiveau1_1 = new JLabel("Niveau :");
		lblNiveau1_1.setBounds(15, 108, 69, 20);
		panel1_1.add(lblNiveau1_1);


		lblClasse1_1 = new JLabel("Classe :");
		lblClasse1_1.setBounds(151, 108, 69, 20);
		panel1_1.add(lblClasse1_1);


		lblPrnom1_1 = new JLabel("Pr\u00E9nom :");
		lblPrnom1_1.setBounds(23, 19, 69, 20);
		panel1_1.add(lblPrnom1_1);

		lblNom1_1 = new JLabel("Nom :");
		lblNom1_1.setBounds(23, 67, 69, 20);
		panel1_1.add(lblNom1_1);


		///Panel1_2 : panel de modif/suppression
		JPanel panel1_2_1 = new JPanel();
		panel1_2_1.setBorder(new LineBorder(Color.RED, 2));
		panel1_2_1.setBounds(327, 267, 449, 191);
		panel1.add(panel1_2_1);
		panel1_2_1.setLayout(null);

		txtPrenom1_2 = new JTextField();
		txtPrenom1_2.setText("Prenom");
		txtPrenom1_2.setBounds(15, 21, 146, 26);
		panel1_2_1.add(txtPrenom1_2);
		txtPrenom1_2.setColumns(10);

		txtNom1_2 = new JTextField();
		txtNom1_2.setText("Nom");
		txtNom1_2.setBounds(15, 60, 146, 26);
		panel1_2_1.add(txtNom1_2);
		txtNom1_2.setColumns(10);

		btnModifier1_2 = new JButton("Modifier");
		btnModifier1_2.setBounds(46, 146, 115, 29);
		panel1_2_1.add(btnModifier1_2);
		btnModifier1_2.addActionListener(this);

		btnSupprimer1_3 = new JButton("Supprimer");
		btnSupprimer1_3.setBounds(186, 146, 115, 29);
		panel1_2_1.add(btnSupprimer1_3);
		btnSupprimer1_3.addActionListener(this);

		lbInscription1_2 = new JLabel("");
		lbInscription1_2.setBounds(216, 21, 173, 16);
		panel1_2_1.add(lbInscription1_2);

		textFieldNiveau1_2 = new JTextField();
		textFieldNiveau1_2.setBounds(15, 99, 68, 22);
		panel1_2_1.add(textFieldNiveau1_2);
		textFieldNiveau1_2.setColumns(10);

		textFieldClasse1_2 = new JTextField();
		textFieldClasse1_2.setColumns(10);
		textFieldClasse1_2.setBounds(106, 99, 55, 22);
		panel1_2_1.add(textFieldClasse1_2);

		btnBulletins1_2 = new JButton("Bulletins");
		btnBulletins1_2.setBounds(186, 98, 115, 29);
		panel1_2_1.add(btnBulletins1_2);
		btnBulletins1_2.addActionListener(this);

		///ligne de séparation
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.RED);
		separator.setForeground(Color.RED);
		separator.setBounds(15, 249, 761, 22);
		panel1.add(separator);


		///panel1_3 : table d'affichage
		JPanel panel1_3_1 = new JPanel();
		panel1_3_1.setBounds(25, 16, 751, 217);
		panel1.add(panel1_3_1);
		panel1_3_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 751, 217);
		panel1_3_1.add(scrollPane);

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setUpdateSelectionOnSort(false);
		table.setSelectionBackground(Color.YELLOW);
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);


		table.addMouseListener(this);


		//variables DAO
		personneDAO = new PersonneDAO(connect.getConn());
		niveauDAO = new NiveauDAO(connect.getConn());
		classeDAO = new ClasseDAO(connect.getConn());
		inscriptionDAO = new InscriptionDAO(connect.getConn());
		disciplineDAO = new DisciplineDAO(connect.getConn());
		enseignementDAO = new EnseignementDAO(connect.getConn());
		bulletinDAO = new BulletinDAO(connect.getConn());

		//Variables de récup
		list = new ArrayList<Personne>();
		data = new Object[list.size()][3];
		String titles[] = {"Id", "Nom", "Prenom"};
		
		
		
		////////////////////////////////////
		////////////////////////////////////
		////////////////////////////////////
		
		
		//Panel 2
		panel2 = new JPanel();
		tabbedPane.addTab("Professeurs", null, panel2, null);
		panel2.setLayout(null);

		panel2_1 = new JPanel();
		panel2_1.setBounds(12, 13, 766, 246);
		panel2.add(panel2_1);
		panel2_1.setLayout(null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(0, 0, 766, 246);
		panel2_1.add(scrollPane2);
		
		table_2 = new JTable();
		table_2.setAutoCreateRowSorter(true);
		table_2.setUpdateSelectionOnSort(false);
		table_2.setSelectionBackground(Color.YELLOW);
		table_2.setShowVerticalLines(false);
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.getTableHeader().setReorderingAllowed(false);
		scrollPane2.setViewportView(table_2);
		
		table_2.addMouseListener(this);

		panel2_2 = new JPanel();
		panel2_2.setLayout(null);
		panel2_2.setBorder(new LineBorder(new Color(255, 0, 0), 2));
		panel2_2.setBounds(12, 272, 386, 202);
		panel2.add(panel2_2);
		
		textFieldPrenom2_2 = new JTextField();
		textFieldPrenom2_2.setColumns(10);
		textFieldPrenom2_2.setBounds(107, 16, 146, 26);
		panel2_2.add(textFieldPrenom2_2);
		
		textFieldNom2_2 = new JTextField();
		textFieldNom2_2.setColumns(10);
		textFieldNom2_2.setBounds(107, 64, 146, 26);
		panel2_2.add(textFieldNom2_2);
		
		btnAjouter2_2 = new JButton("Ajouter");
		btnAjouter2_2.setBounds(25, 143, 117, 29);
		panel2_2.add(btnAjouter2_2);
		btnAjouter2_2.addActionListener(this);
		
		comboBoxDiscipline2_2 = new JComboBox();
		comboBoxDiscipline2_2.setModel(new DefaultComboBoxModel(new String[] {"Fran\u00E7ais", "Math\u00E9matiques", "Histoire-G\u00E9ographie", "Anglais", "Musique"}));
		comboBoxDiscipline2_2.setBounds(80, 106, 104, 24);
		panel2_2.add(comboBoxDiscipline2_2);
		
		lblDiscipline = new JLabel("Discipline :");
		lblDiscipline.setBounds(15, 108, 69, 20);
		panel2_2.add(lblDiscipline);
		
		lblPrenom2_2 = new JLabel("Pr\u00E9nom :");
		lblPrenom2_2.setBounds(23, 19, 69, 20);
		panel2_2.add(lblPrenom2_2);
		
		lblNom2_2 = new JLabel("Nom :");
		lblNom2_2.setBounds(23, 67, 69, 20);
		panel2_2.add(lblNom2_2);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(208, 108, 80, 81);
		panel2_2.add(scrollPane_1);
		
		listNiveaux2_2 = new JList();
		scrollPane_1.setViewportView(listNiveaux2_2);
		listNiveaux2_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNiveaux2_2.setModel(new AbstractListModel() {
			String[] values = new String[] {"CP", "CE1", "CE2", "CM1", "CM2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(300, 108, 56, 78);
		panel2_2.add(scrollPane_2);
		
		listClasse2_2 = new JList();
		listClasse2_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listClasse2_2.setModel(new AbstractListModel() {
			String[] values = new String[] {"A", "B", "C"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_2.setViewportView(listClasse2_2);
		
		JPanel panel2_3 = new JPanel();
		panel2_3.setLayout(null);
		panel2_3.setBorder(new LineBorder(Color.RED, 2));
		panel2_3.setBounds(410, 272, 373, 202);
		panel2.add(panel2_3);
		
		textFieldPrenom2_3 = new JTextField();
		textFieldPrenom2_3.setText("Prenom");
		textFieldPrenom2_3.setColumns(10);
		textFieldPrenom2_3.setBounds(15, 21, 146, 26);
		panel2_3.add(textFieldPrenom2_3);
		
		textFieldNom2_3 = new JTextField();
		textFieldNom2_3.setText("Nom");
		textFieldNom2_3.setColumns(10);
		textFieldNom2_3.setBounds(15, 60, 146, 26);
		panel2_3.add(textFieldNom2_3);
		
		btnModifier2_3 = new JButton("Modifier");
		btnModifier2_3.setBounds(46, 146, 115, 29);
		panel2_3.add(btnModifier2_3);
		
		btnModifier2_3.addActionListener(this);
		
		btnSupprimer2_3 = new JButton("Supprimer");
		btnSupprimer2_3.setBounds(46, 111, 115, 29);
		panel2_3.add(btnSupprimer2_3);
		
		btnEnseignements2_3 = new JButton("Voir ses cours");
		btnEnseignements2_3.addActionListener(this);
		btnEnseignements2_3.setBounds(225, 82, 136, 25);
		panel2_3.add(btnEnseignements2_3);
		
		btnSupprimer2_3.addActionListener(this);

	}



	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(Connexion c) {

		list = personneDAO.findAll("Eleve");
		data = new Object[list.size()][3];
		for(int i=0; i<list.size();i++)
		{
			data[i][0]=list.get(i).getId_personne();
			data[i][1]=list.get(i).getNom_personne();
			data[i][2]=list.get(i).getPrenom_personne();
		}

		String titles[] = {"Id","Nom","Prenom"};
		table.setModel(new DefaultTableModel(data,titles)
		{
			boolean[] columnEditables = new boolean[] {
					false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		list = personneDAO.findAll("Professeur");
		data = new Object[list.size()][3];
		for(int i=0; i<list.size();i++)
		{
			data[i][0]=list.get(i).getId_personne();
			data[i][1]=list.get(i).getNom_personne();
			data[i][2]=list.get(i).getPrenom_personne();
		}
		table_2.setModel(new DefaultTableModel(data,titles)
		{
			boolean[] columnEditables = new boolean[] {
					false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnAjouter1_1)
		{
			ajout_eleve();
		}
		else if(e.getSource()==btnModifier1_2)
		{
			modifier_eleve();		
		}
		else if(e.getSource()==btnSupprimer1_3)
		{
			Personne eleve = new Personne(id_selectionne,txtNom1_2.getText(),txtPrenom1_2.getText(),"Eleve");
			personneDAO.delete(eleve);
		}
		else if(e.getSource()==btnBulletins1_2)
		{
			System.out.println("cgoooooood");
			Graphiquen gph = new Graphiquen();
			gph.initialize();
		}
		else if(e.getSource() == btnAjouter2_2)
		{
			ajout_prof();
		}
		else if (e.getSource() == btnSupprimer2_3)
		{
			Personne prof = new Personne(id_selectionne2,textFieldPrenom2_3.getText(),textFieldNom2_3.getText(),"Professeur");
			personneDAO.delete(prof);
		}
		else if (e.getSource() == btnModifier2_3)
		{
			modifier_prof();
		}
		else if (e.getSource() == btnEnseignements2_3)
		{
			Personne prof2 = new Personne(id_selectionne2,textFieldNom2_3.getText(),textFieldPrenom2_3.getText(),"Professeur");
			Graphiqueo gpho = new Graphiqueo(connect, prof2);
			gpho.initialize();
		}
		initialize(connect);
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==table)
		{		
			int ligne = table.getSelectedRow();
			id_selectionne = (int) table.getModel().getValueAt(ligne, 0);
			Personne p = personneDAO.find(id_selectionne);
			txtPrenom1_2.setText(p.getPrenom_personne());
			txtNom1_2.setText(p.getNom_personne());
			System.out.println("Id selec"+id_selectionne);

			int idmodif = personneDAO.findId(p);
			Inscription ins = new Inscription(idmodif);
			int idmodif2 = inscriptionDAO.findId(ins);
			ins = inscriptionDAO.find(idmodif2);
			lbInscription1_2.setText("N° d'inscription : "+String.valueOf(ins.getId_inscription()));
			System.out.println("Inscruption "+ins.getId_inscription());

			Classe cl = classeDAO.find(ins.getId_classe());
			int id4 = classeDAO.findId(cl);
			//comboBoxClasse1_2.setSelectedIndex(cl.getId_classe());
			textFieldClasse1_2.setText(cl.getNom_classe());

			Niveau ni = niveauDAO.find(cl.getId_niveau());
			//comboBoxNiveau1_2.setSelectedIndex(ni.getId_niveau());
			textFieldNiveau1_2.setText(ni.getNom_niveau());			
		}
		else if (e.getSource()==table_2)
		{
			int ligne = table_2.getSelectedRow();
			id_selectionne2 = (int) table_2.getModel().getValueAt(ligne, 0);
			Personne p = personneDAO.find(id_selectionne2);
			textFieldPrenom2_3.setText(p.getPrenom_personne());
			textFieldNom2_3.setText(p.getNom_personne());
			System.out.println("Id selec"+id_selectionne2);
		}
		initialize(connect);
	}

	public void ajout_eleve()
	{
		System.out.println(txtPrenom1_1.getText());
		System.out.println(txtNom1_1.getText());
		if(txtNom1_1.getText().equals("") || txtPrenom1_1.getText().contentEquals(""))
		{
			jpop3.showMessageDialog(null, "Merci de remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Personne eleve_ajout = new Personne(txtNom1_1.getText(),txtPrenom1_1.getText(),"Eleve");
			personneDAO.create(eleve_ajout);
			int id2 = personneDAO.findId(eleve_ajout);

			Niveau niveau_ajout = new Niveau(comboBoxNiveau1_1.getSelectedItem().toString());
			int id3 = niveauDAO.findId(niveau_ajout);

			Classe classe_ajout = new Classe(comboBoxClasse1_1.getSelectedItem().toString(),1,id3,1);
			System.out.println("Classe :   nom classe"+comboBoxClasse1_1.getSelectedItem().toString()+"   niveau"+id3);
			int id4 = classeDAO.findId(classe_ajout);

			Inscription inscr_ajout = new Inscription(id4,id2);
			inscriptionDAO.create(inscr_ajout);
		}

	}
	public void ajout_prof()
	{

		if(textFieldNom2_2.getText().equals("") || textFieldPrenom2_2.getText().contentEquals(""))
		{
			jpop3.showMessageDialog(null, "Merci de remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
		} 
		else
		{
			int id2,id3, id4, id5;
			Personne prof_ajout = new Personne(textFieldNom2_2.getText(),textFieldPrenom2_2.getText(),"Professeur");
			personneDAO.create(prof_ajout);
			id2 = personneDAO.findId(prof_ajout);

			Discipline discipline_ajout = new Discipline(comboBoxDiscipline2_2.getSelectedItem().toString());
			id3 = disciplineDAO.findId(discipline_ajout);
			//System.out.println(discipline_ajout.getId_discipline()+"    diqd"+discipline_ajout.getNom_discipline());

			Niveau niveau_ajout = new Niveau(listNiveaux2_2.getSelectedValue().toString());
			id4 = niveauDAO.findId(niveau_ajout);

			Classe classe_ajout = new Classe(listClasse2_2.getSelectedValue().toString(),1,id4,1);
			id5 = classeDAO.findId(classe_ajout);

			Enseignement enseignement_ajout = new Enseignement(id5,id3,id2);
			enseignementDAO.create(enseignement_ajout);
		}
		
	}
	
	public void modifier_prof()
	{
		Personne prof_modifier = new Personne(id_selectionne2,textFieldNom2_3.getText(),textFieldPrenom2_3.getText(),"Professeur");
		personneDAO.update(prof_modifier);
	}
	
	public void modifier_eleve()
	{
		if(txtNom1_2.getText().equals("") || txtPrenom1_2.getText().contentEquals("")
				|| textFieldClasse1_2.equals("") || textFieldClasse1_2.equals(""))
		{
			JOptionPane jop3 = new JOptionPane();
			jop3.showMessageDialog(null, "Merci de remplir tous les champs\nClasses : A, B, C\\nNiveaux : CP, CE1, CE2, CM1, CM2", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Personne eleve_modifier = new Personne(id_selectionne,txtNom1_2.getText(),txtPrenom1_2.getText(),"Eleve");

			personneDAO.update(eleve_modifier);
			
			Niveau niveau_modifier = new Niveau(textFieldNiveau1_2.getText());
			int id3 = niveauDAO.findId(niveau_modifier);

			Classe cla = new Classe(textFieldClasse1_2.getText(),1,id3,1);
			int id4 = classeDAO.findId(cla);

			Inscription ins = new Inscription(id4,id_selectionne);
			inscriptionDAO.create(ins);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
