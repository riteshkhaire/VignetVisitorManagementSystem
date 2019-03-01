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


@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addExpectedVisitors,report;
		RequestDispatcher requestDispatcher = null;
		
		
		addExpectedVisitors=request.getParameter("addExpectedVisitors");
		report=request.getParameter("report");
		System.out.println(report);
		
		if(addExpectedVisitors != null) {
			//request.setAttribute("userName", userName);
			requestDispatcher = request.getRequestDispatcher("/AddExpectedVisitor.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(report != null)
		{
			GenerateReport generateReport=new GenerateReport();
			ArrayList<VisitorDetailBean> visitorList=generateReport.visitorDetails();
			
			request.setAttribute("visitorList", generateReport.visitorDetails());
			requestDispatcher = request.getRequestDispatcher("/Report.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
		
	}

}
