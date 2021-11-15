package com.man.model;
//IT18170726
//T.N Ratnayake

//This is the Manager class
public class Manager {
	
	private String managerID;
	private String name;
	private String department;
	private String address;
	private String qualifications;
	private String gender;
	

	public String getManagerID() {
		return managerID;
	}
	

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}
	

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	

	public String getDepartment() {
		return department;
	}
	

	public void setDepartment(String department) {
		this.department = department;
	}
	

	public String getAddress() {
		return address;
	}
	

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQualifications() {
		return qualifications;
	}
	

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public String getGender() {
		return gender;
	}
	

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String toString() {
		
		return "Manager ID = " + managerID + "\n" + "Manager Name = " + name + "\n" 
				+ "Department = " + department + "\n"+ "Address = " + address + "\n"
				 + "Gender = " + gender;
	}
	
	

}
