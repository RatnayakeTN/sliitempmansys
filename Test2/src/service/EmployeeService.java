package service;


import java.sql.SQLException;

import java.util.ArrayList;

import model.Employee;

public interface EmployeeService {
	boolean addNewEmp(Employee employee)throws SQLException;
	
	public ArrayList<Employee> getAllEmployees() throws SQLException;

	boolean deleteEmployee(String id)throws SQLException;
	
	boolean updateEmployee(String userId, String field, String edit)throws SQLException;

}
