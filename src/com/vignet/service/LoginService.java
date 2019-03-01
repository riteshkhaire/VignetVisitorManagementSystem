package com.vignet.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vignet.bo.VisitorsBO;
import com.vignet.dao.VisitordaoImpl;
import com.vignet.dao.VisitorsDAO;
import com.vignet.dto.VisitorsDTO;

import vignet.com.bean.LoginBean;
import vignet.com.util.DBConnection;

public class LoginService implements VisitorInterface {

	VisitorsDAO dao = null;

	public LoginService() {

		dao = new VisitordaoImpl();

	}

	@Override
	public int result(VisitorsDTO dto) throws Exception {

		int count = 0;
		VisitorsBO bo = null;

		// prepare bo class obj having persistance data
		bo = new VisitorsBO();

		bo.setUname(dto.getUname());
		bo.setPass(dto.getPass());

		// use DAO
		count = dao.select(bo);

		// validate username and password
		if (count != 0) {
			System.out.println("your valid credential");
		} else {
			System.out.println("Invalid credential");
		}

		return count;
	}

	public boolean checkPass(String s1, String s2) {
		return false;

	}

	public String autthenticateUser(VisitorsDTO dto) {
		String role = "";
		String userName = dto.getUname();
		String password = dto.getPass();

		Connection con;
		Statement statement = null;
		ResultSet resultSet = null;

		String DBUserName = "";
		String DBPassword = "";

		try {

			con = DBConnection.createConnection();
			System.out.println("Coneection object initialized" + con);

			statement = con.createStatement();
			resultSet = statement.executeQuery("select uname,pass,role from Receptionist_info");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (resultSet.next()) {
				DBUserName = resultSet.getString("uname");
				DBPassword = resultSet.getString("pass");
				System.out.println("******* Values from DB************");
				System.out.println(DBUserName);
				System.out.println(DBPassword);

				if (userName.equals(DBUserName) && password.equals(DBPassword)) {
					role = resultSet.getString("role");
					System.out.println("Role from db" + role);
					return role;
				}
				

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return role;

	}

}
