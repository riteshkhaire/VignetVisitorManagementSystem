package vignet.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vignet.com.bean.VisitorDetailBean;
import vignet.com.service.CheckInService;

/**
 * Servlet implementation class CheckIn
 */
@WebServlet("/CheckIn")
public class CheckIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String visitorName, visitorEmailId, visitorMobileNumber, expectedVisitDate, expectedVisitTime, purpose,idProof,contactPerson,checkIn;
		RequestDispatcher requestDispatcher = null;
		
		
		visitorName = request.getParameter("visitorName");
		visitorEmailId = request.getParameter("visitorEmailId");
		visitorMobileNumber = request.getParameter("visitorMobileNumber");
		idProof= request.getParameter("idProof");
		contactPerson = request.getParameter("contactPerson");
		purpose = request.getParameter("purpose");
		checkIn=request.getParameter("checkIn");
		
		if(checkIn !=null) {
			VisitorDetailBean checkInVisitor=new VisitorDetailBean();
			
			checkInVisitor.setVisitorName(visitorName);
			checkInVisitor.setEmailId(visitorEmailId);
			checkInVisitor.setMobileNumber(visitorMobileNumber);
			checkInVisitor.setPurpose(purpose);
			checkInVisitor.setIdProof(idProof);
			checkInVisitor.setContactPerson(contactPerson);
			System.out.println("CheckIn variable initialized");
			
			CheckInService checkInService=new CheckInService();
			boolean isAdded=checkInService.addVisitor(checkInVisitor);
			System.out.println("CheckIn variable initialized");
			
			if(isAdded){
				PrintWriter out = response.getWriter();
				out.println("<html><body><b>Visitor Deatil Inserted" + "</b></body></html>");
				requestDispatcher = request.getRequestDispatcher("/ReceptionistHome.jsp");
				requestDispatcher.include(request, response);
				
				
			}
			
			
		}
		
		
	}

}
