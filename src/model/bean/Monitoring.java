package model.bean;

public class Monitoring {
	private int IDM;
	private int ID;
	private String time;
	private String description;
	private String type;
	
	public Monitoring() {};
	
	public Monitoring(int _ID, String _time, String _description, String _type) {
		this.ID = _ID;
		this.time = _time;
		this.description = _description;
		this.type = _type;
	};
	
	public Monitoring(String _time, String _description, String _type) {
		this.time = _time;
		this.description = _description;
		this.type = _type;
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
	
	public String getType() {
		return type;
	}
	public void setType(String _type) {
		this.type = _type;
	}
}
