package services;

import database.UserDAO;
import database.UserDAOImpl;
import model.User;

public class RegistrationService {
	
	public boolean validateUsername(String username) {
		UserDAO userDAO=new UserDAOImpl();
		User userCheck=userDAO.getUserByUsername(username);
		
		if(userCheck==null) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean addUser(User user)  {
		
		UserDAOImpl userDAO=new UserDAOImpl();
		return userDAO.addUser(user);
		
		
	}
	
	
}
