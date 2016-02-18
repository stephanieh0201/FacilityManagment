package fms.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	public static Connection getConnection() {
		 
		System.out.println("DBHelper: -------- MySql " + "JDBC Connection  ------------");
		 
		try {
 
			Class.forName("com.mysql.jdbc.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("DBHelper: Check Where  your MySql JDBC Driver exist and " + "Include in your library path!");
			e.printStackTrace();
			return null;
 
		}
 
		System.out.println("DBHelper: MySQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection("jdbc:mysql://162.243.249.75/FacilityManagement", "root", "henry2992");
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery("SELECT VERSION()");

	            if (rs.next()) {
	                System.out.println("DBHelper: The Database Version is " + rs.getString(1));
	            }
 
		} catch (SQLException e) {
 
			System.out.println("DBHelper: Connection Failed! Check output console");
			e.printStackTrace();
			return null;
 
		}
 
		if (connection != null) {
			System.out.println("DBHelper: You have a database connection!");
		} else {
			System.out.println("DBHelper: Failed to make connection!");
		}
		
		return connection;
	}
}
