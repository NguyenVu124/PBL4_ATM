package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Balance;
import util.MySQLConnUtils;

public class TransferBalanceDAO {
	public Balance getBalance(int _ID) throws SQLException, ClassNotFoundException {
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
	
	public List<Integer> getListID() throws SQLException, ClassNotFoundException {
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
	
	public void transferBalance(int _sID, int _rID, float _sBalance, float _rBalance, String _sDes, String _rDes, String _sTime, String _rTime) throws SQLException, ClassNotFoundException{
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
}
