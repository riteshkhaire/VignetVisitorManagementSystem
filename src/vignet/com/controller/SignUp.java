package vignet.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vignet.com.bean.SignUpBean;
import vignet.com.service.SignUpService;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newName,newUserMobile,newUserName,newUserPassword,role,signUp;
		RequestDispatcher requestDispatcher=null;
		newName= request.getParameter("newName");
		newUserMobile=request.getParameter("newUserMobile");
		newUserName=request.getParameter("newUserName");
		newUserPassword=request.getParameter("newUserPassword");
		role=request.getParameter("role");
		signUp=request.getParameter("signUp");
		
		if(signUp !=null) {
			SignUpBean signUpBean=new SignUpBean();
			signUpBean.setNewName(newName);
			signUpBean.setNewUserMobile(newUserMobile);
			signUpBean.setNewUserName(newUserName);
			signUpBean.setNewUserPassword(newUserPassword);
			signUpBean.setRole(role);
			
			SignUpService signUpService=new SignUpService();
			boolean isUserNameAvialable=signUpService.checkUserNameAvilability(signUpBean);
			
				if(isUserNameAvialable) {
					boolean isSignUpSuccess=signUpService.validateSignUp(signUpBean);
						if(isSignUpSuccess) {
							request.setAttribute("userName", newUserName);
							requestDispatcher = request.getRequestDispatcher("/Login.jsp");
							requestDispatcher.forward(request, response);	
						}
						else {
							request.setAttribute("errMessage", isUserNameAvialable);
							requestDispatcher = request.getRequestDispatcher("/SignUp.jsp");
							requestDispatcher.forward(request, response);
						}
					
					
					
				}
			
			
			
			
			
		}//if
		
		
	}

}
