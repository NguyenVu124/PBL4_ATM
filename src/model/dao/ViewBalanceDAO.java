package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Balance;
import util.DataSource;
//import util.MySQLConnUtils;

public class ViewBalanceDAO {
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
}
