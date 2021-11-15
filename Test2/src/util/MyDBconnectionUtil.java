package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBconnectionUtil {
	
	private static Connection conn;
	
	public static Connection getDBconnection() {
		
		if(conn == null) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrman","root","");
			
		}catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
	
	}	
		
		return conn;
	}

}
