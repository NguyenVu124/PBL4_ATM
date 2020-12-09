package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.bean.Account;
import model.dao.SignupDAO;

public class SignupBO {
	SignupDAO signupDAO = new SignupDAO();

	public String errorFormSignup(String _username, String _password, String _repassword) {
		if (_username.equals("") || _password.equals("") || _repassword.equals("")) {
			return "Fill in all fields";
		}
		if (!(_password.equals(_repassword))) {
			return "Password and repassword do not match";
		}
		return null;
	}

	public boolean isExistUsername(String _username) throws ClassNotFoundException, SQLException {
		List<String> list = null;
		list = signupDAO.getListUsername();
		if (list.contains(_username)) {
			return false;
		}
		return true;
	}

	public void insertAccount(String _username, String _password) throws ClassNotFoundException, SQLException {
		signupDAO.insertAccount(_username, _password);
	}

	public void insertBalance(int _ID) throws ClassNotFoundException, SQLException {
		signupDAO.insertBalance(_ID);
	}

	public Account getAccountByUsername(String _username) throws ClassNotFoundException, SQLException {
		return signupDAO.getAccountByUsername(_username);
	}
}
