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

@WebServlet("/game")
public class GameController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Game game = (Game) session.getAttribute("game");

        if (game == null || game.getSolutionPlaceholder() == null) {
            resp.sendRedirect("/newGame");
        }
        else {
            String solution = "";
            for (int i = 0 ; i < game.getSolutionPlaceholder().length() ; i++) {
                solution = solution + " " + game.getSolutionPlaceholder().charAt(i);
            }

            GameLogicService gameLogicService = new GameLogicService();

            req.setAttribute("image", gameLogicService.picturePath(game));
            req.setAttribute("solution", solution);
            req.setAttribute("usedLetters", game.getUsedLetters());
            req.setAttribute("score", game.getScore().getScore());
            req.getRequestDispatcher("view/game.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameLogicService gls = new GameLogicService();

        //TODO Game Filter
        User user = (User) session.getAttribute("user");
        Game game = (Game) session.getAttribute("game");

        String guess = req.getParameter("word");

        String gameResponse = gls.updateGame(game,guess);

        if (gameResponse.startsWith("lost")) {
            req.setAttribute("solution",game.getWord().getWord());
            gls.endGame(game);
            session.removeAttribute("game");
            req.getRequestDispatcher("view/lostGame.jsp").forward(req,resp);
        }
        else if (gameResponse.startsWith("won")) {
            req.setAttribute("word",game.getWord().getWord());
            req.setAttribute("score",game.getScore().getScore());

            gls.endGame(game);
            session.removeAttribute("game");

            req.getRequestDispatcher("view/wonGame.jsp").forward(req,resp);
        }
        else {
            String solution = "";
            for (int i = 0 ; i < game.getSolutionPlaceholder().length() ; i++) {
                solution = solution + " " + game.getSolutionPlaceholder().charAt(i);
            }
            GameLogicService gameLogicService = new GameLogicService();

            req.setAttribute("image", gameLogicService.picturePath(game));
            req.setAttribute("score",game.getScore().getScore());
            req.setAttribute("solution", solution);
            req.setAttribute("usedLetters", game.getUsedLetters());
            req.getRequestDispatcher("view/game.jsp").forward(req,resp);
        }
    }
}
