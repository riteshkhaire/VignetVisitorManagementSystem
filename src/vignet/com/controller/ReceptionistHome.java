package vignet.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.glass.ui.Size;

import vignet.com.bean.VisitorDetailBean;
import vignet.com.service.GenerateReport;

/**
 * Servlet implementation class ReceptionistHome
 */
@WebServlet("/ReceptionistHome")
public class ReceptionistHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 response.setContentType("text/html");
		String expectedVisitor, checkIn,checkInNewVisitor,checkOut,visitorID,checkOutCheckedIn,report;
		RequestDispatcher requestDispatcher;
		
		PrintWriter printWriter=response.getWriter();

		checkInNewVisitor=request.getParameter("checkInNewVisitor");
		checkOut=request.getParameter("checkOut");
		expectedVisitor = request.getParameter("expectedVisitor");
		checkIn = request.getParameter("checkIn");
		visitorID = request.getParameter("visitorID");
		checkOutCheckedIn=request.getParameter("checkOutCheckedIn");
		report=request.getParameter("report");
		
		// to print reports on Home page
		

		
		
		
		if(checkInNewVisitor != null) {
			requestDispatcher = request.getRequestDispatcher("/CheckIn.jsp");
			requestDispatcher.forward(request, response);
			
		}
		if(checkOut !=null) {
			GenerateReport generateReport = new GenerateReport();
			ArrayList<VisitorDetailBean> checkedInisitorList = generateReport.checkedInVisitorDetails();

			request.setAttribute("visitorList", generateReport.checkedInVisitorDetails());
			requestDispatcher = request.getRequestDispatcher("/CheckOut.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
		
		if (expectedVisitor != null) {
			GenerateReport generateReport = new GenerateReport();
			ArrayList<VisitorDetailBean> visitorList = generateReport.expectedVisitorDetails();

			request.setAttribute("visitorList", generateReport.expectedVisitorDetails());
			requestDispatcher = request.getRequestDispatcher("/ExpectedVisitor.jsp");
			requestDispatcher.forward(request, response);
		}
		
		if (checkIn != null) {
			int vID=Integer.parseInt(visitorID);
			GenerateReport generateReport = new GenerateReport();
			boolean isCheckIn=generateReport.expectedCheckIn(vID);
			if(isCheckIn) {
			ArrayList<VisitorDetailBean> visitorList = generateReport.expectedVisitorDetails();
			request.setAttribute("visitorList", generateReport.expectedVisitorDetails());
			printWriter.print("Visitor checked In, Visitor ID "+vID+" created");
			requestDispatcher = request.getRequestDispatcher("/ExpectedVisitor.jsp");
			requestDispatcher.include(request, response);
			}
		}
		if(report != null) {
			GenerateReport generateReport=new GenerateReport();
			ArrayList<VisitorDetailBean> visitorList=generateReport.visitorDetails();
			request.setAttribute("visitorList", generateReport.visitorDetails());
			System.out.println("from receptionist home"+generateReport.visitorDetails().size());
			requestDispatcher = request.getRequestDispatcher("/ReceptionistReport.jsp");
			requestDispatcher.forward(request, response);
		}
		
		if(checkOutCheckedIn != null) {
			int vID=Integer.parseInt(visitorID);
			GenerateReport generateReport = new GenerateReport();
			boolean isCheckOut=generateReport.checkOut(vID);
			if(isCheckOut) {
				ArrayList<VisitorDetailBean> visitorList = generateReport.expectedVisitorDetails();
				request.setAttribute("visitorList", generateReport.expectedVisitorDetails());
				//printWriter.print(visitorID+" is Checked Out Sucessfully");
				requestDispatcher = request.getRequestDispatcher("/ReceptionistHome.jsp");
				requestDispatcher.include(request, response);
			}
			else {
				printWriter.print("Wrong Visitor ID");
				requestDispatcher = request.getRequestDispatcher("/ReceptionistHome.jsp");
				requestDispatcher.include(request, response);
			}

		}

	}

}
