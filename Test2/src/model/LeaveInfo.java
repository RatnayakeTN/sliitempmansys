package model;

public class LeaveInfo {

	private String leave_id;
	private String emp_id;
	private String leave_type;
	private String requested_date;
	private String To_date;
	private String from_time;
	private String To_time;
	private String reason;
	private String approved_by;
	private int state;
	
	public LeaveInfo(String leave_id, String emp_id, String leave_type, String requested_date, String to_date,String from_time ,String to_time,  String reason,
			String approved_by, int state) {
		super();
		this.leave_id = leave_id;
		this.emp_id = emp_id;
		this.leave_type = leave_type;
		this.requested_date = requested_date;
		To_date = to_date;
		this.from_time = from_time;
		this.To_time = to_time;
		this.reason = reason;
		this.approved_by = approved_by;
		this.state = state;
	}

	public LeaveInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getLeave_id() {
		return leave_id;
	}

	public void setLeave_id(String leave_id) {
		this.leave_id = leave_id;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	public String getRequested_date() {
		return requested_date;
	}

	public void setRequested_date(String fromdate) {
		this.requested_date = fromdate;
	}

	public String getTo_date() {
		return To_date;
	}

	public void setTo_date(String todate) {
		To_date = todate;
	}
	public String getFrom_time() {
		return from_time;
	}

	public void setFrom_time(String from_time) {
		this.from_time = from_time;
	}

	public String getTo_time() {
		return To_time;
	}

	public void setTo_time(String to_time) {
		To_time = to_time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getApproved_by() {
		return approved_by;
	}

	public void setApproved_by(String approved_by) {
		this.approved_by = approved_by;
	}

	public int getState() {
		return state;
	}

	public void setState(int sting) {
		this.state = sting;
	}

	

	

	
	
	
	
	
	
	
	

}
