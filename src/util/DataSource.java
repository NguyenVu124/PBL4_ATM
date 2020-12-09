package util;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
	private static final InterfaceCP cp = new ConnectionPool();
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = cp.getConnection();
			System.out.println("Connection Pool status: " + cp);
		} catch (SQLException e) {}
		return connection;
	}
	
	public static boolean releaseConnection(Connection connection) {
		return cp.releaseConnection(connection);
	}
}
