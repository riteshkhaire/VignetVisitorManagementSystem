package com.vignet.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vignet.dto.VisitorsDTO;
import com.vignet.service.LoginService;
import com.vignet.service.SignUpService;
import com.vignet.service.VisitorInterface;

import vignet.com.bean.VisitorDetailBean;
import vignet.com.service.GenerateReport;

public class HomeServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = null;
		VisitorsDTO dto = null;
		RequestDispatcher rd = null;
		String userName = null;
		String password = null;
		int count = 0;
		String s1 = null;
		String s2 = null;

		// VisitorInterface loginService = null;

		// read login form data
		s1 = req.getParameter("b1");
		s2 = req.getParameter("b2");

		System.out.println(s1);
		System.out.println(s2);

		if (s1 != null) {
			userName = req.getParameter("uname");
			password = req.getParameter("pwd");

			// create dto class obj
			dto = new VisitorsDTO();

			// set login values to dto class
			dto.setUname(userName);
			dto.setPass(password);
			try {
				// create login class obj
				LoginService loginService = new LoginService();
				String role = loginService.autthenticateUser(dto);
				System.out.println("from home html"+role);

				// count = loginService.result(dto);
				// System.out.println("Select from database" + count);
				if (role.equalsIgnoreCase("receptionist")) {
					GenerateReport generateReport = new GenerateReport();
					ArrayList<VisitorDetailBean> visitorList = generateReport.visitorDetails();

					req.setAttribute("visitorList", generateReport.visitorDetails());

					RequestDispatcher rd1 = req.getRequestDispatcher("/ReceptionistHome.jsp");

					rd1.forward(req, res);
				}
				if (role.equalsIgnoreCase("admin")) {
					GenerateReport generateReport = new GenerateReport();
					ArrayList<VisitorDetailBean> visitorList = generateReport.visitorDetails();
					req.setAttribute("visitorList", generateReport.visitorDetails());
					RequestDispatcher rd1 = req.getRequestDispatcher("/AdminHome.jsp");

					rd1.forward(req, res);
				} if(role.equalsIgnoreCase("invalid")) {
					pw.println("Invalid Credentials");
					
					
					RequestDispatcher rd1 = req.getRequestDispatcher("/login.html");

					rd1.include(req, res);
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (s2 != null) {
			rd = req.getRequestDispatcher("/signup.html");
			rd.forward(req, res);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
}
