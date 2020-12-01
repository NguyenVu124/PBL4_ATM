package model.bean;

public class Account {
	private int ID;
	private String username;
	private String password;
	private int type;
	
	public Account() {}
	
	public Account(String _username, String _password) {
		this.username = _username;
		this.password = _password;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int _ID) {
		this.ID = _ID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String _username) {
		this.username = _username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String _password) {
		this.password = _password;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int _type) {
		this.type = _type;
	}
}

