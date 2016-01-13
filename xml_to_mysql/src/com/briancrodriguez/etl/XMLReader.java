package com.briancrodriguez.etl;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XMLReader {
	/*
	 * This class reads in a specific XML file and returns the 
	 * node names and associated text content as k/v pairs 
	 * in the form of a list of maps of type string, string
	 * TODO:  use a buffered input stream to load data
	 */
	private XMLToSQLMap mRecordMap = new XMLToSQLMap(); // this HashMap class identifies the nodes to be inserted into database
	private String sKey = new String();
	private String sValue = new String();
    
	public XMLReader () {

	}
	
	public List<Map<String,String>> parseXML(){
		System.out.println("Loading XML:\nIterating element nodes...");
		
		// list of maps of type string, string to return
		List<Map<String, String>> lGrants = new ArrayList<Map<String,String>>();
		try {
			File fXmlFile = new File("data/NEH_Grants2000s.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document XMLdoc = dBuilder.parse(fXmlFile);
			XMLdoc.getDocumentElement().normalize();
			
			NodeList nListOfGrants = XMLdoc.getElementsByTagName("Grant"); // grab all grant element nodes and "throw" into a node list
			
			System.out.println(nListOfGrants.getLength() + " records to be inserted.\n----------------------------\n"); 
			// first for loop
			for (int r = 0; r < nListOfGrants.getLength(); r++) { 
				Node grantElement = nListOfGrants.item(r); // pick out each grant element node from node list and throw into node object
		    	
				Map<String, String> grantValueMap = new HashMap<String, String>();
				
				if (grantElement.getNodeType() == Node.ELEMENT_NODE) { 
					NodeList nChildNodeGrants = (NodeList) grantElement.getChildNodes(); // grab the list of child nodes and "throw" into node list
					
					for (int f = 0; f < nChildNodeGrants.getLength(); f++) {
						Node grantNode = nChildNodeGrants.item(f); // pick out each child node from the list of grant child nodes and throw into node object
						sKey = grantNode.getNodeName(); 
						sValue = grantNode.getTextContent();
						//System.out.println(sKey + " : " + sValue);
				
						if (mRecordMap.containsKey(sKey)) {
				    		//System.out.println("Key=" + sKey + ", Value=" + sValue);
							grantValueMap.put(sKey, sValue);  // insert child nodes we are searching for into map(k/v pair)
				    	}
						
					} // second for loop
				}
				lGrants.add(grantValueMap); // add new map to list of maps
					
			} // first for loop

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lGrants;
	} // parseXML() method
} // XMLReader class
