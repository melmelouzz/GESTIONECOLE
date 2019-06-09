package Model;

public class Enseignement {

	private int id_enseignement, id_classe, id_discipline, id_personne;
	
	public Enseignement()
	{
		id_classe=0;
		id_discipline=0;
		id_enseignement=0;
		id_personne=0;
	}

	public Enseignement(int id_enseignement, int id_classe, int id_discipline, int id_personne) {
		this.id_enseignement = id_enseignement;
		this.id_classe = id_classe;
		this.id_discipline = id_discipline;
		this.id_personne = id_personne;
	}
	
	public Enseignement(int id_classe, int id_discipline, int id_personne) {
		this.id_classe = id_classe;
		this.id_discipline = id_discipline;
		this.id_personne = id_personne;
	}
	

	public int getId_enseignement() {
		return id_enseignement;
	}

	public void setId_enseignement(int id_enseignement) {
		this.id_enseignement = id_enseignement;
	}

	public int getId_classe() {
		return id_classe;
	}

	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}

	public int getId_discipline() {
		return id_discipline;
	}

	public void setId_discipline(int id_discipline) {
		this.id_discipline = id_discipline;
	}

	public int getId_personne() {
		return id_personne;
	}

	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	
	
}
