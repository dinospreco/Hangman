package controller;

import model.User;
import services.AdminService;
import services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteUser")
public class DeleteUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/delete_User.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        User user = new User();
        user.setUsername(username);

        AdminService adminService = new AdminService();

        if (adminService.deleteUser(user)) {
            req.getRequestDispatcher("/view/remove_Success.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/view/remove_Failure.jsp").forward(req,resp);
        }
    }
}

