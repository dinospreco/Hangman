package controller;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher home = req.getRequestDispatcher("view/home.jsp");
        home.forward(req,resp);

        //TODO ovo tereba izbrisat, samo je za testiranje
        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("user");
        User user = new User();
        user.setUserId(1);
        user.setUsername("spreco");
        session.setAttribute("user",user);
        //

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Ovdje redirekta sve na Login controller.

    }
}
