package Vue;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Control.Connexion;
import DAO.ClasseDAO;
import DAO.DAO;
import DAO.DisciplineDAO;
import DAO.EnseignementDAO;
import DAO.NiveauDAO;
import DAO.PersonneDAO;
import Model.Classe;
import Model.Discipline;
import Model.Enseignement;
import Model.Inscription;
import Model.Niveau;
import Model.Personne;
import java.awt.Font;

public class Graphiqueo implements ActionListener, MouseListener{

	private JFrame frmInfosProf;
	private Connexion connect;
	private JTable table;
	private JLabel lblInfos, lblSuppr;
	private JList listNiveaux, listCours;
	private JComboBox comboBox;
	private JButton btnSupprimer,btnAjouterCours;
	
	private DAO<Personne> personneDAO; 
	private DAO<Niveau> niveauDAO;
	private DAO<Classe> classeDAO;
	private DAO<Discipline> disciplineDAO;
	private DAO<Enseignement> enseignementDAO;
	
	private ArrayList<Enseignement> list;
	private Object[][] data;
	private String titles[];
	private JButton btnQuitter;
	private Personne prof;
	private int ligne, id_selectionne;
	/**
	 * Create the application.
	 */
	
	
	public Graphiqueo(Connexion connect, Personne prof) {
		
		this.connect=connect;
		this.prof=prof;
		personneDAO = new PersonneDAO(connect.getConn());
		niveauDAO = new NiveauDAO(connect.getConn());
		classeDAO = new ClasseDAO(connect.getConn());
		disciplineDAO = new DisciplineDAO(connect.getConn());
		enseignementDAO = new EnseignementDAO(connect.getConn());
		
		frmInfosProf = new JFrame();
		frmInfosProf.setTitle("Infos prof");
		frmInfosProf.setVisible(true);
		frmInfosProf.setBounds(100, 100, 717, 451);
		frmInfosProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmInfosProf.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblInfos = new JLabel("Professeur   "+prof.getPrenom_personne()+"  "+prof.getNom_personne()+"   N° :"+prof.getId_personne());
		lblInfos.setBounds(12, 13, 329, 16);
		panel.add(lblInfos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 42, 645, 202);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(570, 301, 97, 25);
		panel.add(btnSupprimer);
		
		lblSuppr = new JLabel("");
		lblSuppr.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSuppr.setBounds(471, 272, 196, 16);
		panel.add(lblSuppr);
		
		listCours = new JList();
		listNiveaux = new JList();
		panel.add(listCours);
		panel.add(listNiveaux);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
		comboBox.setBounds(268, 272, 56, 36);
		panel.add(comboBox);
		
		btnAjouterCours = new JButton("Ajouter ce cours");
		btnAjouterCours.setBounds(268, 342, 152, 25);
		panel.add(btnAjouterCours);
		
		btnAjouterCours.addActionListener(this);
		btnSupprimer.addActionListener(this);
		table.addMouseListener(this);

		list = new ArrayList<Enseignement>();
		data = new Object[list.size()][3];
		String titles[] = {"Id", "Nom", "Prenom"};
		
		

		listCours.setModel(new AbstractListModel() {
			String[] values = new String[] {"Fran\u00E7ais", "Math\u00E9matiques", "Histoire-G\u00E9ographie", "Anglais", "Musique"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listCours.setBounds(22, 272, 125, 95);
		listCours.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listNiveaux.setModel(new AbstractListModel() {
			String[] values = new String[] {"CP", "CE1", "CE2", "CM1", "CM2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listNiveaux.setBounds(159, 272, 97, 95);
		listNiveaux.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(this);
		btnQuitter.setBounds(570, 366, 97, 25);
		panel.add(btnQuitter);

	}

	public void initialize() {

		list = enseignementDAO.findAll(prof.getId_personne());
		data = new Object[list.size()][4];		
		for(int i=0; i<list.size();i++)
		{
			Classe cla = classeDAO.find(list.get(i).getId_classe());
			Discipline dis = disciplineDAO.find(list.get(i).getId_discipline());
			Niveau niv = niveauDAO.find(cla.getId_niveau());
			data[i][0]=list.get(i).getId_enseignement();
			data[i][1]=niv.getNom_niveau();
			data[i][2]=cla.getNom_classe();
			data[i][3]=dis.getNom_discipline();
		}

		String titles[] = {"Id","Niveau","Classe","Discipline"};
		table.setModel(new DefaultTableModel(data,titles)
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
		if(e.getSource() == btnQuitter)
		{
			frmInfosProf.dispose();
		}
		else if(e.getSource() == btnSupprimer)
		{
			Enseignement ens = enseignementDAO.find(id_selectionne);
			enseignementDAO.delete(ens);	
		}
		else if(e.getSource() == btnAjouterCours)
		{
			Niveau niv = new Niveau(listNiveaux.getSelectedValue().toString());
			int id1 = niveauDAO.findId(niv);
			
			System.out.println("id niveay"+id1);
			
			Classe clas = new Classe(comboBox.getSelectedItem().toString(),1,id1,1);
			int id2 = classeDAO.findId(clas);
			
			System.out.println("id classe "+id2);
			
			Discipline dis = new Discipline(listCours.getSelectedValue().toString());
			int id3 = disciplineDAO.findId(dis);
			
			Enseignement ense = new Enseignement(id2,id3,prof.getId_personne());
			enseignementDAO.create(ense);
		}
		initialize();
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		ligne = table.getSelectedRow();
		id_selectionne = (int) table.getModel().getValueAt(ligne, 0);
		lblSuppr.setText("N° de l'enseignement :"+id_selectionne);
		
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
