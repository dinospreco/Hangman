package controller;

import model.Score;
import model.User;
import services.ScoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        ScoreService scoreService = new ScoreService();
        User user = (User) session.getAttribute("user");
        ArrayList<Score> scores = scoreService.getLastFiveScoresByUser(user);
        req.setAttribute("scores", scores);
        req.setAttribute("username", user.getUsername());
        req.getRequestDispatcher("view/profile.jsp").forward(req,resp);


    }

}
