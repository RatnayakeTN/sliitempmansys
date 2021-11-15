package com.handlers;

import java.sql.*;
import java.util.*;
import model.Notification;


import util.MyDBconnectionUtil;


public class NotifyDao {
	
	/*
	 * inserting a notification
	 */
	public static int  insert(Notification n) {
		int status=0;
		try {
			Connection connection=MyDBconnectionUtil.getDBconnection();
			PreparedStatement ps=connection.prepareStatement(
					"insert into notifications (type,specialMsg) values(?,?)");
					ps.setInt(1, n.getType());
					ps.setString(2, n.getSpecialMsg());
					status=ps.executeUpdate();
					
					
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	
	/*
	 * listing notifications
	 */
	
	public static List<Notification> getAllrecords(){
		List<Notification> list=new ArrayList<Notification>();
		
		try {
			Connection connection=MyDBconnectionUtil.getDBconnection();
			PreparedStatement ps = connection.prepareStatement("select * from contacts");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Notification n = new Notification();
				n.setId(rs.getInt("id"));
				n.setType(rs.getInt("type"));
				n.setSpecialMsg(rs.getString("specialMsg"));
				list.add(n);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	
}
