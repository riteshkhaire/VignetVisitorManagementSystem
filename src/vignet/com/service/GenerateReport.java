package vignet.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import vignet.com.bean.VisitorDetailBean;
import vignet.com.util.DBConnection;

public class GenerateReport {

	Connection con;
	Statement statement = null;
	ResultSet resultSet = null;

	public ArrayList<VisitorDetailBean> visitorDetails() {
System.out.println("Called from receptionist home");
		ArrayList<VisitorDetailBean> visitorList = new ArrayList<VisitorDetailBean>();

		try {
			con = DBConnection.createConnection();
			System.out.println("Coneection object initialized" + con);

			statement = con.createStatement();
			resultSet = statement.executeQuery(
					"select VisitorID,VisitorName,MobileNumber,Status,Date,CheckInTime,CheckOutTime,EmailID from VisitorDetail");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (resultSet.next()) {
				// getting records from database
				VisitorDetailBean visitorDetailBean = new VisitorDetailBean();

				visitorDetailBean.setVisitorID(Integer.toString(resultSet.getInt("VisitorID")));
				visitorDetailBean.setVisitorName(resultSet.getString("VisitorName"));
				visitorDetailBean.setEmailId(resultSet.getString("EmailID"));
				visitorDetailBean.setMobileNumber(resultSet.getString("MobileNumber"));
				visitorDetailBean.setDate(resultSet.getString("Date"));
				visitorDetailBean.setStatus(resultSet.getString("status"));
				visitorDetailBean.setCheckInTime(resultSet.getString("checkInTime"));
				visitorDetailBean.setCheckOutTime(resultSet.getString("checkOutTime"));

				System.out.println("Inside Generator report");
				// DBPassword = resultSenet.getString("checkOutTime");

				visitorList.add(visitorDetailBean);
			}
			return visitorList;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		System.out.println("Size:"+visitorList.size());
		return visitorList;

	}

	public ArrayList<VisitorDetailBean> expectedVisitorDetails() {
		ArrayList<VisitorDetailBean> expectedVisitorList = new ArrayList<VisitorDetailBean>();

		try {
			con = DBConnection.createConnection();

			statement = con.createStatement();
			resultSet = statement.executeQuery(
					"select VisitorID,VisitorName,MobileNumber,Status,Date,CheckInTime,CheckOutTime,EmailID from VisitorDetail where Status='Expected'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				// getting records from database
				VisitorDetailBean visitorDetailBean = new VisitorDetailBean();

				visitorDetailBean.setVisitorID(Integer.toString(resultSet.getInt("VisitorID")));
				visitorDetailBean.setVisitorName(resultSet.getString("VisitorName"));
				visitorDetailBean.setMobileNumber(resultSet.getString("MobileNumber"));
				visitorDetailBean.setEmailId(resultSet.getString("EmailID"));
				visitorDetailBean.setDate(resultSet.getString("Date"));
				visitorDetailBean.setStatus(resultSet.getString("status"));
				visitorDetailBean.setCheckInTime(resultSet.getString("checkInTime"));
				visitorDetailBean.setCheckOutTime(resultSet.getString("checkOutTime"));

				expectedVisitorList.add(visitorDetailBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return expectedVisitorList;

	}

	public boolean expectedCheckIn(int visitorId) {
		boolean checkIn;
		String date, time;
		long millis = System.currentTimeMillis();
		java.sql.Date dateLong = new java.sql.Date(millis);

		date = dateLong.toString();

		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			System.out.println("Coneection object initialized" + con);

			preparedStatement = con
					.prepareStatement("UPDATE visitordetail SET status='CheckIn',date=? where VisitorId=?");
			preparedStatement.setInt(2, visitorId);
			preparedStatement.setString(1, date);

			preparedStatement.executeUpdate();
			checkIn = true;
		} catch (SQLException e) {
			checkIn = false;
			e.printStackTrace();

		}

		return checkIn;
	}
	
	
	public ArrayList<VisitorDetailBean> checkedInVisitorDetails() {
		ArrayList<VisitorDetailBean> checkedInVisitorList = new ArrayList<VisitorDetailBean>();

		try {
			con = DBConnection.createConnection();

			statement = con.createStatement();
			resultSet = statement.executeQuery(
					"select VisitorID,VisitorName,MobileNumber,Status,EmailID,Purpose,CheckInTime from VisitorDetail where Status='CheckIn'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				// getting records from database
				VisitorDetailBean visitorDetailBean = new VisitorDetailBean();

				visitorDetailBean.setVisitorID(Integer.toString(resultSet.getInt("VisitorID")));
				visitorDetailBean.setVisitorName(resultSet.getString("VisitorName"));
				visitorDetailBean.setMobileNumber(resultSet.getString("MobileNumber"));
				visitorDetailBean.setEmailId(resultSet.getString("EmailID"));
				//visitorDetailBean.setDate(resultSet.getString("Date"));
				visitorDetailBean.setStatus(resultSet.getString("status"));
				visitorDetailBean.setCheckInTime(resultSet.getString("checkInTime"));
				visitorDetailBean.setPurpose(resultSet.getString("purpose"));
				//visitorDetailBean.setCheckOutTime(resultSet.getString("checkOutTime"));

				checkedInVisitorList.add(visitorDetailBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return checkedInVisitorList;

	}
	
	public boolean checkOut(int visitorId) {
		boolean checkOut;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();
	    String currentDate=date.toString();
	    System.out.println(currentDate);

		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			System.out.println("Coneection object initialized" + con);

			preparedStatement = con
					.prepareStatement("UPDATE visitordetail SET status='CheckOut',CheckOutTime=? where VisitorId=?");
			preparedStatement.setInt(2, visitorId);
			preparedStatement.setString(1, currentDate);

			preparedStatement.executeUpdate();
			checkOut = true;
		} catch (SQLException e) {
			checkOut = false;
			e.printStackTrace();

		}

		return checkOut;
	}
	
	
	
	

}
