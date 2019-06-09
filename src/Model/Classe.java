package Model;

public class Classe {

	private int id_classe, id_ecole, id_niveau, id_anneescolaire;
	private String nom_classe;
	
	public Classe()
	{
		id_anneescolaire=0;
		id_classe=0;
		id_niveau=0;
		id_ecole=0;
		nom_classe="";
	}

	public Classe(int id_classe, String nom_classe, int id_ecole, int id_niveau, int id_anneescolaire) {
		this.id_classe = id_classe;
		this.id_ecole = id_ecole;
		this.id_niveau = id_niveau;
		this.id_anneescolaire = id_anneescolaire;
		this.nom_classe = nom_classe;
	}
	

	public Classe(String nom_classe, int id_ecole, int id_niveau, int id_anneescolaire) {
		this.id_ecole = id_ecole;
		this.id_niveau = id_niveau;
		this.id_anneescolaire = id_anneescolaire;
		this.nom_classe = nom_classe;
	}

	public int getId_classe() {
		return id_classe;
	}

	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}

	public int getId_ecole() {
		return id_ecole;
	}

	public void setId_ecole(int id_ecole) {
		this.id_ecole = id_ecole;
	}

	public int getId_niveau() {
		return id_niveau;
	}

	public void setId_niveau(int id_niveau) {
		this.id_niveau = id_niveau;
	}

	public int getId_anneescolaire() {
		return id_anneescolaire;
	}

	public void setId_anneescolaire(int id_anneescolaire) {
		this.id_anneescolaire = id_anneescolaire;
	}

	public String getNom_classe() {
		return nom_classe;
	}

	public void setNom_classe(String nom_classe) {
		this.nom_classe = nom_classe;
	}
	
}
