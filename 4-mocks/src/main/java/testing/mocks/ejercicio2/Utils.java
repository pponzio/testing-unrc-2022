package testing.mocks.ejercicio2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
	 
    public static String getPasswordHashMD5(String password) {
    	
		String passwordHash = null;
	    MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(password.getBytes());
		    passwordHash = new String(md5.digest());
		} catch (NoSuchAlgorithmException e) {
			// No puede ocurrir, MD5 esta implementado.
		}
	    
	    return passwordHash;
    }
    
}
