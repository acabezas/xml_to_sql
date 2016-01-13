package com.briancrodriguez.etl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.briancrodriguez.etl.utilis.DBConnection;

public class DataInserter {
	/*
	 * This class assumes the table being used already exists
	 * TODO: check if table exists and create table function
	 */
	
	public DataInserter () {

	}
	
	public void insertData(List<Map<String,String>> list) { 
		System.out.println("Inserting Data:");
		
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = DBConnection.instance().prepareStatement(Strings.SQL_INSERT_GRANTS);
			
			for (Map<String,String> currentMap : list) { 
				
				preparedStatement.setString(1, currentMap.get("ApplicantType")); 
				preparedStatement.setString(2, currentMap.get("Institution"));
				preparedStatement.setString(3, currentMap.get("OrganizationType"));
				// add query to batch of statements
				preparedStatement.addBatch();
			}
			
			// execute the batch of statements
			preparedStatement.executeBatch();
			
		} // try
		
		catch (SQLException e) {
			System.out.println(e.getMessage());  
		} // catch
		
		finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} //finally
		
	}
	
}
