package model.bo;

import java.sql.SQLException;

import model.bean.Balance;
import model.dao.ViewBalanceDAO;

public class ViewBalanceBO {
	ViewBalanceDAO viewBalanceDAO = new ViewBalanceDAO();

	public Balance viewBalance(int _ID) throws ClassNotFoundException, SQLException {
		return viewBalanceDAO.getBalance(_ID);
	}
}
