package service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Employee;
import service.EmployeeService;
import util.MyDBconnectionUtil;

public class EmployeeServiceImpl implements EmployeeService {
    private static Connection conn;
	
	public EmployeeServiceImpl() {
		
		conn = MyDBconnectionUtil.getDBconnection();
		
	}

	
	@Override
	public boolean updateEmployee(String userId, String field, String edit) throws SQLException {
		String sql="";
		if(field.equals("address")) {
			sql="UPDATE `itpdatabase`.`user` SET `address` = ? WHERE (`user_id` = ?)";
		}
		else if(field.equals("phone")) {
			sql="UPDATE `itpdatabase`.`user` SET `contact_no` = ? WHERE (`user_id` = ?)";
		}
		else if(field.equals("email")) {
			sql="UPDATE `itpdatabase`.`user` SET `email` = ? WHERE (`user_id` = ?)";
		}
			
		PreparedStatement stm= conn.prepareStatement(sql);
		stm.setObject(1, edit);
		stm.setObject(2, userId);
		System.out.println("Statement :"+stm.toString());
		int res=stm.executeUpdate();
		return res>0;
		
	}


	

	@Override
	public boolean deleteEmployee(String id) throws SQLException {
		String  sql= "Delete from user where userId='"+id+"'";
		Statement stm= conn.createStatement();
		int rslt= stm.executeUpdate(sql);
		return rslt>0;
	}


@Override
public ArrayList<Employee> getAllEmployees() throws SQLException {
	String  sql= "select * from user";
	Statement stm= conn.createStatement();
	ResultSet rst= stm.executeQuery(sql);
	ArrayList<Employee> empList= new ArrayList<>();
	
	while(rst.next()) {
		Employee emp= new Employee();
		emp.setUser_id(rst.getInt("user_id"));
		emp.setFirst_name(rst.getString("first_name"));
		emp.setLast_name(rst.getString("last_name"));
		emp.setEmail(rst.getString("email"));
		emp.setAddress(rst.getString("address"));
		emp.setContact_no(rst.getInt("contact_no"));
		emp.setPosition(rst.getString("position"));
		
		
		empList.add(emp);
		
	}
	return empList;
}


@Override
public boolean addNewEmp(Employee employee) throws SQLException {
	// TODO Auto-generated method stub
	return false;
}
}



