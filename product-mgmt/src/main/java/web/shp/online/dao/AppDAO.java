package web.shp.online.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AppDAO {

	// TODO please populate the db credentials
	private static final String URL = "jdbc:postgresql://localhost:5432/one_zero_four";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "root";

	public Connection getConnection() throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
