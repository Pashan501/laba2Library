package library.controller;


import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import library.fabric.MySQLConnector;
import library.model.User;


public class UserController {

	@Autowired
	private MySQLConnector connector;

	public MySQLConnector getConnector() {
		return connector;
	}


	public void setConnector(MySQLConnector connector) {
		this.connector = connector;
	}


	public Statement getStatement() {
		return statement;
	}


	public void setStatement(Statement statement) {
		this.statement = statement;
	}


	public PreparedStatement getPs() {
		return ps;
	}


	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}


	public String getSalt() {
		return salt;
	}


	public void setSalt(String salt) {
		this.salt = salt;
	}

	private Statement statement;
	private PreparedStatement ps;
	private String salt = "solevoy";
	
	

	public UserController() 
	{
		
	}

	
	public void insertUser(String name,String surname, String email, String pass, String country, String city, String street) {
		
		String INSERT_USER = "INSERT INTO users(name,surName,email, country, city , street , password, type)"+ 
				"VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			ps = connector.getDataSource().getConnection().prepareStatement(INSERT_USER);
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.setString(3, email);
			ps.setString(4, country);
			ps.setString(5, city);
			ps.setString(6, street);
			ps.setString(7, pass);
			ps.setString(8, "user");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public User getUserById(int id) 
	{
		User user = null;
		String GET_USER_BY_ID = "SELECT * FROM User WHERE id="+id+";";
		try {
			statement = connector.getDataSource().getConnection().createStatement();
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
		String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email='"+email+"';";
		try {
			statement = connector.getDataSource().getConnection().createStatement();
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

	

	
	public User validateUser(String email, String password) throws SQLException 
	{
		User user = null;
		String GET_USER_BY_EMAIL_AND_PASSWORD = "SELECT email, password FROM user WHERE email = ? AND password = ?";
		ps = connector.getDataSource().getConnection().prepareStatement(GET_USER_BY_EMAIL_AND_PASSWORD);
		ps.setString(1, email);
		ps.setString(2, hashString(password));
		System.out.println(hashString(password));
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			System.out.println("PROVERKA");
			user = getUserByEmail(rs.getString(1));
		}
		return user;
		
	}
	
	public static void invalidateUser(HttpSession session)
	{
			if (session != null) {
				session.invalidate();
		}else
			return;
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
