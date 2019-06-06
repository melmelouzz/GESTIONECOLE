package Model;

public class Ecole {

	private int id_ecole;
	private String nom_ecole;
	
	public Ecole()
	{
		id_ecole=0;
		nom_ecole="";
	}

	public Ecole(int id_ecole, String nom_ecole) {
		super();
		this.id_ecole = id_ecole;
		this.nom_ecole = nom_ecole;
	}
	
	public Ecole(String nom_ecole)
	{
		this.nom_ecole=nom_ecole;
	}

	public int getId_ecole() {
		return id_ecole;
	}

	public void setId_ecole(int id_ecole) {
		this.id_ecole = id_ecole;
	}

	public String getNom_ecole() {
		return nom_ecole;
	}

	public void setNom_ecole(String nom_ecole) {
		this.nom_ecole = nom_ecole;
	}
	
	
	
}
