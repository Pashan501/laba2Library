package library.fabric;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MySQLConnector {
	private Connection conn;
	
	public MySQLConnector() {	
		ResourceBundle rb = ResourceBundle.getBundle("connection");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://"+rb.getString("host")+"/"+rb.getString("db")+"?user="+rb.getString("user")+"&password="+rb.getString("password"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() 
	{
		return this.conn;
	}
	
}
