package Model;

public class Personne {

	private int id_personne;
	private String nom_personne, prenom_personne, type;
	
	public Personne()
	{
		id_personne=0;
		nom_personne="";
		prenom_personne="";
		type="";
	}

	public Personne(int id_personne, String nom_personne, String prenom_personne, String type) {
		this.id_personne = id_personne;
		this.nom_personne = nom_personne;
		this.prenom_personne = prenom_personne;
		this.type = type;
	}

	public int getId_personne() {
		return id_personne;
	}

	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}

	public String getNom_personne() {
		return nom_personne;
	}

	public void setNom_personne(String nom_personne) {
		this.nom_personne = nom_personne;
	}

	public String getPrenom_personne() {
		return prenom_personne;
	}

	public void setPrenom_personne(String prenom_personne) {
		this.prenom_personne = prenom_personne;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
