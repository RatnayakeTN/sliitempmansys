package service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.BasicSalaryDetailsModel;
import util.MyDBconnectionUtil;

public class BasicSalaryServiceImpl implements IBasicSalaryDetails {
	
	private static Connection conn;
	
	public BasicSalaryServiceImpl() {
		
		conn = MyDBconnectionUtil.getDBconnection();
		
	}

	@Override
	public boolean addBasicSalaryDetails(BasicSalaryDetailsModel my) throws SQLException {
		
		String sql = "Insert into salary_info (emp_id,basic_salary,allowances) value(?,?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setObject(1,my.getEmpId());
		stm.setObject(2,my.getBasicSalary());
		stm.setObject(3,my.getAllowances());
		
		int res = stm.executeUpdate();
		
		return res>0;
	}
	
	

}
