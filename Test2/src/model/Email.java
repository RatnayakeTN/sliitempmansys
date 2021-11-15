package model;

import javax.mail.*;

import java.util.Date;

public class Email {
	
	private String subject;
	private Address from;
	private Date sentDate;
	//private String body;
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String string) {
		this.subject = string;
	}
	public Address getFrom() {
		return from;
	}
	public void setFrom(Address address) {
		this.from = address;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	/*public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}*/
	
		
	
}
