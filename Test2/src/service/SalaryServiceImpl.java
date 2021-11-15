package service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.AttendanceInfo;
import model.Master_Salary;
import model.Salary;
import util.MyDBconnectionUtil;

public class SalaryServiceImpl implements ISalaryService{

	private static Connection conn;

	public SalaryServiceImpl() {
		conn = MyDBconnectionUtil.getDBconnection();
	}

	@Override
	public boolean addSalary(Salary sal) throws SQLException {
		// TODO Auto-generated method stub


		String sql = "Insert into salary(emp_id,month,epf_deductions,OT,deductions,net_salary) values(?,?,?,?,?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setObject(1, sal.getEmp_id());
		stm.setObject(2, sal.getMonth());
		stm.setObject(3, sal.getEpf_deductions());
		stm.setObject(4, sal.getOT());
		stm.setObject(5, sal.getDeductions());
		stm.setObject(6, sal.getNet_salary());

		int res=stm.executeUpdate();
		
		 return res>0;
	}

	@Override
	public ArrayList<Salary> getSalary() throws SQLException {
		
		String sql = "select*from salary where state = '1'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<Salary> salaryList = new ArrayList<Salary>();
		
		while(rst.next()) {
			
			Salary sal = new Salary();
			
			sal.setSalary_id(rst.getString("salary_id"));
			sal.setEmp_id(rst.getString("emp_id"));
			sal.setMonth(rst.getString("month"));
			sal.setEpf_deductions(rst.getString("epf_deductions"));
			sal.setOT(rst.getString("OT"));
			sal.setDeductions(rst.getString("deductions"));
			sal.setNet_salary(rst.getString("net_salary"));
			sal.setCreated_datetime(rst.getString("created_datetime"));
			sal.setUpdated_datetime(rst.getString("updated_datetime"));
			
			
			salaryList.add(sal);
			
		}
		
		return salaryList;
	}

	@Override
	public boolean deleteSalary(String sID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update salary set state = '0' where salary_id = '"+sID+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql)>0;
	}

	@Override
	public ArrayList<Salary> getInfo(String sID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from salary where salary_id  = '"+sID+"'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<Salary> list = new ArrayList<Salary>();
		while(rst.next()) {
			
			Salary m = new Salary();
			m.setSalary_id(rst.getString("salary_id"));
			m.setEmp_id(rst.getString("emp_id"));
			m.setYear(rst.getString("year"));
			m.setMonth(rst.getString("month"));
			m.setEpf_deductions(rst.getString("epf_deductions"));
			m.setOT(rst.getString("OT"));
			m.setDeductions(rst.getString("deductions"));
			m.setNet_salary(rst.getString("net_salary"));

	
			list.add(m);
		}
		return list;
	}

	@Override
	public boolean updateSalaryInfo(Salary m) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update salary set month = ?, epf_deductions = ?, OT = ?, deductions = ?, net_salary = ? where salary_id = " + m.getSalary_id();
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setObject(1,m.getMonth());
		stm.setObject(2,m.getEpf_deductions());
		stm.setObject(3,m.getOT());
		stm.setObject(4,m.getDeductions());
		stm.setObject(5,m.getNet_salary());
		
		int res = stm.executeUpdate();
		
		
		return res>0;
	}

	@Override
	public boolean calculateSalary(String datemonth, String emp) throws SQLException {
		// TODO Auto-generated method stub
	
		String sql = "select * from salary_info, attendance, leave, testuser where testuser.state = 1 && salary_info.state = 1 && where attendance.Status=1 && leave_table.state=1 && testuser.uid = '" + emp + "'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		return false;
	}

	@Override
	public ArrayList<Master_Salary> getBasicSalary(String emp) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from salary_info where status=1 && emp_id  = '"+emp+"'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<Master_Salary> list = new ArrayList<Master_Salary>();
		while(rst.next()) {
			
			Master_Salary m = new Master_Salary();
			m.setEmp_id(rst.getString("table_id"));
			m.setBasic_salary(rst.getString("basic_salary"));
			m.setAllowances(rst.getString("allowances"));
	
			list.add(m);
		}
		return list;
	}

	@Override
	public boolean getAttendance(String datemonth, String emp) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from attendance where state=1 && EXTRACT(YEAR_MONTH FROM '"+datemonth+"') && EmployeeID  = '"+emp+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql)>0;
	}

	@Override
	public boolean getLeaves(String datemonth, String emp) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from leave_table where state=1 && emp_id  = '"+emp+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql)>0;
	}

	@Override
	public Master_Salary getBasicSalarym(String emp) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from salary_info where status=1 && emp_id  = '"+emp+"'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		

		Master_Salary m = new Master_Salary();
		
		ArrayList<Master_Salary> list = new ArrayList<Master_Salary>();
		while(rst.next()) {
			
			m.setEmp_id(rst.getString("table_id"));
			m.setBasic_salary(rst.getString("basic_salary"));
			m.setAllowances(rst.getString("allowances"));
	
			list.add(m);
		}
		return m;
	}

	//@Override
//	public AttendanceInfo getAttendancem(String emp, String datemonth) throws SQLException {
//		// TODO Auto-generated method stub
//		//String sql = "select * from attendance where state=1 && EXTRACT(YEAR_MONTH FROM date) = '"+datemonth+"' && EmployeeID  = '"+emp+"'";
//		Statement stm = conn.createStatement();
//		
//		return stm.executeUpdate(sql)>0;
//	}

	
	
	
}
