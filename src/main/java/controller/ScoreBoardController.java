package controller;

import dto.ScoreBoardDTO;
import services.ScoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/scoreboard")
public class ScoreBoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScoreService scoreService = new ScoreService();
        ArrayList<ScoreBoardDTO> topList = scoreService.getTopScores();
        req.setAttribute("scores" , topList);
        req.getRequestDispatcher("view/scoreboard.jsp").forward(req,resp);
    }
}
