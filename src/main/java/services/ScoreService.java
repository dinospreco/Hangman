package services;

import database.ScoreDAO;
import database.ScoreDAOImpl;
import model.Score;
import model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class ScoreService {

    public ArrayList<Score> getLastFiveScoresByUser(User user) {
        ScoreDAO scoreDAO = new ScoreDAOImpl();
        ArrayList<Score> scores = scoreDAO.getLastFiveScoresByUser(user);

        return scores;

    }
}
