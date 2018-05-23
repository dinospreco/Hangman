package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationService {

    public boolean validPassword(String password) {

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

}
