/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package jdbcv2018;

/*
 * 
 * Librairies importées
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * Connexion a votre BDD locale ou à distance sur le serveur de l'ECE via le tunnel SSH
 * 
 * @author segado
 */
public class Connexion {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private Connection conn;
    
    public Connection getConn() {
		return conn;
	}

	private Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    
    
    
    
    /**
     * ArrayList public pour les tables
     */
    public ArrayList<String> tables = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de sélection
     */
    public ArrayList<String> requetes = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de MAJ
     */
    public ArrayList<String> requetesMaj = new ArrayList<>();

    /**
     * Constructeur avec 3 param�tres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost/" + nameDatabase;

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }

//    /**
//     * Constructeur avec 4 param�tres : username et password ECE, login et
//     * password de la BDD à distance sur le serveur de l'ECE
//     * @param usernameECE
//     * @param passwordECE
//     * @param loginDatabase
//     * @param passwordDatabase
//     * @throws java.sql.SQLException
//     * @throws java.lang.ClassNotFoundException
//     */
//    public Connexion(String usernameECE, String passwordECE, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
//        // chargement driver "com.mysql.jdbc.Driver"
//        Class.forName("com.mysql.jdbc.Driver");
//
//        // Connexion via le tunnel SSH avec le username et le password ECE
//        SSHTunnel ssh = new SSHTunnel(usernameECE, passwordECE);
//
//        if (ssh.connect()) {
//            System.out.println("Connexion reussie");
//
//            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
//            String urlDatabase = "jdbc:mysql://localhost:3305/" + usernameECE;
//
//            //création d'une connexion JDBC à la base
//            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
//
//            // création d'un ordre SQL (statement)
//            stmt = conn.createStatement();
//
//        }
//    }

    /**
     * Méthode qui ajoute la table en parametre dans son ArrayList
     *
     * @param table
     */
    public void ajouterTable(String table) {
        tables.add(table);
    }

    /**
     * Méthode qui ajoute la requete de selection en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequete(String requete) {
        requetes.add(requete);
    }

    /**
     * Méthode qui ajoute la requete de MAJ en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequeteMaj(String requete) {
        requetesMaj.add(requete);
    }

    /**
     * Méthode qui retourne l'ArrayList des champs de la table en parametre
     *
     * @param table
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList remplirChampsTable(String table) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery("select * from " + table);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<>();
        String champs = "";
        // Ajouter tous les champs du resultat dans l'ArrayList
        for (int i = 0; i < nbColonne; i++) {
            champs = champs + " " + rsetMeta.getColumnLabel(i + 1);
        }
        
        
        
        for(int i=1; i<= nbColonne; i++)
        {
        	System.out.println("Les colonnes: "+rsetMeta.getColumnName(i).toUpperCase()+"\n");
        	
        }

        while(rset.next())
        {
        	for(int i=1; i<= nbColonne; i++)
        	{
        		System.out.println(rset.getObject(i).toString()+"\n");
        	}
        }
        
        
        rset.close();
        
        
        // ajouter un "\n" à la ligne des champs
        champs = champs + "\n";

        // ajouter les champs de la ligne dans l'ArrayList
        liste.add(champs);

        // Retourner l'ArrayList
        return liste;
    }

    /**
     * Methode qui retourne l'ArrayList des champs de la requete en parametre
     * @param requete
     * @return 
     * @throws java.sql.SQLException
     */
    public ArrayList remplirChampsRequete(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<String>();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            String champs;
            champs = rset.getString(1); // ajouter premier champ

            // Concatener les champs de la ligne separes par ,
            for (int i = 1; i < nbColonne; i++) {
                champs = champs + "," + rset.getString(i + 1);
            }

            // ajouter un "\n" �la ligne des champs
            champs = champs + "\n";

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(champs);
        }

        // Retourner l'ArrayList
        return liste;
    }

    public int nbcolonnetable(String table) throws SQLException
    {
    	String requete="SELECT * FROM "+table;
    	// récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        return nbColonne;
    }
    
    
    
//    public int nblignetable(String table) throws SQLException
//    {
//    	String requete="SELECT COUNT(*) FROM "+table;
//    	// récupération de l'ordre de la requete
//        rset = stmt.executeQuery(requete);
//
//        // récupération du résultat de l'ordre
//        rsetMeta = rset.getMetaData();
//
//        rset.get
//        rsetMeta.
//        return rsetMeta;
//    }
    
    
    
    /**
     * Méthode qui execute une requete de MAJ en parametre
     * @param requeteMaj
     * @throws java.sql.SQLException
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }
}
