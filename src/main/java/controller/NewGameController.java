package controller;

import model.Game;
import model.User;
import services.GameLogicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/newGame")
public class NewGameController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        req.setAttribute("username", user.getUsername());

        GameLogicService gameLogicService = new GameLogicService();
        Game game = gameLogicService.gameInit(user);
        session.setAttribute("game",game);

        resp.sendRedirect("/game");

    }
}
