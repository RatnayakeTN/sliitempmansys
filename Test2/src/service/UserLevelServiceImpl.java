package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.UserLevelModel;
import util.MyDBconnectionUtil;

public class UserLevelServiceImpl implements IUserLevel{
	
	private static Connection conn;
	
	public UserLevelServiceImpl() {
			
			conn = MyDBconnectionUtil.getDBconnection();
		}

	@Override
	public boolean addNewUserLevel(UserLevelModel my) throws SQLException {
		
		String sql = "Insert into master_user_levels (levelName,level) value(?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setObject(1,my.getUlevel());
		stm.setObject(2,my.getNo());
		
		int res = stm.executeUpdate();
		
		return res>0;
	}
	
	public ArrayList<UserLevelModel> getAllUserLevels() throws SQLException {
		
		String sql = "Select * from master_user_levels where state ='1'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<UserLevelModel> userLevelList = new ArrayList<UserLevelModel>();
		
		while(rst.next()) {
		
			UserLevelModel my = new UserLevelModel();
			
			my.setUlevel(rst.getString("levelName"));
			my.setNo(rst.getString("level"));
			my.setUid(rst.getString("ul_id"));
			
			userLevelList.add(my);
		}
		
		return userLevelList;
	}

	@Override
	public boolean deleteUserlevel(String Did) throws SQLException {
		
		String sql = "Update master_user_levels set state = '0' where level ='"+Did+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql)>0;
	}
	
	public ArrayList<UserLevelModel> SelectUserLevels() throws SQLException {
		
		ArrayList<UserLevelModel> userLList = new ArrayList<UserLevelModel>();
		
		String sql = "Select * from master_user_levels";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		while(rst.next()) {
			
			UserLevelModel my = new UserLevelModel();
			
			my.setUlevel(rst.getString("levelName"));
			my.setNo(rst.getString("level"));
		
	
			userLList.add(my);
		}
		
		return userLList;
	}

	@Override
	public boolean updateUserlevel(UserLevelModel my) throws SQLException {
		
		String sql = "update master_user_levels set levelName = ?, level = ? where level ="+ Integer.parseInt(my.getNo());
		
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setObject(1,my.getUlevel());
		stm.setObject(2,my.getNo());
		
		int res = stm.executeUpdate();
		
		return res>0;
	}

	@Override
	public ArrayList<UserLevelModel> getEditedUserLevels(String level) throws SQLException {
		
		String sql = "Select * from master_user_levels where level =" + level;
		java.sql.Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<UserLevelModel> uslst = new ArrayList<UserLevelModel>();
		
		while(rst.next()) {
			UserLevelModel us = new UserLevelModel();
			
			us.setUlevel(rst.getString("levelName"));
			us.setNo(rst.getString("level"));
			
			
			uslst.add(us);
		}
		return uslst;
	}

}
