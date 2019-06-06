package Model;

public class Inscription {

	private int id_inscription, id_classe, id_personne;
	
	public Inscription()
	{
		id_classe=0;
		id_inscription=0;
		id_personne=0;
	}

	public Inscription(int id_inscription, int id_classe, int id_personne) {
		this.id_inscription = id_inscription;
		this.id_classe = id_classe;
		this.id_personne = id_personne;
	}

	public int getId_inscription() {
		return id_inscription;
	}

	public void setId_inscription(int id_inscription) {
		this.id_inscription = id_inscription;
	}

	public int getId_classe() {
		return id_classe;
	}

	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}

	public int getId_personne() {
		return id_personne;
	}

	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	
	
	
}
