package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import services.HashingHelperService;
import services.RegistrationService;

import java.io.IOException;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/register.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
    	String username,password;
		
		username=req.getParameter("username");
		password=req.getParameter("password");
		
		RegistrationService registrationService = new RegistrationService();
		if (registrationService.registerUser(username,password)) {
			req.getRequestDispatcher("view/registrationSucces.jsp").forward(req,resp);
		}
		else {
            req.getRequestDispatcher("view/registrationFaliure.jsp").forward(req,resp);
        }

    }
    
}