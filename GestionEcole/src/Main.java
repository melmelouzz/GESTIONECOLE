import java.sql.SQLException;

import Control.Connexion;
import DAO.DAO;
import DAO.EcoleDAO;
import Model.Ecole;
import Vue.ConnecGraph;
import Vue.Graphique;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	    try {

	    	Graphique g = new Graphique();
	    	
	    	Connexion c = new Connexion("gestion_ecole", "root", "");
	    	
	    	System.out.println("connexion réussie");

	    	DAO<Ecole> ecoleDAO = new EcoleDAO(c.getConn());
	    	for(int i = 1; i < 6; i++)
	    	{
	    		Ecole ecole = ecoleDAO.find(i);
	    		System.out.println("Ecole N°" + ecole.getId_ecole() + "  - " + ecole.getNom_ecole());
	    	}
	    	
	    	
	    	
//	    	Ecole ec = ecoleDAO.find(1);
//	    	ecoleDAO.delete(ec);
	    	
//	    	Ecole ec = new Ecole("SUDRIA");
//	    	ecoleDAO.create(ec);
	    	
	    	
	    	
	    	
//	    	for(int i = 1; i < c.nbcolonnetable("ecole")+1; i++)
//	    	{
//	    		Ecole ecole = ecoleDAO.find(i);
//	    		System.out.println("After\n Ecole N°" + ecole.getId_ecole() + "  - " + ecole.getNom_ecole());
//	    	}
	    	
	    	
	    	
	    	////			test=c.remplirChampsTable("ecole");
	    	////			System.out.println(test);
	    	////			//Graphique g = new Graphique();
	    	////			
	    	////			test2=c.remplirChampsRequete("SELECT * FROM Ecole");
	    	////			System.out.println("on est là\n"+test2);
	    	////			
	    	////			System.out.println("----- Schéma\n");
	    	////			String t = "Ecole";
	    	////			for (int i=0; i<test2.size();i++)
	    	////			{
	    	////				String[] result = test2.get(i).split(",");
	    	//////			     for (int x=0; x<result.length; x++)
	    	//////			         System.out.println(result[x]);
	    	////				Ecole e = new Ecole(Integer.parseInt(result[0]), result[1]);
	    	////				System.out.println(e.getId_ecole()+"  Nom : "+e.getNom_ecole());
	    	//}


	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	    

	      
		

	}

}
