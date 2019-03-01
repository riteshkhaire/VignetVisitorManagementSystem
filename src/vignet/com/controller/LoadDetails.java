package vignet.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vignet.com.bean.VisitorDetailBean;
import vignet.com.service.GenerateReport;

/**
 * Servlet implementation class LoadDetails
 */
@WebServlet("/LoadDetails")
public class LoadDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher=null;
		System.out.println("Inside LoadDetails");
		
		GenerateReport generateReport=new GenerateReport();
		ArrayList<VisitorDetailBean> visitorList=generateReport.visitorDetails();
		
		request.setAttribute("visitorList", generateReport.visitorDetails());
		 requestDispatcher=request.getRequestDispatcher("/ReceptionistHome.jsp");
		requestDispatcher.forward(request,response);
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	


}
