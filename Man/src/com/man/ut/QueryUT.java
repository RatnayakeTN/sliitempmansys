package com.man.ut;


import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import com.man.service.*;

//This loads the sql queries which ManagerQuery has
public class QueryUT extends CommonUT{
	
	//This method reads the Manager Query file and gets the queries by their ids
	
	//@param queryid
	//ParserConfigurationException, IOException,SAXException exceptions are thrown by this method
	
	//@return Query will be formatted as a String and returned
	
	
	public static String queryById(String id) throws  SAXException, IOException, ParserConfigurationException {
		NodeList nodeList;
		Element element = null;
		
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\Man\\WEB-INF\\ManagerQuery.xml"))
					.getElementsByTagName(ConstantsUT.TAG_NAME);

		 
		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);
			if (element.getAttribute(ConstantsUT.QID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	
		
		
		
		
	}
}
