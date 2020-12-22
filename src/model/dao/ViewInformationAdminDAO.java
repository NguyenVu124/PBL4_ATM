package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Information;
import util.DataSource;

public class ViewInformationAdminDAO {
	public List<Information> getAllInformation() throws SQLException, ClassNotFoundException {
		List<Information> list = new ArrayList<Information>();
		Connection conn = DataSource.getConnection();
		String sql = "SELECT * FROM INFORMATION";
		PreparedStatement pre = conn.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			Information infor = new Information();
			infor.setID(rs.getInt(1));
			infor.setName(rs.getString(2));
			infor.setPhone(rs.getString(3));
			infor.setGender(rs.getString(4));
			infor.setBirth(rs.getDate(5).toString());
			infor.setEmail(rs.getString(6));
			infor.setIdentitynumber(rs.getString(7));
			list.add(infor);
		}
		DataSource.releaseConnection(conn);
		return list;
	}
}
