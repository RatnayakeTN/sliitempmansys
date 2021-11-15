package service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.Master_Salary;

import util.MyDBconnectionUtil;

public class MasterSalaryServiceImpl implements IMasterSalaryService{

	private static Connection conn;

	public MasterSalaryServiceImpl() {
		conn = MyDBconnectionUtil.getDBconnection();
	}

	@Override
	public boolean addSalaryInfo(Master_Salary sal) throws SQLException {
		
		String sql = "Insert into salary_info(emp_id,basic_salary,allowances) values(?,?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		
		//stm.setObject(1, null);
		stm.setObject(1, sal.getEmp_id());
		stm.setObject(2, sal.getBasic_salary());
		stm.setObject(3, sal.getAllowances());
		//stm.setObject(5, "1");
		//stm.setObject(6, null);
		//stm.setObject(7, null);
		//stm.setObject(8, null);
		//stm.setObject(9, "0000-00-00 00:00:00");

		

		int res=stm.executeUpdate();
		
		 return res>0;
	}

	@Override
	public ArrayList<Master_Salary> getSalary() throws SQLException {
		String sql = "select*from salary_info where status = '1'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<Master_Salary> salaryList = new ArrayList<Master_Salary>();
		
		while(rst.next()) {
			
			Master_Salary sal = new Master_Salary();
			
			sal.setTable_id(rst.getString("table_id"));
			sal.setEmp_id(rst.getString("emp_id"));
			sal.setBasic_salary(rst.getString("basic_salary"));
			sal.setAllowances(rst.getString("allowances"));
			sal.setStatus(rst.getString("status"));
			sal.setCreated_by(rst.getString("created_by"));
			sal.setCreated_date(rst.getString("created_datetime"));
			sal.setUpdated_by(rst.getString("updated_by"));
			sal.setUpdated_datetime(rst.getString("updated_datetime"));
			
			salaryList.add(sal);
			
		}
		
		return salaryList;
	}

	@Override
	public boolean deleteSalary(String sID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update salary_info set status = '-1' where table_id = '"+sID+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql)>0;
	}

	@Override
	public ArrayList<Master_Salary> getInfo(String sID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from salary_info where table_id  = '"+sID+"'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<Master_Salary> list = new ArrayList<Master_Salary>();
		while(rst.next()) {
			Master_Salary m = new Master_Salary();
			m.setTable_id(rst.getString("table_id"));
			m.setEmp_id(rst.getString("emp_id"));
			m.setBasic_salary(rst.getString("basic_salary"));
			m.setAllowances(rst.getString("allowances"));
	
			list.add(m);
		}
		return list;
	}

	@Override
	public boolean updateSalaryInfo(Master_Salary m) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update salary_info set table_id=?, basic_salary = ?, allowances = ?  where table_id = " + m.getTable_id();
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setObject(1,m.getTable_id());
		stm.setObject(2,m.getBasic_salary());
		stm.setObject(3,m.getAllowances());
		
		int res = stm.executeUpdate();
		
		return res>0;
		
	}

	
	
	
	
	
}
