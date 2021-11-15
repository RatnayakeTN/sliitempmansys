package com.man.ut;

import java.sql.*;

//This class creates the database connection
public class DBConnectUT extends CommonUT{
	
	private static Connection connection;
	
	private DBConnectUT() {
	}
	
	 // Creates Database connection for the given URL, Username and Password
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
	
		 // This creates  new connection objects when connection is closed 
		 
		if (connection == null || connection.isClosed()) {

			Class.forName(properties.getProperty(ConstantsUT.DRIVER_NAME));
			connection = DriverManager.getConnection(properties.getProperty(ConstantsUT.URL),
					properties.getProperty(ConstantsUT.USERNAME), properties.getProperty(ConstantsUT.PASSWORD));
		}
		return connection;
	}

}
