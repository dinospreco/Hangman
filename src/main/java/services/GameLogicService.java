package services;

import database.WordDAO;
import database.WordDAOImpl;
import model.Game;
import model.Score;
import model.User;

public class GameLogicService {

    public Game gameInit(User user) {
        Game game = new Game();
        WordDAO wordDAO = new WordDAOImpl();

        game.setUser(user);

        Score score = new Score();
        score.setUserId(user.getUserId());
        score.setScore(100);

        game.setScore(score);

        game.setWord(wordDAO.getRandomWord());

        game.setMisses(0);

        return game;
    }

    public String[] updateGame(Game game, String guess) {
        guess = guess.toUpperCase();

        return null;
    }

}
