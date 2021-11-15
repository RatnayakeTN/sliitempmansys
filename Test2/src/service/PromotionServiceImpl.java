package service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.Promotion;
import service.PromotionService;
import util.MyDBconnectionUtil;

public class PromotionServiceImpl implements PromotionService {
	private static Connection conn;
	
	public PromotionServiceImpl() {
		
		conn = MyDBconnectionUtil.getDBconnection();
		
	}

	@Override
	public boolean addPromo(Promotion promo) throws SQLException {
		String  sql= "Insert into promotions values(?,?,?,?,?,?,?)";
		PreparedStatement stm= conn.prepareStatement(sql);
		stm.setObject(1,null);
		stm.setObject(2, promo.getDesignation());
		stm.setObject(3, promo.getApplicant());
		stm.setObject(4, promo.getApproved_by());
		stm.setObject(5, promo.getStat_date());
		stm.setObject(6, promo.getDescription());
		stm.setObject(7, 1);
		int res= stm.executeUpdate();
		return res>0;
	}

	@Override
	public ArrayList<Promotion> getAllPromotions() throws SQLException {
		String  sql= "select * from promotions";
		Statement stm= conn.createStatement();
		ResultSet rst= stm.executeQuery(sql);
		ArrayList<Promotion> promoList= new ArrayList<>();
		
		while(rst.next()) {
			Promotion promo= new Promotion();
			promo.setProm_id(rst.getInt("prom_id"));
			promo.setDesignation(rst.getString("designation"));
			promo.setApplicant(rst.getInt("applicant"));
			promo.setApproved_by(rst.getInt("approved_by"));
			promo.setStat_date(rst.getString("stat_date"));
			promo.setDescription(rst.getString("description"));
			promo.setStatus(rst.getBoolean("status"));

			promoList.add(promo);
			
		}
		return promoList;
	}


}
