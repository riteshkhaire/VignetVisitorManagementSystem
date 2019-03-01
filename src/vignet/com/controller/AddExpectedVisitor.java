package vignet.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vignet.com.bean.AddExpectedVisitorDetailBean;
import vignet.com.bean.VisitorDetailBean;
import vignet.com.service.AddExpectedVisitorService;
import vignet.com.service.GenerateReport;

/**
 * Servlet implementation class AddExpectedVisitor
 */
@WebServlet("/AddExpectedVisitor")
public class AddExpectedVisitor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String visitorName, visitorEmailId, visitorMobileNumber, expectedVisitDate, expectedVisitTime, purpose;
		String addDetails, addExpectedVisitors, report;
		RequestDispatcher requestDispatcher = null;
		visitorName = request.getParameter("visitorName");
		visitorEmailId = request.getParameter("visitorEmailId");
		visitorMobileNumber = request.getParameter("visitorMobileNumber");
		expectedVisitDate = request.getParameter("expectedVisitDate");
		expectedVisitTime = request.getParameter("expectedVisitTime");
		purpose = request.getParameter("purpose");
		addDetails = request.getParameter("addDetails");
		addExpectedVisitors = request.getParameter("addExpectedVisitors");
		report = request.getParameter("report");

		if (addDetails != null) {
			AddExpectedVisitorDetailBean addExpectedVisitorBean = new AddExpectedVisitorDetailBean();

			addExpectedVisitorBean.setVisitorName(visitorName);
			addExpectedVisitorBean.setExpectedVisitDate(expectedVisitDate);
			addExpectedVisitorBean.setExpectedVisitTime(expectedVisitTime);
			addExpectedVisitorBean.setPurpose(purpose);
			addExpectedVisitorBean.setVisitorEmailId(visitorEmailId);
			addExpectedVisitorBean.setVisitorMobileNumber(visitorMobileNumber);

			AddExpectedVisitorService addExpectedVisitorService = new AddExpectedVisitorService();
			boolean isAdded = addExpectedVisitorService.validateExpectedVisitorAdded(addExpectedVisitorBean);
			if (isAdded) {
				requestDispatcher = request.getRequestDispatcher("/AdminHome.jsp");
				requestDispatcher.forward(request, response);
				PrintWriter out = response.getWriter();
				out.println("<html><body><b>Visitor Deatil Inserted" + "</b></body></html>");

			}

		}
		if(addExpectedVisitors != null) {
			requestDispatcher = request.getRequestDispatcher("/AddExpectedVisitor.jsp");
			requestDispatcher.forward(request, response);
		}
		
		if(report != null) {
			
			GenerateReport generateReport=new GenerateReport();
			ArrayList<VisitorDetailBean> visitorList=generateReport.visitorDetails();
			
			request.setAttribute("visitorList", generateReport.visitorDetails());
			requestDispatcher = request.getRequestDispatcher("/Report.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
		

	}

}
