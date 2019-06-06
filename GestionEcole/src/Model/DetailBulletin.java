package Model;

public class DetailBulletin {

	private int id_detailbulletin, id_bulletin, id_enseignement;
	private String appreciation;
	
	public DetailBulletin()
	{
		id_bulletin=0;
		id_detailbulletin=0;
		id_enseignement=0;
		appreciation="";
	}

	public DetailBulletin(int id_detailbulletin, int id_bulletin, int id_enseignement, String appreciation) {
		this.id_detailbulletin = id_detailbulletin;
		this.id_bulletin = id_bulletin;
		this.id_enseignement = id_enseignement;
		this.appreciation = appreciation;
	}

	public int getId_detailbulletin() {
		return id_detailbulletin;
	}

	public void setId_detailbulletin(int id_detailbulletin) {
		this.id_detailbulletin = id_detailbulletin;
	}

	public int getId_bulletin() {
		return id_bulletin;
	}

	public void setId_bulletin(int id_bulletin) {
		this.id_bulletin = id_bulletin;
	}

	public int getId_enseignement() {
		return id_enseignement;
	}

	public void setId_enseignement(int id_enseignement) {
		this.id_enseignement = id_enseignement;
	}

	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
	
	
}
