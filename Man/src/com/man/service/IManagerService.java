package com.man.service;
//IT18170726
//T.N Ratnayake

import java.util.*;
import java.util.logging.*;
import javax.xml.transform.*;
import com.man.model.Manager;


//This is the interface for the Manager service
public interface IManagerService {
	
	public static final Logger log = Logger.getLogger(IManagerService.class.getName());
	
	//get a specific manager
	public Manager getManagerById(String managerID);
	
	//Add a new manager to table
	public  void addManager(Manager manager);
	
	//get all manager details from arraylist
	public ArrayList<Manager> getAllManagers();
	
	//Update an existing manager
	public Manager updateManager(String managerID, Manager manager);
	
	//Remove an existing manager
	public void removeManager(String managerID);
	
}
