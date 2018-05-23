package database;

import model.Score;
import model.User;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScoreDAOImpl implements ScoreDAO {
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public boolean addScore(Score score){

		String query = "Insert into scores (userId,score) values (?,?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, score.getUserId());
			statement.setInt(2, score.getScore());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Score getScoreById(int id) {
		String query = "Select * from scores where scoreId=?";
		ResultSet rs = null;
		Score score = new Score();
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);

			rs = statement.executeQuery();

			if (rs.next()) {

				score.setScoreId(rs.getInt("scoreId"));
				score.setUserId(rs.getInt("userId"));
				score.setScore(rs.getInt("score"));
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return score;
	}

	@Override
	public ArrayList<Score> getScoreByUser(User user) {
		ArrayList<Score> scores = new ArrayList<Score>();
		String query = "Select * from scores where userId=?";
		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, user.getUserId());
			rs = statement.executeQuery();

			while (rs.next()) {
				Score score = new Score();
				score.setScoreId(rs.getInt("scoreId"));
				score.setUserId(rs.getInt("userID"));
				score.setScore(rs.getInt("score"));
				scores.add(score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scores;
	}

	@Override
	public ArrayList<Score> getTopScores() {
		String query = "Select * from scores order by score DESC limit 10";
		ArrayList<Score> scores = new ArrayList<>();
		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			rs = statement.executeQuery();

			while (rs.next()) {
				Score score = new Score();
				score.setScoreId(rs.getInt("scoreId"));
				score.setUserId(rs.getInt("userId"));
				score.setScore(rs.getInt("score"));
				scores.add(score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scores;


	}
}
