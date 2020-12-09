package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool implements InterfaceCP {

	private final List<Connection> availableConnections = new ArrayList<>();
	private final List<Connection> usedConnections = new ArrayList<>();

	private static final int MAX_POOL_SIZE = 10;
	private static final int MAX_TIMEOUT = 5;

	private final String hostName = "localhost";
	private final String dbName = "pbl_test";
	private final String url = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	private final String username = "root";
	private final String password = "";

	public ConnectionPool() {
		for (int i = 0; i < MAX_POOL_SIZE; i++) {
			try {
				availableConnections.add(createConnection(url, username, password));
			} catch (SQLException | ClassNotFoundException e) {
			}
		}
		System.out.println("Connection Pool");
	}

	// Create new connection
	public static Connection createConnection(String url, String user, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, user, password);
	}

	// Get connection from pool
	@Override
	public Connection getConnection() throws SQLException {
		if (availableConnections.isEmpty()) {
			throw new RuntimeException("Maximum pool size reached, no available connections!");
		}

		Connection connection = availableConnections.remove(availableConnections.size() - 1);

		if (!connection.isValid(MAX_TIMEOUT)) {
			try {
				connection = createConnection(url, username, password);
			} catch (ClassNotFoundException | SQLException e) {
			}
		}

		usedConnections.add(connection);
		return connection;
	}

	// Return connection back to the pool
	@Override
	public boolean releaseConnection(Connection connection) {
		if (connection != null) {
			usedConnections.remove(connection);
			availableConnections.add(connection);
			return true;
		}
		return false;
	}

	public List<Connection> getConnectionPool() {
		return availableConnections;
	}

	@Override
	public int getSize() {
		return availableConnections.size() + usedConnections.size();
	}

	@Override
	public int getUsedSize() {
		return usedConnections.size();
	}

	@Override
	public int getAvailableSize() {
		return availableConnections.size();
	}

	@Override
	public void shutdown() throws SQLException {
		usedConnections.forEach(this::releaseConnection);
		for (Connection c : availableConnections) {
			c.close();
		}
		availableConnections.clear();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder().append("Available = " + getAvailableSize())
				.append(" | Used = " + getUsedSize()).append(" | Size = " + getSize());
		return sb.toString();
	}
}
