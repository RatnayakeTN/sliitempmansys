package service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.RegisterModel;

public interface IRegisterUser {
	
	boolean registerUser(RegisterModel my)throws SQLException;
	
	public ArrayList<RegisterModel> getUserDetails() throws SQLException;
	
	boolean deleteUserDetails(String Did) throws SQLException;
	
	boolean validateUser(String username, String password)throws SQLException;

}
