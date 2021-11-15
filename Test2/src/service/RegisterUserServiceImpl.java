package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.RegisterModel;
import util.MyDBconnectionUtil;

public class RegisterUserServiceImpl implements IRegisterUser {
	
	private static Connection conn;
	
	public RegisterUserServiceImpl() {
		
		conn = MyDBconnectionUtil.getDBconnection();
	}

	@Override
	public boolean registerUser(RegisterModel my) throws SQLException {
		
		String sql = "Insert into testuser (first_name,last_name,email,contactNo,username,password,address,position,userlevel) value(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setObject(1,my.getFname());
		stm.setObject(2,my.getLname());
		stm.setObject(3,my.getEmail());
		stm.setObject(4,my.getContactNo());
		stm.setObject(5,my.getUserName());
		stm.setObject(6,my.getPassword());
		stm.setObject(7,my.getAddrerss());
		stm.setObject(8,my.getPosition());
		stm.setObject(9,my.getUserLevel());
		
		int res = stm.executeUpdate();
		
		return res>0;
	}

	@Override
	public ArrayList<RegisterModel> getUserDetails() throws SQLException {
		
		String sql = "Select * from testuser where state ='1'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<RegisterModel> userDetails = new ArrayList<RegisterModel>();
		
		while(rst.next()) {
			
			RegisterModel my = new RegisterModel();
			
			my.setUid(rst.getString("uid"));
			my.setFname(rst.getString("first_name"));
			my.setLname(rst.getString("last_name"));
			my.setEmail(rst.getString("email"));
			my.setContactNo(rst.getString("contactNo"));
			my.setAddrerss(rst.getString("address"));
			my.setPosition(rst.getString("position"));
			my.setUserLevel(rst.getString("userlevel"));
			
			userDetails.add(my);
		}
		
		return userDetails;
	}

	@Override
	public boolean deleteUserDetails(String Did) throws SQLException {
		
		String sql = "Update testuser set state = '0' where uid ='"+Did+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql)>0;
	}

	@Override
	public boolean validateUser(String username, String password) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("select * from testuser where username=? and password=?");
		ps.setString(1, username);
		ps.setString(2, password);
 
		ResultSet rs = ps.executeQuery();
		boolean status = rs.next();
		
		return status;
	}
	
	

}
