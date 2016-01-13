package com.briancrodriguez.etl;

import java.util.HashMap;

public class XMLToSQLMap extends HashMap<String, String> {
	/*
	 * Hashmap class to map element nodes to database fields
	 */
	private static final long serialVersionUID = 1L;
	
	public XMLToSQLMap() {
		// map keys are the XML element, values are the DB field names
		this.put("ApplicantType", "AppType");
		this.put("Institution", "InstitutionName");
		this.put("OrganizationType","OrgType"); 
	}

}
