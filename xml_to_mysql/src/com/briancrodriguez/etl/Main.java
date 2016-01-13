package com.briancrodriguez.etl;
import com.briancrodriguez.etl.utilis.TableTruncater;

public class Main {

	public static void main(String[] args) {
		
		TableTruncater tableTruncater = new TableTruncater();
		tableTruncater.truncateTable(Strings.GRANT_TABLE);
		
		XMLReader oXMLReader = new XMLReader();
		DataInserter oDataInserter = new DataInserter();
		oDataInserter.insertData(oXMLReader.parseXML());
		
		System.out.println("\n### Database Load Completed! ###"); 
	}

}
