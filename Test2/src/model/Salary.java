package model;

public class Salary {

	private String salary_id;
	private String emp_id;
	private String year;
	private String month;
	private String epf_deductions;
	//private double basic_salary;
	//private double epf2_amount;
	//private double etf_amount;
	//private double allowances;
	private String OT;
	private String deductions;
	private String net_salary;
	private String created_datetime;
	private String updated_datetime;
	private String approved_by;
	private String state;
	
	
	
	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Salary(String salary_id, String emp_id, String year, String month, String epf_deductions, String oT,
			String deductions, String net_salary, String approved_by, String state) {
		super();
		this.salary_id = salary_id;
		this.emp_id = emp_id;
		this.year = year;
		this.month = month;
		this.epf_deductions = epf_deductions;
		this.OT = oT;
		this.deductions = deductions;
		this.net_salary = net_salary;
		this.approved_by = approved_by;
		this.state = state;
	}



	public String getSalary_id() {
		return salary_id;
	}



	public void setSalary_id(String salary_id) {
		this.salary_id = salary_id;
	}



	public String getEmp_id() {
		return emp_id;
	}



	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public String getEpf_deductions() {
		return epf_deductions;
	}



	public void setEpf_deductions(String epf_deductions) {
		this.epf_deductions = epf_deductions;
	}



	public String getOT() {
		return OT;
	}



	public void setOT(String oT) {
		this.OT = oT;
	}



	public String getDeductions() {
		return deductions;
	}



	public void setDeductions(String deductions) {
		this.deductions = deductions;
	}



	public String getNet_salary() {
		return net_salary;
	}



	public void setNet_salary(String net_salary) {
		this.net_salary = net_salary;
	}



	public String getCreated_datetime() {
		return created_datetime;
	}



	public void setCreated_datetime(String created_datetime) {
		this.created_datetime = created_datetime;
	}



	public String getUpdated_datetime() {
		return updated_datetime;
	}



	public void setUpdated_datetime(String updated_datetime) {
		this.updated_datetime = updated_datetime;
	}



	public String getApproved_by() {
		return approved_by;
	}



	public void setApproved_by(String approved_by) {
		this.approved_by = approved_by;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	
	
	
	
	
}
