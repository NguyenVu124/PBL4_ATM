package model.bo;

import java.sql.SQLException;

import model.bean.Account;
import model.dao.LoginDAO;

public class LoginBO {
	LoginDAO loginDAO = new LoginDAO();

	public Account checkAccountLogin(String _username, String _password) throws ClassNotFoundException, SQLException {
		return loginDAO.accountLogin(_username, _password);
	}
}
