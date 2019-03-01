package com.vignet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vignet.dto.VisitorsDTO;
import com.vignet.service.SignUpService;
import com.vignet.service.VisitorInterface;

public class SignUp extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = null;
		VisitorsDTO dto = null;
		RequestDispatcher rd = null;

		int count = 0;

		String name = null;
		String mno = null;
		String uname = null;
		String pass = null;
		String rePass = null;
		String role = null;

		VisitorInterface visitor = null;

		// get printWritter
		pw = res.getWriter();

		// set content type
		res.setContentType("text/html");

		// read signUp from data
		name = req.getParameter("name");
		mno = req.getParameter("no");
		uname = req.getParameter("uname");
		pass = req.getParameter("pwd");
		rePass = req.getParameter("repwd");
		role = req.getParameter("role");
		String signUp = req.getParameter("b2");
		System.out.println(signUp);
		if (signUp != null) {

			// create dto class obj
			dto = new VisitorsDTO();
			// set Sign Up values to dto class
			dto.setName(name);
			dto.setMno(mno);
			dto.setUname(uname);
			dto.setPass(pass);
			dto.setRePass(rePass);
			dto.setRole(role);

			// create SigrnUpService class obj
			visitor = new SignUpService();
			try {

				count = visitor.result(dto);
				System.out.println("VisitorServlet.doGet()" + count);

				rd = req.getRequestDispatcher("/login.html");
				rd.forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
			}
			pw.close();
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
}