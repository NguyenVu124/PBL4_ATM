package model.bean;

public class Monitoring {
	private int IDM;
	private int ID;
	private String time;
	private String description;
	
	public Monitoring() {};
	
	public Monitoring(int _ID, String _time, String _description) {
		this.ID = _ID;
		this.time = _time;
		this.description = _description;
	};
	
	public Monitoring(String _time, String _description) {
		this.time = _time;
		this.description = _description;
	};
	
	public int getIDM() {
		return IDM;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String _time) {
		this.time = _time;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String _description) {
		this.description = _description;
	}
}
