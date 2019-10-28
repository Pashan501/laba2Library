package library.controller;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Statement;

public class UserController {

	private Connection conn;
	private Statement statement;
	private String salt = "solevoy";
	public UserController(Connection conn) 
	{
		this.conn = conn;
	}
	//admin - admin3000
	
	
	
	private String hashString(String hash) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		md5.update(StandardCharsets.UTF_8.encode(hash));
		return String.format("%032x", new BigInteger(md5.digest()));
	}
	
	
}
