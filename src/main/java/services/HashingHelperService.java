package services;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingHelperService {

    public static String hashString(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(string.getBytes());
            return new String(messageDigest.digest());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
