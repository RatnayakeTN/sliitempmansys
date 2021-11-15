package model;

public class BasicSalaryDetailsModel {
	
	private String tableId;
	private String empId;
	private String basicSalary;
	private String allowances;
	
	public BasicSalaryDetailsModel() {
		
	}

	public BasicSalaryDetailsModel(String tableId, String empId, String basicSalary, String allowances) {
		super();
		this.tableId = tableId;
		this.empId = empId;
		this.basicSalary = basicSalary;
		this.allowances = allowances;
	}
	

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}

	public String getAllowances() {
		return allowances;
	}

	public void setAllowances(String allowances) {
		this.allowances = allowances;
	}
	
	

}
