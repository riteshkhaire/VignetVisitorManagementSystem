package vignet.com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection createConnection() {
		System.out.println("From DBConnection class");
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/visitormanagementsystem";
		String username = "root";
		String password = "admin";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException cse) {
				cse.printStackTrace();
			}
			System.out.println("Driver loaded");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("printing connection object" + con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
