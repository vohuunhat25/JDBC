package com.fpt.fresher.fj01.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static String DRIVER_URL = "com.mysql.cj.jdbc.Driver";

	private static String DRIVER = "jdbc:mysql://";

	private static String HOST = "localhost:";

	private static String BACKWARD = "/";

	private static String DB_NAME = "sms";

	private static String USER_NAME = "root";

	private static String USER_PASS = "nhat2512";

	static int PORT = 3306;

	/**
	 * Google translate
	 * 
	 * @return Connection
	 * @throws ClassNotFoundException
	 */

	public static Connection getDatabaseConnection() throws ClassNotFoundException {
		// com.mysql.jdbc.Driver -> tìm kiếm trong souce có cái class này kh
		Class.forName(DRIVER_URL);
		try {
			// jdbc:mysql://localhost:3306/test
			// root
			//
			return DriverManager.getConnection(DRIVER + HOST + PORT + BACKWARD + DB_NAME, USER_NAME, USER_PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
