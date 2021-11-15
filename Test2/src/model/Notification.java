package model;

import java.sql.Date;

public class Notification {
	private int id;
	private int type;
	//private int sender;
	private String specialMsg;
	//private int priority;
	//private Date date;
	
	public Notification() {
		
	}
	//public Notification(int id, int type, int sender, String specialMsg, int priority, Date date) {
	public Notification(int id, int type, String specialMsg) {
		super();
		this.id = id;
		this.type = type;
		//this.sender = sender;
		this.specialMsg = specialMsg;
		//this.priority = priority;
		//this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	/*public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}*/
	public String getSpecialMsg() {
		return specialMsg;
	}
	
	public void setSpecialMsg(String specialMsg) {
		this.specialMsg = specialMsg;
	}
	/*public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}*/
	
	
	
	
}
