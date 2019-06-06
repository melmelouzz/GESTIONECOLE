package Model;

public class Discipline {

	private int id_discipline;
	private String nom_discipline;
	
	public Discipline()
	{
		id_discipline=0;
		nom_discipline="";
	}

	
	
	public Discipline(int id_discipline, String nom_discipline) {
		this.id_discipline = id_discipline;
		this.nom_discipline = nom_discipline;
	}



	public int getId_discipline() {
		return id_discipline;
	}

	public void setId_discipline(int id_discipline) {
		this.id_discipline = id_discipline;
	}

	public String getNom_discipline() {
		return nom_discipline;
	}

	public void setNom_discipline(String nom_discipline) {
		this.nom_discipline = nom_discipline;
	}
	
	
}
