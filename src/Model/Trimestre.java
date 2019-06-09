package Model;

public class Trimestre {

	private int id_trimestre, id_anneescolaire;
	private int numero;
	private String debut, fin;
	
	public Trimestre()
	{
		id_anneescolaire=0;
		id_trimestre=0;
		numero=0;
		debut=fin="";
	}

	public Trimestre(int id_trimestre, int id_anneescolaire, int numero, String debut, String fin) {
		this.id_trimestre = id_trimestre;
		this.id_anneescolaire = id_anneescolaire;
		this.numero = numero;
		this.debut = debut;
		this.fin = fin;
	}

	public int getId_trimestre() {
		return id_trimestre;
	}

	public void setId_trimestre(int id_trimestre) {
		this.id_trimestre = id_trimestre;
	}

	public int getId_anneescolaire() {
		return id_anneescolaire;
	}

	public void setId_anneescolaire(int id_anneescolaire) {
		this.id_anneescolaire = id_anneescolaire;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDebut() {
		return debut;
	}

	public void setDebut(String debut) {
		this.debut = debut;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}
	
	
	
	
	
	
}
