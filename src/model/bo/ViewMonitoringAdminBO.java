package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.bean.Monitoring;
import model.dao.ViewMonitoringAdminDAO;

public class ViewMonitoringAdminBO {
	ViewMonitoringAdminDAO viewMonitoringAdminDAO = new ViewMonitoringAdminDAO();
	
	public List<Monitoring> viewAllMonitoring() throws ClassNotFoundException, SQLException {
		return viewMonitoringAdminDAO.getListMonitoring();
	}
	
	public List<Monitoring> viewListSearchMonitoring(String ID, String date, String type) throws ClassNotFoundException, SQLException {
		return viewMonitoringAdminDAO.getListSearchMonitoring(ID, date, type);
	}
}
