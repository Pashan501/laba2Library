package test;

import java.sql.SQLException;

import library.controller.BookController;
import library.controller.UserController;
import library.fabric.MySQLConnector;

public class Main {

	public static void main(String[] args) {
//	UserController us = new UserController(new MySQLConnector());
//	
//	System.out.println(us.getUserById(2).getType());
	
	BookController bc = new BookController(new MySQLConnector());
	try {
		System.out.println(bc.getAllBooks().get(0).getName());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
