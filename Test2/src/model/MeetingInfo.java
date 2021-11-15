package model;



public class MeetingInfo {
	
	private String meeting_id;
	private String date;	
	private String description;	
	private String location;	
	private String start_time;	
	private String end_time;	
	private String initiator;	
	private String created_datetime;
	//private String updated_by;
	private String updated_datetime;
	
	
	/*public MeetingInfo(String meeting_id, String date, String description, String location, String start_time,
			String end_time, String initiator, String created_datetime, String updated_by, String updated_datetime) {
		super();
		this.meeting_id = meeting_id;
		this.date = date;
		this.description = description;
		this.location = location;
		this.start_time = start_time;
		this.end_time = end_time;
		this.initiator = initiator;
		this.created_datetime = created_datetime;
		this.updated_by = updated_by;
		this.updated_datetime = updated_datetime;
	}

	public MeetingInfo() {
		// TODO Auto-generated constructor stub
	}*/

	public String getMeeting_id() {
		return meeting_id;
	}
	
	public void setMeeting_id(String meeting_id) {
		this.meeting_id = meeting_id;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getStart_time() {
		return start_time;
	}
	
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	
	public String getEnd_time() {
		return end_time;
	}
	
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
	public String getInitiator() {
		return initiator;
	}
	
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
	
	public String getCreated_datetime() {
		return created_datetime;
	}
	
	public void setCreated_datetime(String created_datetime) {
		this.created_datetime = created_datetime;
	}
	
	/*public String getUpdated_by() {
		return updated_by;
	}
	
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}*/
	
	public String getUpdated_datetime() {
		return updated_datetime;
	}
	
	public void setUpdated_datetime(String updated_datetime) {
		this.updated_datetime = updated_datetime;
	}

}
