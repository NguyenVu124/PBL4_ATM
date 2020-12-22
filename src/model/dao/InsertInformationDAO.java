package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.bean.Information;
import util.DataSource;
//import util.MySQLConnUtils;

public class InsertInformationDAO {
	public void insertInformation(Information _infor) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO INFORMATION (ID, name, phone, gender, birth, email, identitynumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
		//Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(2, _infor.getName());
		pre.setString(3, _infor.getPhone());
		pre.setString(4, _infor.getGender());
		pre.setString(5, _infor.getBirth());
		pre.setString(6, _infor.getEmail());
		pre.setString(7, _infor.getIdentitynumber());
		pre.setInt(1, _infor.getID());
		pre.executeUpdate();
		DataSource.releaseConnection(conn);
	}
}
