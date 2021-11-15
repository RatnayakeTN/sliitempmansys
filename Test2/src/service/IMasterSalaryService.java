package service;

import java.sql.SQLException;

import java.util.ArrayList;


import model.Master_Salary;

public interface IMasterSalaryService {
	
	public boolean addSalaryInfo(Master_Salary sal) throws SQLException;
	
	public ArrayList<Master_Salary> getSalary() throws SQLException;
	
	public boolean deleteSalary(String sID) throws SQLException;
	
	//public Master_Salary getInfo(String sID) throws SQLException;
	
	public ArrayList<Master_Salary> getInfo(String sID) throws SQLException;
	
	public boolean updateSalaryInfo(Master_Salary m) throws SQLException;
	
}
