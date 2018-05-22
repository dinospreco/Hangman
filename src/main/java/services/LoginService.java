package services;

import database.UserDAO;
import database.UserDAOImpl;
import model.User;
import java.sql.SQLException;

public class LoginService {


    public boolean login(User user) {
        UserDAO userDAO = new UserDAOImpl();

        try {
            User checkUser = userDAO.getUserByUsername(user.getUsername());
            if (checkUser == null) {
                return false;
            }
            else if (HashingHelperService.hashString(checkUser.getPasswrod()).equals(HashingHelperService.hashString(user.getPasswrod()))) {
                user = checkUser;
                user.setPasswrod("");
                return true;
            }
            else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
