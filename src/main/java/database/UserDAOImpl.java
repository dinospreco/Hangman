package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAOImpl implements UserDAO {
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public boolean addUser(User user) throws SQLException {
		String query = "Insert into Users (userId,username,password) values (? ? ?  ) ";
		User user1 = new User();
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, user1.getUserId());
			statement.setString(2, user1.getUsername());
			statement.setString(3, user1.getPasswrod());
			statement.executeUpdate();
		}
		return false;
	}

	@Override
	public User getUserById(int id) throws SQLException {
		String query = "Select * from Users where userId=?";
		ResultSet rs = null;
		User user = new User();
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);

			rs = statement.executeQuery();

			if (rs.next()) {

				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPasswrod(rs.getString("password"));
				rs.close();
			}
		}
		return user;
	}

	@Override
	public User getUserByUsername(String username) throws SQLException {

		String query = "Select * from Users where username=?";
		ResultSet rs = null;
		User user = new User();
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);

			rs = statement.executeQuery();

			if (rs.next()) {

				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPasswrod(rs.getString("password"));
				rs.close();
			}
		}
		return user;

	}
}
