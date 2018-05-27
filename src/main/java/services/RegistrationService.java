package services;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import database.UserDAO;
import database.UserDAOImpl;
import model.User;

public class RegistrationService {

    private boolean validPassword(String password) {

        //WARNING! This is black magic, dont touch it!
        //Source: https://www.quora.com/How-do-I-write-a-regex-for-a-string-that-contains-alphanumeric-characters-having-at-least-one-uppercase-letter-one-lowercase-letter-and-one-digit
        Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,})");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean validateUsername(String username) {
    	
		UserDAO userDAO=new UserDAOImpl();
		User userCheck=null;

		userCheck = userDAO.getUserByUsername(username);

		
		if(userCheck.getUsername()==null) {
			return true;
		}else {
			return false;
		}
    }

	private boolean addUser(User user)  {
			
			UserDAOImpl userDAO=new UserDAOImpl();
			return userDAO.addUser(user);
				
	}

	public boolean registerUser(String username, String password) {
        if (validateUsername(username) && validPassword(password)) {
            User user = new User();
            user.setUsername(username);
            user.setPasswrod(HashingHelperService.hashString(password));

            if (addUser(user)) {
                return true;
            }
            else {
                return false;
            }


        }
        return false;
    }
}
