package com.vignet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoleServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = null;

		String r1 = null;
		String r2 = null;
		String r3 = null;

		pw = res.getWriter();

		// set content type
		res.setContentType("text/html");

		// raed the value from table

		r1 = req.getParameter("checkInNewVisitor");
		r2 = req.getParameter("checkOut");
		r3 = req.getParameter("ExpectedVisitor");
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		
		if (r1.equalsIgnoreCase("checkInNewVisitor")) 
		{
			RequestDispatcher rd = req.getRequestDispatcher("/check.html");
			rd.forward(req, res);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
