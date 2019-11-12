package library.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.fabric.MySQLConnector;
import library.model.Book;

public class BookController {

	private MySQLConnector connector;

	private Statement statement;
	private PreparedStatement ps;
	
	public BookController(MySQLConnector connector) 
	{
		this.connector = connector;
	}
	
	public ArrayList<Book> getAllBooks() throws SQLException
	{
		ArrayList<Book>  list = null;
		String GET_ALL_BOOKS = "SELECT * FROM Books";
		statement = connector.getConnection().createStatement();
		ResultSet rs = statement.executeQuery(GET_ALL_BOOKS);
		if(!rs.next()) 
		{	
			list = new ArrayList<>();
			while(rs.next()) 
			{
				int id = Integer.parseInt(rs.getString(1));
				String name = rs.getString(2);
				String genre = rs.getString(3);
				String authorName = rs.getString(4);
				String imgSource = rs.getString(5);
				list.add(new Book(id,name,genre,authorName,imgSource));
			}
		}
		return list;
		
	}
	
}
