package services;

import database.UserDAO;
import database.UserDAOImpl;
import database.WordDAO;
import database.WordDAOImpl;
import model.User;
import model.Word;
import org.w3c.dom.UserDataHandler;

public class AdminService {

    public boolean validWord(String word) {
        return word.length() >= 5;
    }


    public boolean addWord(Word word) {
        WordDAO wordDAO = new WordDAOImpl();
        return wordDAO.addWord(word);
    }

    public boolean deleteUser(User user) {
        UserDAO userDAO = new UserDAOImpl();
        if (userDAO.getUserByUsername(user.getUsername()) != null) {
            return userDAO.deleteUser(user);
        }
        else return false;
    }
}
