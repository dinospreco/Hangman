package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import services.LoginService;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user=new User();
        user.setUsername(username);
        user.setPasswrod(password);
        
        LoginService LG=new LoginService();
        boolean logged=LG.login(user);
        
        if(logged) {
        	
        	HttpSession session=req.getSession();
        	session.setAttribute("user",user);
        	
        	RequestDispatcher success=req.getRequestDispatcher("/view/profile.jsp");
        	success.forward(req, resp);
        }else {
        	RequestDispatcher failure=req.getRequestDispatcher("/view/home.jsp");
        	failure.forward(req, resp);
        }
        
    }
}
