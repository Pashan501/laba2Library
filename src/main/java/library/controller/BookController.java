package library.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import library.fabric.MySQLConnector;
import library.model.Book;

public class BookController {

	@Autowired
	private MySQLConnector connector;

	private Statement statement;
	private PreparedStatement ps;
	private static final String DELETE_BOOK_BY_ID = "DELETE FROM `books` WHERE id = ?";
	private static final String GET_BOOK_BY_ID = "SELECT * FROM `books` WHERE id = ?";
	private static final String UPDATE_BOOK = "UPDATE `books` SET `Name` = ? , `Genre` = ?, `AuthorName` = ?, "
			+ "`Description` = ? , `year` = ?, `img-source` = ? WHERE `books`.`id` = 1;";
	private static final String SEARCH_BOOK_BY_NAME = "SELECT * FROM `books` WHERE `books`.`Name` LIKE '%' ? '%';";
	
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
				int year = Integer.parseInt(rs.getString(6)); 
				String imgSource = rs.getString(7);
				list.add(new Book(id,name,genre,authorName,description,year,imgSource));
			}
		return list;
		
	}
	public Book getBookById(int id) throws SQLException 
	{
		ps = getConnector().getDataSource().getConnection().prepareStatement(GET_BOOK_BY_ID);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Book book = null;
		while(rs.next()) 
		{
			book = new Book();
			book.setId(Integer.parseInt(rs.getString(1)));
			book.setName(rs.getString(2));
			book.setGenre(rs.getString(3));
			book.setAuthorName(rs.getString(4));
			book.setDescription(rs.getString(5));
			book.setYear(Integer.parseInt(rs.getString(6)));
			book.setImgSource(rs.getString(7));
		}
		
		return book;
	}
	public void deleteBookById(int id) throws SQLException 
	{
		ps = getConnector().getDataSource().getConnection().prepareStatement(DELETE_BOOK_BY_ID);
		ps.setString(1, String.valueOf(id));
		ps.execute();
	}
	
	public void updateBook(Book book) throws SQLException 
	{
		ps = connector.getDataSource().getConnection().prepareStatement(UPDATE_BOOK);
		ps.setString(1, book.getName());
		ps.setString(2, book.getGenre());
		ps.setString(3, book.getAuthorName());
		ps.setString(4, book.getDescription());
		ps.setInt(5, book.getYear());
		ps.setString(6, book.getImgSource());
		ps.execute();
	}
	
	public List<Book> getBooksMySearch(String searchString) throws SQLException
	{
		List<Book> list = new ArrayList<>();
		ps = connector.getDataSource().getConnection().prepareStatement(SEARCH_BOOK_BY_NAME);
		ps.setString(1, searchString);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			list.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getInt(6),rs.getString(7)));
		}
		
		return list;
	}
	
}
