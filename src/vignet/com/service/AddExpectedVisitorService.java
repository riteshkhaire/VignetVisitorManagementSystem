package vignet.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vignet.com.bean.AddExpectedVisitorDetailBean;
import vignet.com.util.DBConnection;

public class AddExpectedVisitorService {
	
	public boolean validateExpectedVisitorAdded(AddExpectedVisitorDetailBean addExpectedVisitorDetailBean) {
		String status="Expected";
		String visitorName=addExpectedVisitorDetailBean.getVisitorName();
		String visitorEmailId=addExpectedVisitorDetailBean.getVisitorEmailId();
		String visitorMobileNumber=addExpectedVisitorDetailBean.getVisitorMobileNumber();
		String expectedVisitDate=addExpectedVisitorDetailBean.getExpectedVisitDate();
		String expectedVisitTime=addExpectedVisitorDetailBean.getExpectedVisitTime();
		String purpose=addExpectedVisitorDetailBean.getPurpose();
		
		Connection con;
		PreparedStatement preparedStatement= null;
		try {

			con = DBConnection.createConnection();
			System.out.println("Coneection object initialized" + con);
			System.out.println("inserting record into db");
			
			preparedStatement=con.prepareStatement("insert into visitordetail(VisitorName,EmailId,Date,checkInTime,purpose,MobileNumber,status) values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1, visitorName);
			preparedStatement.setString(2, visitorEmailId);
			preparedStatement.setString(3, expectedVisitDate);
			preparedStatement.setString(4, expectedVisitDate);
			preparedStatement.setString(5, purpose);
			preparedStatement.setString(6, expectedVisitTime);
			preparedStatement.setString(7, status);
			
			preparedStatement.executeUpdate();
			System.out.println("Data Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return true;
	}

}
