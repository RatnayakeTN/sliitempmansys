package service;

import java.sql.SQLException;

import model.BasicSalaryDetailsModel;

public interface IBasicSalaryDetails {
	
	boolean addBasicSalaryDetails(BasicSalaryDetailsModel my)throws SQLException;

}
