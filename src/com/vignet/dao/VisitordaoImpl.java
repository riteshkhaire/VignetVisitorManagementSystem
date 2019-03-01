package com.vignet.dao;

import java.sql.DriverManager;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.vignet.bo.VisitorsBO;

public class VisitordaoImpl implements VisitorsDAO {

	private static final String Recption = "INSERT INTO RECEPTIONIST_INFO VALUES(?,?,?,?,?,?)";
	private static final String Authentication = "SELECT COUNT(*) FROM RECEPTIONIST_INFO WHERE UNAME=? AND PASS =?";

	public static Connection getConnection() {
		Connection con = null;
		try {

			// load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// establish the connection
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/visitormanagementsystem", "root",
					"admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public int insert(VisitorsBO bo) {
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;

		try {

			con = VisitordaoImpl.getConnection();
			// create PreparedStatement
			ps = (PreparedStatement) con.prepareStatement(Recption);
			// set the value to preparedStatement

			ps.setString(1, bo.getName());
			ps.setString(2, bo.getMno());
			ps.setString(3, bo.getUname());
			ps.setString(4, bo.getPass());
			ps.setString(5, bo.getRePass());
			ps.setString(6, bo.getRole());

			// execute query
			count = ps.executeUpdate();
			System.out.println();
			System.out.println("VisitordaoImpl.insert()" + count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return count;
	}

	// retrive usename and password from database
	@Override
	public int select(VisitorsBO bo) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String uname = null;
		String pass = null;
		int count = 0;

		try {

			con = VisitordaoImpl.getConnection();
			// create PreparedStatement obj
			ps = (PreparedStatement) con.prepareStatement(Authentication);
			// set the value to preparedStatement
			ps.setString(1, bo.getUname());
			ps.setString(2, bo.getPass());
			// execute query
			rs = (ResultSet) ps.executeQuery();

			if (rs != null) {

				if (rs.next()) {
					count = rs.getInt(1);

				}
			}
			if (count != 0) {
				System.out.println("valid credential");
			} else {
				System.out.println("incvalid credential");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		finally {
			try {
				ps.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return count;
	}
}
