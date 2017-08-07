package com.in28minutes.jdbc.hsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HsqlDatabase {
	public Connection conn;

	public HsqlDatabase() {
		try {
			loadJdbcDriverForHsqlDb();
			setupConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void setupConnection() throws SQLException {
		conn = DriverManager.getConnection("jdbc:hsqldb:db_file", "sa", "");
	}

	private void loadJdbcDriverForHsqlDb() throws ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
	}

	private void shutdownHsqlDatabase() throws SQLException {
		Statement st = conn.createStatement();
		st.execute("SHUTDOWN");
	}

	public void closeConnection() throws SQLException {
		shutdownHsqlDatabase();
		conn.close(); // if there are no other open connection
	}
}
