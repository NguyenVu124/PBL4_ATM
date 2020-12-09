package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Information;
import util.DataSource;

public class UpdateInformationDAO {
	public Information getInformation(int _ID) throws SQLException, ClassNotFoundException {
		Information infor = new Information();
		// Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
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
			DataSource.releaseConnection(conn);
			return infor;
		}
		DataSource.releaseConnection(conn);
		return null;
	}

	public void updateInformation(Information _infor) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE INFORMATION SET name = ?, phone = ?, gender = ?, birth = ?, email = ?, identitynumber = ? WHERE ID = ?";
		// Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, _infor.getName());
		pre.setString(2, _infor.getPhone());
		pre.setString(3, _infor.getGender());
		pre.setString(4, _infor.getBirth());
		pre.setString(5, _infor.getEmail());
		pre.setString(6, _infor.getIdentitynumber());
		pre.setInt(7, _infor.getID());
		pre.executeUpdate();
		DataSource.releaseConnection(conn);
	}
}
