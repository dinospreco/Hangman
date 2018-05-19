package database;

import model.Score;
import model.User;

import java.util.ArrayList;

public class ScoreDAOImp implements ScoreDAO {

    @Override
    public boolean addScore(Score score) {
        return false;
    }

    @Override
    public Score getScoreById(int id) {
        return null;
    }

    @Override
    public Score getScoreByUser(User user) {
        return null;
    }

    @Override
    public ArrayList<Score> getTopScores() {
        return null;
    }
}
