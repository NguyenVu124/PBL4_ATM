package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceCP {
	Connection getConnection() throws SQLException;
	boolean releaseConnection(Connection connection);
	List<Connection> getConnectionPool();
	int getSize();
	int getAvailableSize();
	int getUsedSize();
	void shutdown() throws SQLException;
}
