package com.briancrodriguez.etl.utilis;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
	/*
	 * This class uses a singleton design pattern
	 * for the database connection 
	 */
	
	//private static attribute for this "single" instance class
	private static Connection conn = null;
	
	// the private access modifier will disallow creation of instances of this class
	private DBConnection () {

	}
	
	// public static "accessor" function
	public static Connection instance() {
		// check if connection object already exists
		if (conn != null ) {
			System.out.println("Accessing existing database connection...\n----------------------------\n");
			return conn;
		} else {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			try {
				// "lazy initialization" of connection object (creation on first use)
				System.out.println("Establishing connection to database...\n----------------------------\n");
				conn = DriverManager.getConnection("jdbc:sqlite:data/grants.db");			
			} catch (SQLException e) {	 
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			}
			return conn;
		}
	}
}
