package service;

import java.sql.SQLException;

import java.util.ArrayList;


import model.Promotion;

public interface PromotionService {
	boolean addPromo(Promotion promo)throws SQLException;

	public ArrayList<Promotion> getAllPromotions() throws SQLException;
}
