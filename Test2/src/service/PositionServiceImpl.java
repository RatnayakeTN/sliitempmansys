package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.PositionModel;
import util.MyDBconnectionUtil;

public class PositionServiceImpl implements IPosition{
	
	private static Connection conn;
	
	public PositionServiceImpl() {
		
		conn = MyDBconnectionUtil.getDBconnection();
	}

	@Override
	public boolean addNewPosition(PositionModel my) throws SQLException {
		
		String sql = "Insert into master_positions (position_name,basic_salary) value(?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setObject(1,my.getPositionName());
		stm.setObject(2,my.getBasicSalary());
		
		int res = stm.executeUpdate();
		
		return res>0;
	}

	@Override
	public ArrayList<PositionModel> getAllPositions() throws SQLException {
		
		String sql = "Select * from master_positions where state ='1'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<PositionModel> positionList = new ArrayList<PositionModel>();
		
		while(rst.next()) {
			
			PositionModel my = new PositionModel();
			
			my.setPositionName(rst.getString("position_name"));
			my.setBasicSalary(rst.getString("basic_salary"));
			my.setPid(rst.getString("position_id"));
			
			positionList.add(my);
		}
		
		return positionList;
	}

	@Override
	public boolean deletePosition(String Did) throws SQLException {
		
		String sql = "Update master_positions set state = '0' where position_id ='"+Did+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql)>0;
	}
	

	@Override
	public boolean updatePosition(PositionModel position) throws SQLException {
		
		String sql = "update master_positions set position_name = ?, basic_salary = ? where position_id =" + position.getPid();
		
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setObject(1,position.getPositionName());
		stm.setObject(2,position.getBasicSalary());
		
		int res = stm.executeUpdate();
		
		return res>0;
	}
	
	

	@Override
	public ArrayList<PositionModel> getEditedPosition(String did) throws SQLException {
		
		String sql = "Select * from master_positions where position_id =" + did;
		java.sql.Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<PositionModel> uslst = new ArrayList<PositionModel>();
		
		while(rst.next()) {
			PositionModel us = new PositionModel();
			
			us.setPid(rst.getString("position_id"));
			us.setPositionName(rst.getString("position_name"));
			us.setBasicSalary(rst.getString("basic_salary"));
			
			
			uslst.add(us);
		}
		return uslst;
	}

	

}
