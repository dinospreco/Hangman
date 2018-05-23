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

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
        req.getRequestDispatcher("/view/register.jsp").forward(req,resp);;
=======
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/register.jsp");
        requestDispatcher.forward(req,resp);
>>>>>>> d2f0843d19bfbb247510dfcc40b478cb60692199
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
    	String username,password;
		
		username=req.getParameter("username");
		password=req.getParameter("password");
		
		RegistrationService rs=new RegistrationService();
		String hassedPass=HashingHelperService.hashString(password);
		boolean validUsername=rs.validateUsername(username);
		boolean validPass=rs.validPassword(password);
    	
		RequestDispatcher failure;
		
		if(validUsername && validPass) {
			User user=new User();
			
			user.setUsername(username);
			user.setPasswrod(hassedPass);
			
			if(rs.addUser(user)) {
				RequestDispatcher success = req.getRequestDispatcher("/view/profile.jsp");
				success.forward(req, resp);
			}else {
			failure = req.getRequestDispatcher("/view/register.jsp");
			failure.forward(req, resp);
			}
		}
			failure = req.getRequestDispatcher("/view/register.jsp");
			failure.forward(req, resp);

    }
    
}