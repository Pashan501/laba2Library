package library.controller;

import library.fabric.MySQLConnector;

public class Main {

	public static void main(String[] args) {
		UserController uc = new UserController(new MySQLConnector());
	//	uc.insertUser("Oksana", "Zhuk", "oksanaeoz@gmail.com", "rozbutska", "ukraine", "kyiv", "lesya kurbasa");
		System.out.println(uc.getUserByEmail("admin@gmail.com"));
		//System.out.println(uc.getUserById(4));
	}

}
