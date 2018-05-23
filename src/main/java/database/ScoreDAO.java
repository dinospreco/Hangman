package database;

import model.Score;
import model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ScoreDAO {

    boolean addScore(Score score) throws SQLException;
    Score getScoreById(int id) throws SQLException;
    ArrayList<Score> getScoreByUser(User user) throws SQLException;
    ArrayList<Score> getTopScores() throws SQLException;

}
