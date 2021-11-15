package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.LeaveInfo;
import service.LeaveService;
import util.MyDBconnectionUtil;



public class LeaveServieImpl implements LeaveService {

	private static Connection conn;
	
	public LeaveServieImpl() {
		
		conn = MyDBconnectionUtil.getDBconnection();
	}
	
	@Override
	public boolean addNewLeaveInfo(LeaveInfo leave) throws SQLException {
		
		String sql = "Insert into leave_table values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stm =conn.prepareStatement(sql);
		
		stm.setObject(1,0);
		stm.setObject(2,2);
		stm.setObject(3,leave.getLeave_type());
		stm.setObject(4,leave.getRequested_date());
		stm.setObject(5,leave.getTo_date());
		stm.setObject(6,leave.getFrom_time());
		stm.setObject(7,leave.getTo_time());
		stm.setObject(8,leave.getReason());
		stm.setObject(9,4);
		stm.setObject(10,0);
		
		int res = stm.executeUpdate();
		return false;
	}

	@Override
	public ArrayList<LeaveInfo> getAllLeaves() throws SQLException {
		String sql = "select * from leave_table  where state = 0 ";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<LeaveInfo> lvelist = new ArrayList<LeaveInfo>();
		
		while (rst.next()) {
			LeaveInfo lvinfo = new LeaveInfo();
			
			lvinfo.setLeave_id(rst.getString("leave_id"));
			lvinfo.setEmp_id(rst.getString("emp_id"));
			lvinfo.setLeave_type(rst.getString("type"));
			lvinfo.setRequested_date(rst.getString("fromdate"));
			lvinfo.setTo_date(rst.getString("to_date"));
			lvinfo.setFrom_time(rst.getString("from_time"));
			lvinfo.setTo_time(rst.getString("to_time"));
			lvinfo.setReason(rst.getString("reason"));
			lvinfo.setApproved_by(rst.getString("approved_by"));
			lvelist.add(lvinfo);
			
			
			
			
			
		}
		
		return lvelist;
	}

	public boolean Approvedlv(String leave_id) throws SQLException {
		String sql = "Update leave_table set state ='1' where leave_id = '"+leave_id+"'";
		Statement stm = conn.createStatement();
		int rst = stm.executeUpdate(sql);
		return rst>0;
		
	}
	


	public int Rejectlv(String  leave_id) throws SQLException {
		String sql = "Update leave_table set state = '-1' where leave_id ='"+leave_id+"'";
		Statement stm = conn.createStatement();
		int rstt = stm.executeUpdate(sql);
		
		
		
		return rstt;
		
	}

	
	public ArrayList<LeaveInfo> getShowLeaves() throws SQLException {
		
		
		String sql = "select * from leave_table  ";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<LeaveInfo> lvelist = new ArrayList<LeaveInfo>();
		
		while (rst.next()) {
			LeaveInfo lvinfo = new LeaveInfo();
			
			lvinfo.setLeave_id(rst.getString("leave_id"));
			lvinfo.setEmp_id(rst.getString("emp_id"));
			lvinfo.setLeave_type(rst.getString("type"));
			lvinfo.setRequested_date(rst.getString("fromdate"));
			lvinfo.setTo_date(rst.getString("to_date"));
			lvinfo.setFrom_time(rst.getString("from_time"));
			lvinfo.setTo_time(rst.getString("to_time"));
			lvinfo.setReason(rst.getString("reason"));
			lvinfo.setApproved_by(rst.getString("approved_by"));
			lvinfo.setState(Integer.parseInt(rst.getString("state")));
			lvelist.add(lvinfo);
			
			
			
			
			
		}
		
		return lvelist;
	}
	
		
		
	}


