package database;

import dto.ScoreBoardDTO;
import model.Score;
import model.User;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ScoreDAO {

    boolean addScore(Score score) throws SQLException;
    Score getScoreById(int id) throws SQLException;
    ArrayList<Score> getScoreByUser(User user) throws SQLException;
    ArrayList<ScoreBoardDTO> getTopScores();
    ArrayList<Score> getLastFiveScoresByUser(User user);

}
