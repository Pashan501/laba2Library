package library.controller;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library.model.User;

public class UserController {

	private Connection conn;
	private Statement statement;
	private String salt = "solevoy";
	
	
	public UserController(Connection conn) 
	{
		this.conn = conn;
	}

	
	public User getUserById(int id) 
	{
		User user = null;
		String GET_USER_BY_ID = "SELECT * FROM User WHERE id="+id;
		try {
			statement = getConnection().createStatement();
			ResultSet rs= statement.executeQuery(GET_USER_BY_ID);
			while(rs.next()) 
			{
				user.setId(Integer.parseInt(rs.getString(1)));
				user.setName(rs.getString(2));
				user.setSurName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setCountry(rs.getString(5));
				user.setCity(rs.getString(6));
				user.setStreet(rs.getString(7));
				user.setPassword(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	
//	public boolean userValidate(String email, String password) 
//	{
//		
//	}
	
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
	private Connection getConnection() 
	{
		return this.conn;
	}
	
}
