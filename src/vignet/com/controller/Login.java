package vignet.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vignet.com.bean.LoginBean;
import vignet.com.service.LoginService;

/**
 * Servlet implementation class Login
 */
@WebServlet(description = "Login page to vignet visitor management system", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName, password,signIn,signUp;
		RequestDispatcher requestDispatcher = null;
		//reading from UI and storing response in local variable

		userName = request.getParameter("userName");
		password = request.getParameter("password");
		
		signIn=request.getParameter("signIn");
		signUp=request.getParameter("signUp");
		
		if(signIn != null) {
			LoginBean loginBean = new LoginBean(); // creating bean object
			loginBean.setUserName(userName);
			loginBean.setPassword(password);

			// Calling login service class method
			LoginService ls = new LoginService();

			String userValidate = ls.autthenticateUser(loginBean);
			System.out.println(userValidate);
			
			if (userValidate.equals("Sucusses")) {
				request.setAttribute("userName", userName);
				requestDispatcher = request.getRequestDispatcher("/ReceptionistHome.jsp");
				requestDispatcher.forward(request, response);
			} else {
				request.setAttribute("errMessage", userValidate);
				requestDispatcher = request.getRequestDispatcher("/Login.jsp");
				requestDispatcher.forward(request, response);

			}

			/*
			 * boolean result=ls.authenticate(userName, password); if(result) {
			 * response.sendRedirect("/ReceptionistHome.html"); return; } else {
			 * response.sendRedirect("Visitor_Management_System/WebContent/Login.html");
			 * return;
			 * 
			 * }
			 */

			
		}
		else if(signUp != null)
		{
			requestDispatcher=request.getRequestDispatcher("/SignUp.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
	}

}
