package model;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AttendanceInfo {

	private String AttId;
	private String EmpId;
	private String date;
	private String inTime;
	private String outTime;
	private String hoursWorked;
	private int status;
	private String createdBy;
	private String updatedBy;
	
	
	public AttendanceInfo(String attId, String empId, String date, String inTime, String outTime, String hoursWorked, int status, String createdBy, String updatedBy) {
		super();
		AttId = attId;
		EmpId = empId;
		this.date = date;
		this.inTime = inTime;
		this.outTime = outTime;
		this.hoursWorked = hoursWorked;
		this.status = status;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	
	

	public AttendanceInfo() {
		super();
	}



	public String getAttId() {
		return AttId;
	}

	public void setAttId(String attId) {
		AttId = attId;
	}

	public String getEmpId() {
		return EmpId;
	}

	public void setEmpId(String empId) {
		EmpId = empId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(String hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public String calchours() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		java.util.Date da1;
		java.util.Date da2;
		try {
			da1 = format.parse(this.inTime);
			da2 = format.parse(this.outTime);
			long diff = da2.getTime() - da1.getTime();
			int diffHours = (int) (diff / (60 * 60 * 1000) % 24);
			String tothours = Integer.toString(diffHours);
			return tothours;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Fail";

		
	}



	}
	
	

