package com.man.ut;

import java.io.IOException;
import java.util.*;
import java.util.logging.*;

import com.man.service.IManagerService;

//This class can load properties and their details when they are initiated

public class CommonUT{
	
	//Initializing logger
	public static final Logger log = Logger.getLogger(IManagerService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			
			//Reads the property only once when loading the class
			properties.load(QueryUT.class.getResourceAsStream(ConstantsUT.PROPERTYC_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	//Adding a new Manager
	public static String generateIDs(ArrayList<String> arraylist) {

		String id;
		int size = arraylist.size();
		size=size+1;
		id = ConstantsUT.MAN_PREFIX + size;
		if (arraylist.contains(id)) {
			size = size + 1;
			id = ConstantsUT.MAN_PREFIX + size;
		}
		return id;
	}
}

