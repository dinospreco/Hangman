package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import services.HashingHelperService;

public class UserDAOImpl implements UserDAO {
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public boolean addUser(User user) {
		String query = "Insert into users (username,passhash) values (?, ?) ";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPasswrod());

			if(statement.executeUpdate() == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public User getUserById(int id){
		String query = "Select * from users where userId=?";
		ResultSet rs = null;
		User user = new User();
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);

			rs = statement.executeQuery();

			if (rs.next()) {
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPasswrod(rs.getString("passhash"));
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return user;
	}

	@Override
	public User getUserByUsername(String username) {

		String query = "Select * from users where username=?";
		ResultSet rs = null;
		User user = new User();

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);

			rs = statement.executeQuery();

			if (rs.next()) {

				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPasswrod(rs.getString("passhash"));
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;

	}

	@Override
	public boolean deleteUser(User user) {
		String query = "Delete from users where username=?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, user.getUsername());

			if(statement.executeUpdate() == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
