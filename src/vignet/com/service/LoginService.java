package vignet.com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vignet.com.bean.LoginBean;
import vignet.com.util.DBConnection;

public class LoginService {

	public boolean authenticate(String userName, String password) {
		if (userName != null && password != null) {
			return true;
		} else {
			return false;
		}
	}// authenticate

	public String autthenticateUser(LoginBean lb) {

		String userName = lb.getUserName();
		String password = lb.getPassword();

		Connection con;
		Statement statement = null;
		ResultSet resultSet = null;

		String DBUserName = "";
		String DBPassword = "";

		try {

			con = DBConnection.createConnection();
			System.out.println("Coneection object initialized" + con);

			statement = con.createStatement();
			resultSet = statement.executeQuery("select UserName,Password from LoginDetail");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (resultSet.next()) {
				DBUserName = resultSet.getString("UserName");
				DBPassword = resultSet.getString("Password");
				System.out.println("******* Values from DB************");
				System.out.println(DBUserName);
				System.out.println(DBPassword);

				if (userName.equals(DBUserName) && password.equals(DBPassword)) {
					return "Sucusses";
				}

				return "Invalid Credintials";
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "Invalid Credintials";

	}

}
