package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import services.RegistrationService;

public class RegistrationController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String username,password;
		
		username=req.getParameter("username");
		password=req.getParameter("password");
		
		RegistrationService RS=new RegistrationService();
		RequestDispatcher failure;
		boolean validUsername=RS.validateUsername(username);
		
		if(validUsername) {
			User user=new User();
			
			user.setUsername(username);
			user.setPasswrod(password);
			if(RS.addUser(user)) {
				RequestDispatcher success = req.getRequestDispatcher("view/home.jsp");
				success.forward(req, resp);
			}else {
			failure = req.getRequestDispatcher("view/registration.jsp");
			failure.forward(req, resp);
			}
		}
			failure = req.getRequestDispatcher("view/registration.jsp");
			failure.forward(req, resp);
		}	
	}
