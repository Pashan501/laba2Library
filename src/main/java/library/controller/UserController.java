package library.controller;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library.fabric.MySQLConnector;
import library.model.User;

public class UserController {

	private MySQLConnector connector;
	private PreparedStatement ps;
	private Statement statement;
	
	private String salt = "solevoy";
	


	public UserController(MySQLConnector conn) 
	{
		this.connector = conn;
	}

	public User insertUser(String name,String surname, String email, String pass, String country, String city, String street) {
		User user =null;
		
		String INSERT_USER = "INSERT INTO user(name,surName,email,country,city,street,password,type)"+
				"VALUES (?,?,?,?,?,?,?,?)";
		try {
			
				ps = connector.getConnection().prepareStatement(INSERT_USER);
				ps.setString(1, name);
				ps.setString(2, surname);
				ps.setString(3, email);
				ps.setString(4, country);
				ps.setString(5, city);
				ps.setString(6, street);
				ps.setString(7, pass);
				ps.setString(8, "user");
				ps.executeUpdate();
			    ps.close();
		} catch (SQLException e) {
			System.out.println("Statement Exeption");
			e.printStackTrace();
		}
		return user;
	}
	
	
	public User getUserById(int id) 
	{	statement = null;
		User user = null;
		String GET_USER_BY_ID = "SELECT  user.name as \"Имя\" , user.surName as \"Фамилия\" , user.email , user.country as \"Страна\",user.city as \"Город\",user.street as \"Улица\",user.password as \"Пароль\", user.type as \"Тип Подписки\" from User WHERE id="+id+";";
		try {
			statement = connector.getConnection().createStatement();
			ResultSet rs= statement.executeQuery(GET_USER_BY_ID);
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
	public User getUserByEmail(String email) 
	{
		User user = null;
		String GET_USER_BY_EMAIL = "SELECT * FROM User WHERE email='"+email+"';";
		try {
			statement = connector.getConnection().createStatement();
			ResultSet rs= statement.executeQuery(GET_USER_BY_EMAIL);
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


	
	public User validateUser(String email, String password) throws SQLException 
	{
		User user = null;
		String GET_USER_BY_EMAIL_AND_PASSWORD = "SELECT email, password FROM user WHERE email = ? AND password = ?";
		ps = connector.getConnection().prepareStatement(GET_USER_BY_EMAIL_AND_PASSWORD);
		ps.setString(1, email);
		ps.setString(2, hashString(password));
		ResultSet rs = ps.executeQuery();
		if(rs.isFirst()) 
		{
			user = getUserByEmail(rs.getString(1));
		}
		return user;
		
	}
	
	private String hashString(String hash) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		md5.update(StandardCharsets.UTF_8.encode(hash+salt));
		return String.format("%032x", new BigInteger(md5.digest()));

	}
	
	
}
