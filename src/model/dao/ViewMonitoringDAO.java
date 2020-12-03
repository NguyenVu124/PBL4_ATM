package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Monitoring;
import util.MySQLConnUtils;

public class ViewMonitoringDAO {
	public List<Monitoring> getMonitoring(int _ID) throws SQLException, ClassNotFoundException {
		List<Monitoring> list = new ArrayList<Monitoring>();
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "SELECT * FROM MONITORING WHERE ID = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _ID);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			String time = rs.getString("time");
			String description = rs.getString("description");
			Monitoring monitoring = new Monitoring(time, description);
			list.add(monitoring);
		}
		return list;
	}
}
