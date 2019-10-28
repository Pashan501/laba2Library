package library.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnector {

	
	public Connection openDatabase() {
		Connection conn =null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			 conn = DriverManager.getConnection("jdbc:mysql://localhost/laba2_konstr?" + "user=root&password=");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("Failed");
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}
}
