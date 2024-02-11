package sj.project.portfolio.services;

import java.math.BigInteger;
import java.security.MessageDigest;

public class PasswordEncoder {

    public String encode(String password){
        String result = null;

        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(password.getBytes("utf8"));
            result = String.format("%0128x", new BigInteger(1, digest.digest()));
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return result;
    }
}
