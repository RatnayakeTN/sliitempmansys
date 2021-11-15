package model;

public class PositionModel {
	
	private String Pid;
	private String PositionName;
	private String BasicSalary;
	private String cDate;
	private String uDate;
	private String State;
	
	public PositionModel() {
		
	}

	public PositionModel(String pid, String positionName, String basicSalary, String cDate, String uDate,
			String state) {
		super();
		this.Pid = pid;
		this.PositionName = positionName;
		this.BasicSalary = basicSalary;
		this.cDate = cDate;
		this.uDate = uDate;
		this.State = state;
	}

	public String getPid() {
		return Pid;
	}

	public void setPid(String pid) {
		this.Pid = pid;
	}

	public String getPositionName() {
		return PositionName;
	}

	public void setPositionName(String positionName) {
		this.PositionName = positionName;
	}

	public String getBasicSalary() {
		return BasicSalary;
	}

	public void setBasicSalary(String basicSalary) {
		this.BasicSalary = basicSalary;
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
