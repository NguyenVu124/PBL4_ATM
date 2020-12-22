package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Monitoring;
import util.DataSource;

public class ViewMonitoringAdminDAO {
	public List<Monitoring> getListMonitoring() throws SQLException, ClassNotFoundException {
		List<Monitoring> list = new ArrayList<Monitoring>();
		Connection conn = DataSource.getConnection();
		String sql = "SELECT * FROM MONITORING ORDER BY TIME DESC";
		PreparedStatement pre = conn.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("ID");
			String time = rs.getString("time");
			String description = rs.getString("description");
			String type = rs.getString("type");
			Monitoring monitoring = new Monitoring(id, time, description, type);
			list.add(monitoring);
		}
		DataSource.releaseConnection(conn);
		return list;
	}
	public List<Monitoring> getListSearchMonitoring(String inputID, String inputDate, String inputType) throws SQLException, ClassNotFoundException {
		List<Monitoring> list = new ArrayList<Monitoring>();
		Connection conn = DataSource.getConnection();
		String sql = "SELECT * FROM MONITORING WHERE ID LIKE ? AND TIME LIKE ? AND TYPE LIKE ? ORDER BY IDM DESC;";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, inputID);
		pre.setString(2, inputDate);
		pre.setString(3, inputType);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("ID");
			String time = rs.getString("time");
			String description = rs.getString("description");
			String type = rs.getString("type");
			Monitoring monitoring = new Monitoring(id, time, description, type);
			list.add(monitoring);
		}
		DataSource.releaseConnection(conn);
		return list;
	}
}
