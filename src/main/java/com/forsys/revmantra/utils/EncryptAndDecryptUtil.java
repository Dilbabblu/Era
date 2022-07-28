package com.forsys.revmantra.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptAndDecryptUtil {
	
	private static final Logger logger = LogManager.getLogger(EncryptAndDecryptUtil.class);
	
	private static SecretKeySpec secretKey;

	private static SecureRandom random = new SecureRandom();
	
	private EncryptAndDecryptUtil() {
		//not called
	}
	
	public static String encrypt(String key,String token) throws NoSuchAlgorithmException, InvalidKeySpecException, 
					NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException, 
					IllegalBlockSizeException, BadPaddingException{
		
		PBEKeySpec pbeKeySpec = new PBEKeySpec(key.toCharArray());
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(CONSTANTS.PBE_WITH_MD5_AND_TRIPLE_DES);
		SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);

		byte[] salt = new byte[8];
		random.nextBytes(salt);
	
		PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
		Cipher cipher = Cipher.getInstance(CONSTANTS.PBE_WITH_MD5_AND_TRIPLE_DES);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, pbeParameterSpec);
		    String charSet = "UTF-8";
	        byte[] inToken = token.getBytes(charSet);
	        byte[] outToken = cipher.doFinal(inToken);
	        String encryptedToken = new String(Base64.getEncoder().encode(outToken));
	        String saltKey=new String(Base64.getEncoder().encode(salt));
	        logger.info("The encrypted token is: {}", encryptedToken);
	        return saltKey+encryptedToken;
			
				
	}
	
	public static String[] decrypt(String key,String token) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
		
		
		logger.info("The token is: {}", token);
	
		PBEKeySpec pbeKeySpec = new PBEKeySpec(key.toCharArray());
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(CONSTANTS.PBE_WITH_MD5_AND_TRIPLE_DES);
		SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
		String getSaltKey=token.substring(0,12);
		byte[] saltKey=  Base64.getDecoder().decode(getSaltKey.getBytes());
		PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(saltKey, 100);

		Cipher cipher1 = Cipher.getInstance(CONSTANTS.PBE_WITH_MD5_AND_TRIPLE_DES);
		cipher1.init(Cipher.DECRYPT_MODE, secretKey, pbeParameterSpec);
	
		String decryptToke=token.substring(12, token.length());
		logger.info(decryptToke);
		
		byte[] enc = Base64.getDecoder().decode(decryptToke.getBytes(StandardCharsets.UTF_8));
		byte[] utf8 = cipher1.doFinal(enc);
    
		String charSet1 = "UTF-8";
		String decryptedToken = new String(utf8, charSet1);
		return decryptedToken.split("/");
		
	}
	
	public static String encryptPassword(String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
		
	}
	
	
	 
    public static void setKey(String myKey) {
    	byte[] key;
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            logger.error("error occurred",e);
        } 
       
    }
    
    //Required in future
 
    public static String encryptDBPassword(String strToEncrypt, String secret){
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } 
        catch (Exception e) 
        {
          logger.info("Error while encrypting: {}", e.toString());
        }
        return null;
    }
 
    public static String decryptDBPassword(String strToDecrypt, String secret) {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
        	logger.info("Error while decrypting: {}", e.toString());
        }
        return null;
    }

}
