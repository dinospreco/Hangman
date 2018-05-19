package database;

import model.User;

public interface UserDAO {

    boolean addUser(User user);
    User getUserById(int id);
    User getUserByUsername(String username);


}
