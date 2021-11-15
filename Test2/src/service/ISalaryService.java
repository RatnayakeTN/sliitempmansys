package service;

import java.sql.SQLException;

import java.util.ArrayList;

import model.AttendanceInfo;
import model.Master_Salary;
import model.Salary;


public interface ISalaryService {

	public boolean addSalary(Salary sal) throws SQLException;
	
	public ArrayList<Salary> getSalary() throws SQLException;
	
	boolean deleteSalary(String sID) throws SQLException;
	
	public ArrayList<Salary> getInfo(String sID) throws SQLException;
	
	public boolean updateSalaryInfo(Salary m) throws SQLException;
	
	public boolean calculateSalary(String datemonth,String emp) throws SQLException;
	
	public  ArrayList<Master_Salary> getBasicSalary(String emp) throws SQLException;

	public boolean getAttendance(String datemonth,String emp) throws SQLException;
	
	public boolean getLeaves(String datemonth,String emp) throws SQLException;
	
	
	
	public  Master_Salary getBasicSalarym(String emp) throws SQLException;
	
	//public AttendanceInfo getAttendancem(String emp, String datemonth) throws SQLException;
	

	//public boolean getAttendance(String datemonth,String emp) throws SQLException;
	
	//public boolean getLeaves(String datemonth,String emp) throws SQLException;
	
}
