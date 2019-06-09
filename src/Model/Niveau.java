package Model;

public class Niveau {

	private int id_niveau;
	private String nom_niveau;
	
	public Niveau()
	{
		id_niveau=0;
		nom_niveau="";
	}

	public Niveau(int id_niveau, String nom_niveau) {
		this.id_niveau = id_niveau;
		this.nom_niveau = nom_niveau;
	}
	
	public Niveau(String nom_niveau) {
		this.nom_niveau = nom_niveau;
	}

	
	
	
	public int getId_niveau() {
		return id_niveau;
	}

	public void setId_niveau(int id_niveau) {
		this.id_niveau = id_niveau;
	}

	public String getNom_niveau() {
		return nom_niveau;
	}

	public void setNom_niveau(String nom_niveau) {
		this.nom_niveau = nom_niveau;
	}
	
	
}
