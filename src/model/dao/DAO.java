package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Account;
import model.bean.Balance;
import model.bean.Information;
import model.bean.Monitoring;
import util.MySQLConnUtils;

public class DAO {
	public static Account accountFromUsername(String _username) throws SQLException, ClassNotFoundException {
		Account account = new Account("", "");
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "SELECT * from ACCOUNT WHERE username = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, _username);
		ResultSet rs = pre.executeQuery();
		if (rs.next()) {
			account.setID(rs.getInt(1));
			account.setUsername(_username);
			account.setPassword(rs.getString(3));
			account.setType(rs.getInt(4));
			return account;
		}
		return null;
	}
	
	public static Account accountLogin(String _username, String _password) throws SQLException, ClassNotFoundException {
		Account account = new Account("", "");
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "SELECT * from ACCOUNT WHERE username = ? AND password = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, _username);
		pre.setString(2, _password);
		ResultSet rs = pre.executeQuery();
		if (rs.next()) {
			account.setID(rs.getInt(1));
			account.setUsername(_username);
			account.setPassword(_password);
			account.setType(rs.getInt(4));
			return account;
		}
		return null;
	}
	
	public static List<String> listUsername() throws SQLException, ClassNotFoundException {
		List<String> list = new ArrayList<String>();
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "SELECT username FROM ACCOUNT";
		PreparedStatement pre = conn.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			String username = rs.getString("username");
			list.add(username);
		}
		return list;
	}
	
	public static List<Integer> listID() throws SQLException, ClassNotFoundException {
		List<Integer> list = new ArrayList<Integer>();
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "SELECT ID FROM ACCOUNT";
		PreparedStatement pre = conn.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			int ID = rs.getInt("ID");
			list.add(ID);
		}
		return list;
	}
	
	public static void insertAccount(String _username, String _password) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO ACCOUNT(username, password, type) VALUES (?, ?, ?)";
		Connection conn = MySQLConnUtils.getMySQLConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, _username);
		pre.setString(2, _password);
		pre.setInt(3, 0);
		pre.executeUpdate();
	}
	
	public static void insertBalance(int _ID) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO BALANCE(ID, balance) VALUES (?, ?)";
		Connection conn = MySQLConnUtils.getMySQLConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _ID);
		pre.setFloat(2, 0);
		pre.executeUpdate();
	}
	
	public static Information viewInformation(int _ID) throws SQLException, ClassNotFoundException {
		Information infor = new Information();
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "SELECT * from INFORMATION WHERE ID = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _ID);
		ResultSet rs = pre.executeQuery();
		if (rs.next()) {
			infor.setID(rs.getInt(1));
			infor.setName(rs.getString(2));
			infor.setPhone(rs.getString(3));
			infor.setGender(rs.getString(4));
			infor.setBirth(rs.getDate(5).toString());
			infor.setEmail(rs.getString(6));
			infor.setIdentitynumber(rs.getString(7));
			return infor;
		}
		return null;
	}
	
	public static void updateInformation(Information _infor) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE INFORMATION SET name = ?, phone = ?, gender = ?, birth = ?, email = ?, identitynumber = ? WHERE ID = ?";
		Connection conn = MySQLConnUtils.getMySQLConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, _infor.getName());
		pre.setString(2, _infor.getPhone());
		pre.setString(3, _infor.getGender());
		pre.setString(4, _infor.getBirth());
		pre.setString(5, _infor.getEmail());
		pre.setString(6, _infor.getIdentitynumber());
		pre.setInt(7, _infor.getID());
		pre.executeUpdate();
	}
	
	public static Balance viewBalance(int _ID) throws SQLException, ClassNotFoundException {
		Balance balance = new Balance();
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "SELECT * from BALANCE WHERE ID = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _ID);
		ResultSet rs = pre.executeQuery();
		if (rs.next()) {
			balance.setID(rs.getInt(1));
			balance.setBalance(rs.getFloat(2));
			return balance;
		}
		return null;
	}
	
	public static List<Monitoring> viewMonitoring(int _ID) throws SQLException, ClassNotFoundException {
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
	
	public static void deleteAccount(int _ID) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM ACCOUNT WHERE ID = ?";
		Connection conn = MySQLConnUtils.getMySQLConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _ID);
		pre.executeUpdate();
	}
	
	public static void insertInformation(Information _infor) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO INFORMATION (ID, name, phone, gender, birth, email, identitynumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = MySQLConnUtils.getMySQLConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(2, _infor.getName());
		pre.setString(3, _infor.getPhone());
		pre.setString(4, _infor.getGender());
		pre.setString(5, _infor.getBirth());
		pre.setString(6, _infor.getEmail());
		pre.setString(7, _infor.getIdentitynumber());
		pre.setInt(1, _infor.getID());
		pre.executeUpdate();
	}
	
	public static void depositBalance(int _ID, float _input) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE BALANCE SET balance = ? WHERE ID = ?";
		Connection conn = MySQLConnUtils.getMySQLConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(2, _ID);
		pre.setFloat(1, _input);
		pre.executeUpdate();
	}
	
	public static void withdrawBalance(int _ID, float _input) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE BALANCE SET balance = ? WHERE ID = ?";
		Connection conn = MySQLConnUtils.getMySQLConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(2, _ID);
		pre.setFloat(1, _input);
		pre.executeUpdate();
	}
	
	public static void insertMonitoring(Monitoring _monitoring) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO MONITORING (ID, time, description) VALUES (?, ?, ?)";
		Connection conn = MySQLConnUtils.getMySQLConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _monitoring.getID());
		pre.setString(2, _monitoring.getTime());
		pre.setString(3, _monitoring.getDescription());
		pre.executeUpdate();
	}
	
	public static void transferBalance(int _sID, int _rID, float _sBalance, float _rBalance, String _sDes, String _rDes, String _sTime, String _rTime) throws SQLException, ClassNotFoundException{
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sqlUpdateReceiver = "UPDATE BALANCE SET balance = ? WHERE ID = ?";
		PreparedStatement pre1 = conn.prepareStatement(sqlUpdateReceiver);
		pre1.setInt(2, _sID);
		pre1.setFloat(1, _sBalance);
		pre1.executeUpdate();
		
		String sqlUpdateSender = "UPDATE BALANCE SET balance = ? WHERE ID = ?";
		PreparedStatement pre2 = conn.prepareStatement(sqlUpdateSender);
		pre2.setInt(2, _rID);
		pre2.setFloat(1, _rBalance);
		pre2.executeUpdate();
		
		String sqlInsertMonitoringS = "INSERT INTO MONITORING (ID, time, description) VALUES (?, ?, ?)";
		PreparedStatement pre3 = conn.prepareStatement(sqlInsertMonitoringS);
		pre3.setInt(1, _sID);
		pre3.setString(2, _sTime);
		pre3.setString(3, _sDes);
		pre3.executeUpdate();
		
		String sqlInsertMonitoringR = "INSERT INTO MONITORING (ID, time, description) VALUES (?, ?, ?)";
		PreparedStatement pre4 = conn.prepareStatement(sqlInsertMonitoringR);
		pre4.setInt(1, _rID);
		pre4.setString(2, _rTime);
		pre4.setString(3, _rDes);
		pre4.executeUpdate();
		
	}
	
	public static List<Float> getBalance(int _sID, int _rID) throws SQLException, ClassNotFoundException {
		List<Float> list = new ArrayList<Float>();
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql1 = "SELECT * from BALANCE WHERE ID = ?";
		PreparedStatement pre1 = conn.prepareStatement(sql1);
		pre1.setInt(1, _sID);
		ResultSet rs1 = pre1.executeQuery();
		if (rs1.next()) {
			float sBalance = rs1.getFloat("balance");
			list.add(sBalance);
		}
		String sql2 = "SELECT * from BALANCE WHERE ID = ?";
		PreparedStatement pre2 = conn.prepareStatement(sql2);
		pre2.setInt(1, _rID);
		ResultSet rs2 = pre2.executeQuery();
		if (rs2.next()) {
			float rBalance = rs2.getFloat("balance");
			list.add(rBalance);
		}
		return list;
	}
}
