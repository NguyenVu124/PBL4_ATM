package model.bean;

public class Information {
	private int ID;
	private String name;
	private String phone;
	private String gender;
	private String birth;
	private String email;
	private String identitynumber;
	
	public Information() {}
	
	public Information(int _ID, String _name, String _phone, String _gender, String _birth, String _email, String _identitynumber) {
		this.ID = _ID;
		this.name = _name;
		this.phone = _phone;
		this.gender = _gender;
		this.birth = _birth;
		this.email = _email;
		this.identitynumber = _identitynumber;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int _ID) {
		this.ID = _ID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		this.name = _name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String _phone) {
		this.phone = _phone;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String _gender) {
		this.gender = _gender;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String _email) {
		this.email = _email;
	}
	
	public String getIdentitynumber() {
		return identitynumber;
	}
	public void setIdentitynumber(String _identitynumber) {
		this.identitynumber = _identitynumber;
	}
	
	public String getBirth() {
		return birth;
	}
	public void setBirth(String _birth) {
		this.birth = _birth;
	}
}
