package Model;

public class Bulletin {

	private int id_bulletin, id_trimestre, id_inscription;
	private String appreciation;
	
	public Bulletin()
	{
		id_bulletin=0;
		id_inscription=0;
		id_trimestre=0;
		appreciation="";
	}

	public Bulletin(int id_bulletin, int id_trimestre, int id_inscription, String appreciation) {
		this.id_bulletin = id_bulletin;
		this.id_trimestre = id_trimestre;
		this.id_inscription = id_inscription;
		this.appreciation = appreciation;
	}

	public int getId_bulletin() {
		return id_bulletin;
	}

	public void setId_bulletin(int id_bulletin) {
		this.id_bulletin = id_bulletin;
	}

	public int getId_trimestre() {
		return id_trimestre;
	}

	public void setId_trimestre(int id_trimestre) {
		this.id_trimestre = id_trimestre;
	}

	public int getId_inscription() {
		return id_inscription;
	}

	public void setId_inscription(int id_inscription) {
		this.id_inscription = id_inscription;
	}

	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
	
	
	
}

