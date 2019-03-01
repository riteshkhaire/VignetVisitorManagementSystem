package vignet.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import vignet.com.bean.SignUpBean;
import vignet.com.util.DBConnection;

public class SignUpService {
	// this method check user name availability
	Connection con;
	Statement statement = null;
	ResultSet resultSet = null;
	public boolean checkUserNameAvilability(SignUpBean signUpBean) {

		String newUserName = signUpBean.getNewUserName();// local variable
		

		// getting user name from Database to avoid duplicates
		String DBUserName = "";

		try {
			con = DBConnection.createConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery("select UserName from LoginDetail");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {

			while (resultSet.next()) {
				DBUserName = resultSet.getString("UserName");
				if (newUserName.equals(DBUserName)) {

					System.out.println("User name already exixt");
					return false;
				} 
					System.out.println("User name Available");
					return true;
				
			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	} //checkUserNameAvilability
	
	// method insert data into table

	public boolean validateSignUp(SignUpBean signUpBean) {
		String newName = signUpBean.getNewName();
		String newUserMobile = signUpBean.getNewUserMobile();
		String newUserPassword = signUpBean.getNewUserPassword();
		String role = signUpBean.getRole();
		String newUserName = signUpBean.getNewUserName();
		
		try {
			con = DBConnection.createConnection();
			PreparedStatement preparedStatement=con.prepareStatement("insert into UserDetail values(?,?,?,?,?");
			preparedStatement.setString(1, newUserName);
			preparedStatement.setString(2, newUserPassword);
			preparedStatement.setString(3, role);
			preparedStatement.setString(4, newName);
			preparedStatement.setString(5, newUserMobile);
			
			preparedStatement.executeUpdate();
			System.out.println("Record Inserted into DB");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
