package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Account;
import util.DataSource;
//import util.MySQLConnUtils;

public class LoginDAO {
	public Account accountLogin(String _username, String _password) throws SQLException, ClassNotFoundException {
		Account account = new Account("", "");
		//Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
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
			DataSource.releaseConnection(conn);
			return account;
		}
		DataSource.releaseConnection(conn);
		return null;
	}
	
}
