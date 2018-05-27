package services;

import database.UserDAO;
import database.UserDAOImpl;
import model.User;
import java.sql.SQLException;

public class LoginService {


    public User login(User user) {
        UserDAO userDAO = new UserDAOImpl();

        User checkUser = userDAO.getUserByUsername(user.getUsername());

        if (checkUser == null) {
            return null;
        }
        else if (checkUser.getPasswrod().equals(HashingHelperService.hashString(user.getPasswrod()))) {
            checkUser.setPasswrod("");
            return checkUser;
        }
        else {
            return null;

        }

    }

}
