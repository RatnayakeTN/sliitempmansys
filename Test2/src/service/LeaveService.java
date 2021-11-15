package service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.LeaveInfo;

//import jdk.management.resource.internal.ApproverGroup;

public interface LeaveService {

	boolean addNewLeaveInfo(LeaveInfo leave) throws SQLException;

	public ArrayList<LeaveInfo> getAllLeaves() throws SQLException;
	
	public boolean Approvedlv(String leave_id) throws SQLException;
	
	public int Rejectlv(String leave_id) throws SQLException;
	
	public ArrayList<LeaveInfo>getShowLeaves() throws SQLException ;
	
	
}
