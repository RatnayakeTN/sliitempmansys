package model;

public class Master_Salary {

	private String table_id;
	protected String emp_id;
	protected String basic_salary;
	protected String allowances;
	protected String status;
	private String created_by;
	private String created_date;
	private String updated_by;
	private String updated_datetime;
	
	
	
	public Master_Salary() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Master_Salary(String table_id, String emp_id, String basic_salary, String allowances, String status,
			String created_by, String created_date, String updated_by, String updated_datetime) {
		super();
		this.table_id = table_id;
		this.emp_id = emp_id;
		this.basic_salary = basic_salary;
		this.allowances = allowances;
		this.status = status;
		this.created_by = created_by;
		this.created_date = created_date;
		this.updated_by = updated_by;
		this.updated_datetime = updated_datetime;
	}



	public String getTable_id() {
		return table_id;
	}



	public void setTable_id(String table_id) {
		this.table_id = table_id;
	}



	public String getEmp_id() {
		return emp_id;
	}



	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}



	public String getBasic_salary() {
		return basic_salary;
	}



	public void setBasic_salary(String basic_salary) {
		this.basic_salary = basic_salary;
	}



	public String getAllowances() {
		return allowances;
	}



	public void setAllowances(String allowances) {
		this.allowances = allowances;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getCreated_by() {
		return created_by;
	}



	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}



	public String getCreated_date() {
		return created_date;
	}



	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}



	public String getUpdated_by() {
		return updated_by;
	}



	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}



	public String getUpdated_datetime() {
		return updated_datetime;
	}



	public void setUpdated_datetime(String updated_datetime) {
		this.updated_datetime = updated_datetime;
	}
	
	
	

	
}
