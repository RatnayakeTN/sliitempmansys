package service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.UserLevelModel;

public interface IUserLevel {

	boolean addNewUserLevel(UserLevelModel my)throws SQLException;
	
	public ArrayList<UserLevelModel> getAllUserLevels() throws SQLException;

	boolean deleteUserlevel(String Did) throws SQLException;
	
	public ArrayList<UserLevelModel> SelectUserLevels() throws SQLException;
	
	public boolean updateUserlevel(UserLevelModel my) throws SQLException;
	
	public ArrayList<UserLevelModel> getEditedUserLevels(String level) throws SQLException;


}
