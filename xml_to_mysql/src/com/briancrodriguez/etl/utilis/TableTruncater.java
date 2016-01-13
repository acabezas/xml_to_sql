package com.briancrodriguez.etl.utilis;
import java.sql.SQLException;
import java.sql.Statement;

public class TableTruncater {
		/*
		 * This class assumes the table being purged already exists
		 */
	
		// this method purges tables 
		public void truncateTable(String pTableName) {
			System.out.println("Purging database table:");
			
			Statement statement = null;
			String SQLStatement = "Delete from " + pTableName + "";
	 
			try {
				statement =  DBConnection.instance().createStatement();
				// execute insert SQL statement
				statement.executeUpdate(SQLStatement);
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} 
		} 
}
