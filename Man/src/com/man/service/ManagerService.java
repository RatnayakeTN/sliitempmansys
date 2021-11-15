package com.man.service;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.man.model.Manager;
import com.man.ut.ConstantsUT;
import com.man.ut.DBConnectUT;
import com.man.ut.QueryUT;
import com.man.ut.CommonUT;

//This class contains the Implementation of IManagerService
public class ManagerService implements IManagerService{
	
	//Initializing logger
	public static final Logger log = Logger.getLogger(ManagerService.class.getName());
	
	private static Connection connection;

	private static Statement statement;

	static{
		//create or drop table
		createManagerTable();
	}

	private PreparedStatement preparedStatement;

	
	//This method drops manager table if it exits and creates a new one to add entries
	// this method throws SQLException , SAXException , IOException , ParserConfigurationException ,ClassNotFoundException exceptions  
	public static void createManagerTable() {

		try {
			connection = DBConnectUT.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUT.queryById(ConstantsUT.QID_DROP_TABLE));
			// Create manager table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUT.queryById(ConstantsUT.QID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	// Manager details are retrieved using the provided manager ID
	//@param managerID
	// this method throws SQLException , SAXException , IOException , ParserConfigurationException ,ClassNotFoundException exceptions 
	public void addManager(Manager manager) {
		String managerID = CommonUT.generateIDs(getManagerIDs());
				
			try {
				connection = DBConnectUT.getDBConnection();
				preparedStatement = connection
						
				.prepareStatement(QueryUT.queryById(ConstantsUT.QID_INSERT_MAN));
				connection.setAutoCommit(false);
					
				//Make manager IDs
				manager.setManagerID(managerID);
				preparedStatement.setString(ConstantsUT.COLUMN_ONE, manager.getManagerID());
				preparedStatement.setString(ConstantsUT.COLUMN_TWO, manager.getName());
				preparedStatement.setString(ConstantsUT.COLUMN_THREE, manager.getDepartment());
				preparedStatement.setString(ConstantsUT.COLUMN_FOUR, manager.getAddress());
				preparedStatement.setString(ConstantsUT.COLUMN_FIVE, manager.getQualifications());
				preparedStatement.setString(ConstantsUT.COLUMN_SIX, manager.getGender());
				//Add manager
				preparedStatement.execute();
				connection.commit();
		
			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				 //Close prepared statement and database connectivity at the end of
				 // the transaction
				 
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
	}
	
	//Manager details can be received depending on the id
	@Override
	public Manager getManagerById(String managerID) {
	
		return actionOnManager(managerID).get(0);
	}


	//this method retrieves all managers in the arraylist
	@Override
	public ArrayList<Manager> getAllManagers() {
	
		return actionOnManager(null);
	}
	
	
	//This method performs GET managers by ID and display all managers 
	// this method throws SQLException , SAXException , IOException , ParserConfigurationException ,ClassNotFoundException exceptions 
	private ArrayList<Manager> actionOnManager(String managerID) {

		ArrayList<Manager> employeeList = new ArrayList<Manager>();
		try {
			connection = DBConnectUT.getDBConnection();
			// Checks for an managerID before fetching data
			
			if (managerID != null && !managerID.isEmpty()) {
				
				preparedStatement = connection
						.prepareStatement(QueryUT.queryById(ConstantsUT.QID_GET_MAN));
				preparedStatement.setString(ConstantsUT.COLUMN_ONE, managerID);
			}
			//All managers are displayed if a specific managerID is not given for get Manager
			else {
				preparedStatement = connection
						.prepareStatement(QueryUT.queryById(ConstantsUT.QID_MANAGERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Manager employee = new Manager();
				employee.setManagerID(resultSet.getString(ConstantsUT.COLUMN_ONE));
				employee.setName(resultSet.getString(ConstantsUT.COLUMN_TWO));
				employee.setAddress(resultSet.getString(ConstantsUT.COLUMN_THREE));
				employee.setDepartment(resultSet.getString(ConstantsUT.COLUMN_FOUR));
				employee.setQualifications(resultSet.getString(ConstantsUT.COLUMN_FIVE));
				employee.setGender(resultSet.getString(ConstantsUT.COLUMN_SIX));
				employeeList.add(employee);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			// prepared statement is closed and database connectivity at the end of
			// transaction
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return employeeList;
	}

	//This method get the updated manager
	// this method throws SQLException , SAXException , IOException , ParserConfigurationException ,ClassNotFoundException exceptions 
	@Override
	public Manager updateManager(String managerID, Manager manager) {
		/*
		 * Before fetching employee it checks whether employee ID is available
		 */
		if (managerID != null && !managerID.isEmpty()) {
		 // retrieval of Update manager query form ManagerQuery.xml
		 
			try {
				connection =DBConnectUT.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUT.queryById(ConstantsUT.QID_UPDATE_MAN));
				preparedStatement.setString(ConstantsUT.COLUMN_ONE, manager.getName());
				preparedStatement.setString(ConstantsUT.COLUMN_TWO, manager.getDepartment());
				preparedStatement.setString(ConstantsUT.COLUMN_THREE, manager.getAddress());
				preparedStatement.setString(ConstantsUT.COLUMN_FOUR, manager.getQualifications());
				preparedStatement.setString(ConstantsUT.COLUMN_FIVE, manager.getGender());
				preparedStatement.setString(ConstantsUT.COLUMN_SIX, manager.getManagerID());
				preparedStatement.executeUpdate();
	
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				// prepared statement is closed and database connectivity at the end of
				// transaction
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated employee
		return getManagerById(managerID);
}

	//This method deletes a manager depending on their id
	// this method throws SQLException , SAXException , IOException , ParserConfigurationException ,ClassNotFoundException exceptions 
	@Override
	public void removeManager(String managerID) {
		if (managerID != null && !managerID.isEmpty()) {
			
			 //Remove manager query will be retrieved from ManagerQuery.xml
			try {
				connection = DBConnectUT.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUT.queryById(ConstantsUT.QID_REMOVE_MAN));
				preparedStatement.setString(ConstantsUT.COLUMN_ONE, managerID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				// prepared statement is closed and database connectivity at the end of
				// transaction
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}
		



/**
*
* @return An array of manager IDs will be returned
* // this method throws SQLException , SAXException , IOException , ParserConfigurationException ,ClassNotFoundException exceptions 
* */
	private ArrayList<String> getManagerIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		// List of manager IDs will be retrieved from EmployeeQuery.xml
		
		try {
			connection = DBConnectUT.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUT.queryById(ConstantsUT.QID_MANAGERIDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(ConstantsUT.COLUMN_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
