package model.bo;

import model.dao.ViewMonitoringDAO;

import java.sql.SQLException;
import java.util.List;
import model.bean.Monitoring;

public class ViewMonitoringBO {
	ViewMonitoringDAO viewMonitoringDAO = new ViewMonitoringDAO();
	
	public List<Monitoring> viewMonitoring(int _ID) throws ClassNotFoundException, SQLException {
		return viewMonitoringDAO.getMonitoring(_ID);
	}
}
