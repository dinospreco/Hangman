package database;

import java.sql.SQLException;

import model.User;

public interface UserDAO {

    boolean addUser(User user) throws SQLException;
    User getUserById(int id) throws SQLException;
    User getUserByUsername(String username) throws SQLException;


}
