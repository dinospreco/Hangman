package controller;

import services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/addUser")
public class AddUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/add_User.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        RegistrationService registrationService = new RegistrationService();
        if (registrationService.registerUser(username,password)) {
            req.getRequestDispatcher("/view/add_Success.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/view/addUserFaliure.jsp").forward(req,resp);
        }
    }
}