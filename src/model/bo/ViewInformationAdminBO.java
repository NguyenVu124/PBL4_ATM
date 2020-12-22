package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.bean.Information;
import model.dao.ViewInformationAdminDAO;

public class ViewInformationAdminBO {
	ViewInformationAdminDAO viewInformationAdminDAO = new ViewInformationAdminDAO();
	
	public List<Information> viewAllInformation() throws ClassNotFoundException, SQLException {
		return viewInformationAdminDAO.getAllInformation();
	}
}
