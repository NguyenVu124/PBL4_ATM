package model.bo;

import java.sql.SQLException;

import model.bean.Information;
import model.dao.ViewInformationDAO;

public class ViewInformationBO {
	ViewInformationDAO viewInformationDAO = new ViewInformationDAO();

	public Information viewInformation(int _ID) throws ClassNotFoundException, SQLException {
		return viewInformationDAO.getInformation(_ID);
	}
}
