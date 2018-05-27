package services;

import database.WordDAOImpl;
import model.Word;

public class SuperUserService {

	private boolean validWord(String word) {
		if (word.length() < 5) {
			return false;
		}
		return true;
	}

	public boolean addWord(Word word) {
		WordDAOImpl word1 = new WordDAOImpl();
		
		
		if (validWord(word.getWord()) == true) {
			word1.addWord(word);
			return true;
		}
		return false;

	}

	public boolean login(String password) {

	    return  true;
    }

}
