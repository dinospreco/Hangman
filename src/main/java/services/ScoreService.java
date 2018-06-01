package services;

import database.ScoreDAO;
import database.ScoreDAOImpl;
import dto.ScoreBoardDTO;
import model.Score;
import model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ScoreService {

    public ArrayList<Score> getLastFiveScoresByUser(User user) {
        ScoreDAO scoreDAO = new ScoreDAOImpl();
        ArrayList<Score> scores = scoreDAO.getLastFiveScoresByUser(user);

        return scores;

    }

    public ArrayList<ScoreBoardDTO> getTopScores() {
        ArrayList<ScoreBoardDTO> scoreBoard = new ArrayList<>();
        ScoreDAO scoreDAO = new ScoreDAOImpl();
        scoreBoard = scoreDAO.getTopScores();
        return scoreBoard;
    }
}
