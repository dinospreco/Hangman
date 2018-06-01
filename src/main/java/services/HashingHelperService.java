package services;


import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingHelperService {

    public static String hashString(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
            return new String(Hex.encode(hash));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
