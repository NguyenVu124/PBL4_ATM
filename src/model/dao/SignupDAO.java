package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Account;
import util.DataSource;

public class SignupDAO {
	public List<String> getListUsername() throws SQLException, ClassNotFoundException {
		List<String> list = new ArrayList<String>();
		// Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		String sql = "SELECT username FROM ACCOUNT";
		PreparedStatement pre = conn.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			String username = rs.getString("username");
			list.add(username);
		}
		DataSource.releaseConnection(conn);
		return list;
	}

	public Account getAccountByUsername(String _username) throws SQLException, ClassNotFoundException {
		Account account = new Account("", "");
		// Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		String sql = "SELECT * from ACCOUNT WHERE username = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, _username);
		ResultSet rs = pre.executeQuery();
		if (rs.next()) {
			account.setID(rs.getInt(1));
			account.setUsername(_username);
			account.setPassword(rs.getString(3));
			account.setType(rs.getInt(4));
			DataSource.releaseConnection(conn);
			return account;
		}
		DataSource.releaseConnection(conn);
		return null;
	}

	public void insertAccount(String _username, String _password) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO ACCOUNT(username, password, type) VALUES (?, ?, ?)";
		// Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, _username);
		pre.setString(2, _password);
		pre.setInt(3, 0);
		pre.executeUpdate();
		DataSource.releaseConnection(conn);
	}

	public void insertBalance(int _ID) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO BALANCE(ID, balance) VALUES (?, ?)";
		// Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _ID);
		pre.setFloat(2, 0);
		pre.executeUpdate();
		DataSource.releaseConnection(conn);
	}
}
