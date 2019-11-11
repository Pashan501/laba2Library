package library.controller;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library.fabric.MySQLConnector;
import library.model.User;

public class UserController {

	private MySQLConnector connector;
	private Statement selectStmt;
	private Statement insertStmt;
	private String salt = "solevoy";
	
	//private final static String INSERT_USER = "INSERT INTO users(name,surName,email, password , name , country , city , street)"+ 
		//	"VALUES ('?', '?', '?', '?','?', '?','?','?')";

	public UserController(MySQLConnector conn) 
	{
		this.connector = conn;
	}

	
	public User insertUser(String name,String surname, String email, String pass, String country, String city, String street) {
		User user =null;
		String INSERT_USER = "INSERT INTO users(name,surName,email, password , name , country , city , street)"+ 
				"VALUES ('?', '?', '?', '?','?', '?','?','?')";
		
		
		try {
			try {
				insertStmt = connector.getConnection().createStatement();
				if(insertStmt.execute(INSERT_USER)) {
				System.out.println("Inserted successfully...");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}finally
		{
			
		}
		
		
		return user;
	}
	
	
	public User getUserById(int id) 
	{
		User user = null;
		String GET_USER_BY_ID = "SELECT * FROM User WHERE id="+id+";";
		try {
			selectStmt = connector.getConnection().createStatement();
			ResultSet rs= selectStmt.executeQuery(GET_USER_BY_ID);
			while(rs.next()) 
			{
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2)==null?" ":rs.getString(2));
				user.setSurName(rs.getString(3)==null?" ":rs.getString(3));
				user.setEmail(rs.getString(4)==null?" ":rs.getString(4));
				user.setCountry(rs.getString(5)==null?" ":rs.getString(5));
				user.setCity(rs.getString(6)==null?" ":rs.getString(6));
				user.setStreet(rs.getString(7)==null?" ":rs.getString(7));
				user.setPassword(rs.getString(8)==null?" ":rs.getString(8));
				user.setType(rs.getString(9));
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
	public String hash(String password) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(StandardCharsets.UTF_8.encode(password+salt));
		System.out.println(String.format("%032x",new BigInteger(md5.digest())));
		return String.format("%032x",new BigInteger(md5.digest()));
	}
	
	
}
