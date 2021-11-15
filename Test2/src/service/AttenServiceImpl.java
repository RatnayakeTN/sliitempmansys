package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.AttendanceInfo;

import util.MyDBconnectionUtil;

public class AttenServiceImpl implements AttenService {

	private static Connection conn;
	
	public AttenServiceImpl(){
		conn= MyDBconnectionUtil.getDBconnection();

	}
	
	public boolean addAttenRecord(AttendanceInfo AttenInfo) throws SQLException{
		// TODO Auto-generated method stub
		String  sql= "Insert into attendance values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stm= conn.prepareStatement(sql);
		stm.setObject(1,null);
		stm.setObject(2, AttenInfo.getEmpId());
		stm.setObject(3, AttenInfo.getDate());
		stm.setObject(4, AttenInfo.getInTime()); 
		stm.setObject(5, AttenInfo.getOutTime()); 
		stm.setObject(6, AttenInfo.getHoursWorked());
		stm.setObject(7, AttenInfo.getCreatedBy()); 
		stm.setObject(8, AttenInfo.getUpdatedBy());
		stm.setObject(9, 1);
		stm.setObject(10, null);  
		int res= stm.executeUpdate();
		return res>0;
	}

	@Override
	public boolean deleteAttenRecord(String AttenRecId) throws SQLException {
		// TODO Auto-generated method stub
		String  sql= "update attendance set Status = -1 where AttenRecId='"+AttenRecId+"'";
		Statement stm= conn.createStatement();
		int rslt= stm.executeUpdate(sql);
		return rslt>0;
	}

	@Override
	public boolean updateAttenRecord(AttendanceInfo AttenInfo) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update attendance set date = ?, start_time = ?, end_time = ? ,hoursWorked = ? where AttenRecId = " + Integer.parseInt(AttenInfo.getAttId());
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setObject(1,AttenInfo.getDate());
		stm.setObject(2,AttenInfo.getInTime());
		stm.setObject(3,AttenInfo.getOutTime());
		stm.setObject(4,Integer.parseInt(AttenInfo.getHoursWorked()));
		
		int res = stm.executeUpdate();
		
		return res>0;
	}

	@Override
	public ArrayList<AttendanceInfo> getAllAttenRecords() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "Select attendance.AttenRecId, attendance.EmployeeID, attendance.date, attendance.start_time, attendance.end_time, attendance.hoursWorked, attendance.CreatedBy, attendance.UpdatedBy, attendance.Status, attendance.UpdatedTime, testuser.uid, testuser.first_name from attendance, testuser where Status = 1 && attendance.EmployeeID = testuser.uid";
		java.sql.Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<AttendanceInfo> uslst = new ArrayList<AttendanceInfo>();
		while(rst.next()) {
			AttendanceInfo us = new AttendanceInfo();
			us.setAttId(rst.getString("attendance.AttenRecId"));
			us.setEmpId(rst.getString("attendance.EmployeeID"));
			us.setDate(rst.getString("attendance.date"));
			us.setInTime(rst.getString("attendance.start_time"));
			us.setOutTime(rst.getString("attendance.end_time"));
			us.setHoursWorked(rst.getString("attendance.hoursWorked"));
			us.setCreatedBy(rst.getString("testuser.first_name"));
			uslst.add(us);
		}
		return uslst;
	}

	@Override
	public ArrayList<AttendanceInfo> getAttenSpeci(String AttenRecId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "Select * from attendance where AttenRecId =" + AttenRecId;
		java.sql.Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<AttendanceInfo> uslst = new ArrayList<AttendanceInfo>();
		while(rst.next()) {
			AttendanceInfo us = new AttendanceInfo();
			us.setAttId(rst.getString("AttenRecId"));
			us.setEmpId(rst.getString("EmployeeID"));
			us.setDate(rst.getString("date"));
			us.setInTime(rst.getString("start_time"));
			us.setOutTime(rst.getString("end_time"));
			us.setHoursWorked(rst.getString("hoursWorked"));
			uslst.add(us);
		}
		return uslst;
	}

}
