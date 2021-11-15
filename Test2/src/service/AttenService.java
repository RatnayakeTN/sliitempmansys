package service;

import java.sql.SQLException;

import java.util.ArrayList;

import model.AttendanceInfo;

public interface AttenService {

	public boolean addAttenRecord(AttendanceInfo AttenInfo) throws SQLException;
	
	public boolean deleteAttenRecord(String AttenRecId) throws SQLException;
	
	public boolean updateAttenRecord(AttendanceInfo AttenInfo) throws SQLException;
	
	public ArrayList<AttendanceInfo> getAllAttenRecords() throws SQLException;
	
	public ArrayList<AttendanceInfo> getAttenSpeci(String AttenRecId) throws SQLException;
}
