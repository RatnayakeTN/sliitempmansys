package service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.PositionModel;

public interface IPosition {
	
	boolean addNewPosition(PositionModel my)throws SQLException;
	
	public ArrayList<PositionModel> getAllPositions()throws SQLException;
	
	boolean deletePosition(String Did) throws SQLException;

	public ArrayList<PositionModel> getEditedPosition(String did) throws SQLException;

	public boolean updatePosition(PositionModel position)throws SQLException;

	

	

}
