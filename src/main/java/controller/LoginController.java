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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/home.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user=new User();
        user.setUsername(username);
        user.setPasswrod(password);

        if (username.equals("admin")) {
            resp.sendRedirect("/");
        }

        LoginService LG = new LoginService();
//        boolean logged = LG.login(user);

        if((user = LG.login(user)) != null) {
        	HttpSession session=req.getSession();
        	user.setPasswrod("");
        	session.setAttribute("user",user);
            resp.sendRedirect("/profile");

        }else {
            resp.sendRedirect("/");
        }
        
    }
}
