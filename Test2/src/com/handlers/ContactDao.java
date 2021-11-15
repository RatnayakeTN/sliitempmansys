
package com.handlers;

import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;

import model.Contact;
import util.MyDBconnectionUtil;
public class ContactDao {
	

	
	/**
	 * 
	 * @param saving contact
	 * @return
	 */
	public static int insert(Contact u){  
	    int status=0;  
	    try{  
	        Connection connection=MyDBconnectionUtil.getDBconnection();  
	        PreparedStatement ps=connection.prepareStatement(  
	        		"insert into contacts (email,name,designation,company,category) values(?,?,?,?,?)");  
	        ps.setString(1,u.getEmail());  
	        ps.setString(2,u.getName());  
	        ps.setString(3,u.getDesignation());  
	        ps.setString(4,u.getCompany());  
	        ps.setInt(5,u.getCategory());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	/**
	 * 
	 * @param updating contact
	 * @return
	 */
	public static int update(Contact u){  
	    int status=0;  
	    try{  
	        Connection connection=MyDBconnectionUtil.getDBconnection(); 
	        PreparedStatement ps=connection.prepareStatement(  
	        		"update contacts set email=?,name=?,designation=?,company=?,category=? where id=?");  
	        ps.setString(1,u.getEmail()); 
	        ps.setString(2,u.getName());  
	        ps.setString(3,u.getDesignation());  
	        ps.setString(4,u.getCompany());  
	        ps.setInt(5,u.getCategory());  
	        ps.setInt(6,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	/**
	 * 
	 * @param deleting contact
	 * @return
	 */
	public static int delete(Contact u){  
	    int status=0;  
	    try{  
	        Connection connection=MyDBconnectionUtil.getDBconnection();
	        PreparedStatement ps=connection.prepareStatement("delete from contacts where id=?");  
	        ps.setInt(1,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	
	/**
	 * @param Listing contacts
	 * @return
	 */
	public static List<Contact> getAllRecords(){  
	    List<Contact> list=new ArrayList<Contact>();  
	      
	    try{  
	        Connection connection=MyDBconnectionUtil.getDBconnection();  
	        PreparedStatement ps=connection.prepareStatement("select * from contacts");  
	        ResultSet rs=ps.executeQuery();  
	        
	        while(rs.next()){  
	            Contact u=new Contact();  
	            u.setId(rs.getInt("id"));  
	            u.setEmail(rs.getString("email"));  
	            u.setName(rs.getString("name"));  
	            u.setDesignation(rs.getString("designation"));  
	            u.setCompany(rs.getString("company"));  
	            u.setCategory(rs.getInt("category"));  
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	
	/**
	 * 
	 * @param get contact
	 * @return
	 */
	public static Contact getRecordById(int id){  
	    Contact u=null;  
	    try{  
	        Connection connection=MyDBconnectionUtil.getDBconnection();
	        PreparedStatement ps=connection.prepareStatement("select * from contacts where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        
	        while(rs.next()){  
	            u=new Contact();  
	            u.setId(rs.getInt("id"));  
	            u.setEmail(rs.getString("email"));  
	            u.setName(rs.getString("name"));  
	            u.setDesignation(rs.getString("designation"));  
	            u.setCompany(rs.getString("company"));  
	            u.setCategory(rs.getInt("category"));  ;  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}  
	
	
}
