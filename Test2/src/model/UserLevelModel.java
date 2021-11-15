package model;

public class UserLevelModel {
	
	private String Uid;
	private String Ulevel;
	private String No;
	private String cDate;
	private String uDate;
	private String State;
	
	public UserLevelModel() {
	}

	public UserLevelModel(String uid, String ulevel, String no, String cDate, String uDate, String state) {
		super();
		this.Uid = uid;
		this.Ulevel = ulevel;
		this.No = no;
		this.cDate = cDate;
		this.uDate = uDate;
		this.State = state;
	}

	public String getUid() {
		return Uid;
	}

	public void setUid(String uid) {
		this.Uid = uid;
	}

	public String getUlevel() {
		return Ulevel;
	}

	public void setUlevel(String ulevel) {
		this.Ulevel = ulevel;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		this.No = no;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	public String getuDate() {
		return uDate;
	}

	public void setuDate(String uDate) {
		this.uDate = uDate;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		this.State = state;
	}

	
	
	

}
