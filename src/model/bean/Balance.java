package model.bean;

public class Balance {
	private int ID;
	private float balance;

	public Balance() {
	};

	public Balance(int _ID, float _balance) {
		this.ID = _ID;
		this.balance = _balance;
	}

	public int getID() {
		return ID;
	}

	public void setID(int _ID) {
		this.ID = _ID;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float _balance) {
		this.balance = _balance;
	}
}
