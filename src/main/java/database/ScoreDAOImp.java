package database;

import model.Score;
import model.User;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScoreDAOImp implements ScoreDAO {
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public boolean addScore(Score score) throws SQLException {

		String query = "Insert into Scores (scoreId,userId,score) values (? ? ?  ) ";
		Score score1 = new Score();
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, score1.getScoreId());
			statement.setInt(2, score1.getUserId());
			statement.setInt(3, score1.getScore());
			statement.executeUpdate();
		}
		return false;

	}

	@Override
	public Score getScoreById(int id) throws SQLException {
		String query = "Select * from Scores where scoreId=?";
		ResultSet rs = null;
		Score score = new Score();
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);

			rs = statement.executeQuery();

			if (rs.next()) {

				score.setScoreId(rs.getInt("scoreId"));
				score.setUserId(rs.getInt("userID"));
				score.setScore(rs.getInt("score"));
				rs.close();
			}
		}
		return score;
	}

	@Override
	public Score getScoreByUser(User user) throws SQLException {
		String query = "Select * from Scores where userId=?";
		ResultSet rs = null;
		Score score = new Score();
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, user.getUserId());
			rs = statement.executeQuery();

			if (rs.next()) {

				score.setScoreId(rs.getInt("scoreId"));
				score.setUserId(rs.getInt("userID"));
				score.setScore(rs.getInt("score"));
				rs.close();

			}
		}
		return score;
	}

	@Override
	public ArrayList<Score> getTopScores() throws SQLException {
		String query = "Select * from Scores order by score DESC limit 10";
		ArrayList<Score> scores = new ArrayList<>();
		ResultSet rs = null;
		Score score = new Score();
		Statement statement = (Statement) connection.createStatement();
		rs = ((java.sql.Statement) statement).executeQuery(query);

		if (rs.next()) {

			score.setScoreId(rs.getInt("scoreId"));
			score.setUserId(rs.getInt("userID"));
			score.setScore(rs.getInt("score"));
			scores.add(score);
			rs.close();

		}

		return scores;
	}
}
