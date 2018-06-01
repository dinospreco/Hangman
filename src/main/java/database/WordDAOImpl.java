package database;

import model.Word;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WordDAOImpl implements WordDAO {

	private Connection connection = ConnectionManager.getInstance().getConnection();
	private String querry;

	@Override
	public boolean addWord(Word word) {
		querry = "INSERT INTO words (category, word) VALUES (?,?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(querry)) {

			word.setCategory(word.getCategory().toUpperCase());
			word.setWord(word.getWord().toUpperCase());

			preparedStatement.setString(1, word.getCategory());
			preparedStatement.setString(2, word.getWord());

			if (preparedStatement.executeUpdate() == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteWord(Word word) {
		querry = "DELETE FROM words WHERE wordId = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(querry)) {

			word.setCategory(word.getCategory().toUpperCase());
			word.setWord(word.getWord().toUpperCase());

			preparedStatement.setInt(1, word.getWordId());

			if (preparedStatement.executeUpdate() == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Word getWordById(int id) {
		querry = "SELECT FROM words WHERE wordId = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(querry)) {

			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				Word word = new Word();
				word.setWordId(rs.getInt("wordId"));
				word.setCategory(rs.getString("category"));
				word.setWord(rs.getString("word"));

				return word;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Word> getAllWords() {
		querry = "SELECT * FROM words";
		try (PreparedStatement preparedStatement = connection.prepareStatement(querry)) {
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<Word> words = new ArrayList<>();

			while (rs.next()) {
				Word word = new Word();
				word.setWordId(rs.getInt("wordId"));
				word.setCategory(rs.getString("category"));
				word.setWord(rs.getString("word"));
				words.add(word);
			}
			return words;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Word getRandomWord() {
		querry = "SELECT * FROM words ORDER BY  RAND() LIMIT 1";
		try (PreparedStatement preparedStatement = connection.prepareStatement(querry)) {

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				Word word = new Word();
				word.setWordId(rs.getInt("wordId"));
				word.setCategory(rs.getString("category"));
				word.setWord(rs.getString("word"));

				return word;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
