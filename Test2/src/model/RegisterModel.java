package model;

public class RegisterModel {
	
	private String uid;
	private String fname;
	private String lname;
	private String email;
	private String contactNo;
	private String userName;
	private String password;
	private String addrerss;
	private String position;
	private String userLevel;
	
	public RegisterModel() {
	}

	public RegisterModel(String uid, String fname, String lname, String email, String contactNo, String userName,
			String password, String addrerss, String position, String userLevel) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contactNo = contactNo;
		this.userName = userName;
		this.password = password;
		this.addrerss = addrerss;
		this.position = position;
		this.userLevel = userLevel;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddrerss() {
		return addrerss;
	}

	public void setAddrerss(String addrerss) {
		this.addrerss = addrerss;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	
	

}
