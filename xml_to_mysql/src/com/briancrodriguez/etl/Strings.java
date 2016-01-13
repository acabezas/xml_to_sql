package com.briancrodriguez.etl;

public class Strings {
	/*
	 * This class is used for global strings
	 */
	
	// database table name
	public static final String GRANT_TABLE = "NEH_GRANTS";
		
	//  SQL insert for grant table
	public static final String SQL_INSERT_GRANTS = "INSERT INTO " + GRANT_TABLE + " " 
			+ "(AppType, InstitutionName, OrgType) VALUES " 
			+ "(?,?,?)";  
		
}
