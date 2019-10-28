package test;

import library.controller.UserController;
import library.fabric.MySQLConnector;

public class Main {

	public static void main(String[] args) {
	UserController us = new UserController(new MySQLConnector());
	
	System.out.println(us.getUserById(1).getType());
	
	}

}
