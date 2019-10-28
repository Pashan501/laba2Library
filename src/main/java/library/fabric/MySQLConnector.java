package library.fabric;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
	private Connection conn;
	public MySQLConnector(Connection conn) {
		
		
			
		 
	}
	public MySQLConnector statement() {
	try {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (InstantiationException | IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("Success");

 conn = null;
 try {
		System.out.println("Obtaining connecting...");
	    conn =
	       DriverManager.getConnection("jdbc:mysql://localhost/?" +
	                                   "user=root&password=");
	    System.out.println("OK");

	} catch (SQLException ex) {
	    // handle any errors
		System.out.println("Failed");
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	}
}return conn;
}
