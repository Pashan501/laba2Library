package test;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.ControllerConfig;
import library.controller.BookController;
import library.controller.UserController;
import library.fabric.MySQLConnector;
import library.model.User;

public class Main {

	public static void main(String[] args) {
//	UserController us = new UserController(new MySQLConnector());
//	
//	System.out.println(us.getUserById(2).getType());
	
//	BookController bc = new BookController(new MySQLConnector());
//	try {
//		System.out.println(bc.getAllBooks().get(0).getName());
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		
		
//		MessageDigest md5 = null;
//		String str = "";
//		try {
//			md5 = MessageDigest.getInstance("MD5");
//		} catch (NoSuchAlgorithmException e) {
//
//			e.printStackTrace();
//		}
//		md5.update(StandardCharsets.UTF_8.encode("adminsolevoy"));
//		str =  String.format("%032x", new BigInteger(md5.digest()));
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("connection-config.xml");
		//UserController us = (UserController) new ClassPathXmlApplicationContext("connection-config.xml").getBean("userController");
		UserController uc= (UserController) ac.getBean("controllerUser");
		System.out.println(uc.getUserById(1).getType());
		
//			User user = us.getUserByEmail("daniel.protsak@gmail.com");
//			System.out.println(user.getType());
	
	}

}
