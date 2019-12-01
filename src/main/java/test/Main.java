package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
		
		
//		ApplicationContext ac = new ClassPathXmlApplicationContext("connection-config.xml");
//		//UserController us = (UserController) new ClassPathXmlApplicationContext("connection-config.xml").getBean("userController");
//		UserController uc= (UserController) ac.getBean("controllerUser");
//		System.out.println(uc.getUserById(1).getType());
		
		
//		try {
//			URL url = new URL("https://www.youtube.com/");
//			String param = "hello its Test";
//			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
//			urlConn.setRequestMethod("POST");
//			urlConn.setRequestProperty("Content-Length", String.valueOf(param.getBytes().length));
//			urlConn.setDoInput(true);
//			urlConn.setDoOutput(true);
//			OutputStream os = urlConn.getOutputStream();
//			InputStream is = urlConn.getInputStream();
//			os.write(param.getBytes());
//			urlConn.connect();
//			BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
//			String line = "";
//			while((line = buffer.readLine()) != null) 
//			{
//				System.out.println(line);
//			}
//			os.close();
//			is.close();
//			buffer.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//			User user = us.getUserByEmail("daniel.protsak@gmail.com");
//			System.out.println(user.getType());
	
	}

}
