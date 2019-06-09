package Model;

public class Evaluation {

	private int id_evaluation, id_detailbulletin;
	private double note;
	private String appreciation;
	
	public Evaluation()
	{
		id_detailbulletin=0;
		id_evaluation=0;
		note=0.0;
		appreciation="";
	}

	public Evaluation(int id_evaluation, int id_detailbulletin, double note, String appreciation) {
		this.id_evaluation = id_evaluation;
		this.id_detailbulletin = id_detailbulletin;
		this.note = note;
		this.appreciation = appreciation;
	}

	public int getId_evaluation() {
		return id_evaluation;
	}

	public void setId_evaluation(int id_evaluation) {
		this.id_evaluation = id_evaluation;
	}

	public int getId_detailbulletin() {
		return id_detailbulletin;
	}

	public void setId_detailbulletin(int id_detailbulletin) {
		this.id_detailbulletin = id_detailbulletin;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
	
	
}
