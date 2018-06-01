package database;

import java.sql.SQLException;

import model.User;

public interface UserDAO {

    boolean addUser(User user);
    User getUserById(int id);
    User getUserByUsername(String username);
    boolean deleteUser(User user);


}
