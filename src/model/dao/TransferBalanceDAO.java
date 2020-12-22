package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Balance;
import model.bean.Monitoring;
import util.DataSource;
//import util.MySQLConnUtils;


public class TransferBalanceDAO {
	public Balance getBalance(int _ID) throws SQLException, ClassNotFoundException {
		Balance balance = new Balance();
		//Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		String sql = "SELECT * from BALANCE WHERE ID = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _ID);
		ResultSet rs = pre.executeQuery();
		if (rs.next()) {
			balance.setID(rs.getInt(1));
			balance.setBalance(rs.getFloat(2));
			DataSource.releaseConnection(conn);
			return balance;
		}
		DataSource.releaseConnection(conn);
		return null;
	}
	
	public List<Integer> getListID(int _ID) throws SQLException, ClassNotFoundException {
		List<Integer> list = new ArrayList<Integer>();
		//Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		String sql = "SELECT ID FROM ACCOUNT WHERE ID NOT IN (SELECT ID FROM ACCOUNT WHERE ID = ?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _ID);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			int ID = rs.getInt("ID");
			list.add(ID);
		}
		DataSource.releaseConnection(conn);
		return list;
	}
	
	public void insertWMonitoring(Monitoring _monitoring) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO MONITORING (ID, time, description, type) VALUES (?, ?, ?, ?)";
		//Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _monitoring.getID());
		pre.setString(2, _monitoring.getTime());
		pre.setString(3, _monitoring.getDescription());
		pre.setString(4, _monitoring.getType());
		pre.executeUpdate();
		DataSource.releaseConnection(conn);
	}
	
	public void insertDMonitoring(Monitoring _monitoring) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO MONITORING (ID, time, description, type) VALUES (?, ?, ?, ?)";
		//Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _monitoring.getID());
		pre.setString(2, _monitoring.getTime());
		pre.setString(3, _monitoring.getDescription());
		pre.setString(4, _monitoring.getType());
		pre.executeUpdate();
		DataSource.releaseConnection(conn);
	}
}
