package library.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import library.fabric.MySQLConnector;
import library.model.Book;

public class BookController {

	@Autowired
	private MySQLConnector connector;

	private Statement statement;
	private PreparedStatement ps;
	private static final String DELETE_BOOK_BY_ID = "DELETE FROM `books` WHERE id = ?";
	
	public BookController() 
	{
		
	}
	
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

	public ArrayList<Book> getAllBooks() throws SQLException
	{
		ArrayList<Book>  list = null;
		String GET_ALL_BOOKS = "SELECT * FROM Books";
		statement = connector.getDataSource().getConnection().createStatement();
		ResultSet rs = statement.executeQuery(GET_ALL_BOOKS);
			list = new ArrayList<>();
			while(rs.next()) 
			{
				int id = Integer.parseInt(rs.getString(1));
				String name = rs.getString(2);
				String genre = rs.getString(3);
				String authorName = rs.getString(4);
				String description = rs.getString(5);
				String imgSource = rs.getString(6);
				list.add(new Book(id,name,genre,authorName,description,imgSource));
			}
		return list;
		
	}
	
	public void deleteBookById(int id) throws SQLException 
	{
		ps = getConnector().getDataSource().getConnection().prepareStatement(DELETE_BOOK_BY_ID);
		ps.setString(1, String.valueOf(id));
		ps.execute();
	}
	
}
