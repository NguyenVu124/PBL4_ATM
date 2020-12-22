package model.bo;

import java.sql.SQLException;
import model.dao.DeleteAccountDAO;

public class DeleteAccountBO {
	DeleteAccountDAO deleteAccountDAO = new DeleteAccountDAO();
	
	public void deleteAccount(int _ID) throws ClassNotFoundException, SQLException {
		deleteAccountDAO.deleteAccount(_ID);
	}
}
