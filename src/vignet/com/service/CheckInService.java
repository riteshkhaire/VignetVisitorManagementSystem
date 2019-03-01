package vignet.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import vignet.com.bean.VisitorDetailBean;
import vignet.com.util.DBConnection;

public class CheckInService {

	public boolean addVisitor(VisitorDetailBean checkInVisitor) {
		final String status = "CheckIn";

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);

		String visitorName, visitorEmailId, visitorMobileNumber, purpose, idProof, contactPerson;
		visitorName = checkInVisitor.getVisitorName();
		visitorEmailId = checkInVisitor.getEmailId();
		visitorMobileNumber = checkInVisitor.getMobileNumber();
		purpose = checkInVisitor.getPurpose();
		idProof = checkInVisitor.getIdProof();
		contactPerson = checkInVisitor.getContactPerson();

		Connection con;
		PreparedStatement preparedStatement = null;
		try {

			con = DBConnection.createConnection();
			System.out.println("Inserting check in detail to db");
			preparedStatement = con.prepareStatement(
					"insert into visitordetail(VisitorName,EmailId,purpose,MobileNumber,status,ContactPerson,IdProof,CheckInTime) values(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, visitorName);
			preparedStatement.setString(2, visitorEmailId);
			preparedStatement.setString(3, purpose);
			preparedStatement.setString(4, visitorMobileNumber);
			preparedStatement.setString(5, status);
			preparedStatement.setString(6, contactPerson);
			preparedStatement.setString(7, idProof);
			preparedStatement.setString(8, currentDate);

			preparedStatement.executeUpdate();

			System.out.println("Check in Visitor Data Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

}
