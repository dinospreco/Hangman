package database;

import model.Score;
import model.User;

import java.util.ArrayList;

public interface ScoreDAO {

    boolean addScore(Score score);
    Score getScoreById(int id);
    Score getScoreByUser(User user);
    ArrayList<Score> getTopScores();

}
