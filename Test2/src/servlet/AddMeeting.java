package servlet;

import java.io.IOException;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.MyDBconnectionUtil;
import model.MeetingInfo;



@WebServlet("/AddMeeting")
public class AddMeeting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("success");
		
		String descriptions = request.getParameter("description");
		String location = request.getParameter("location");
		String date = request.getParameter("date");
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String initiator = request.getParameter("initiator");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   String update=dtf.format(now);
		   System.out.println(update);  
		
		MeetingInfo meeting = new MeetingInfo();
		
		meeting.setDescription(descriptions);
		meeting.setLocation(location);
		meeting.setDate(date);
		meeting.setStart_time(start_time);
		meeting.setEnd_time(end_time);
		meeting.setInitiator(initiator);
		
		try {
			MyDBconnectionUtil conn=new MyDBconnectionUtil();
			Connection con=conn.getDBconnection();
			
			String get_descriptions=meeting.getDescription();
			String get_location=meeting.getLocation();
			String get_date=meeting.getDate();
			String get_start_time=meeting.getStart_time();
			String get_end_time=meeting.getEnd_time();
			String get_initiator=meeting.getInitiator();
			
			System.out.println(get_descriptions);
			System.out.println(get_location);
			System.out.println(get_date);
			System.out.println(get_start_time);
			System.out.println(get_end_time);
			System.out.println(get_initiator);

			

			
			
				
				
				String Query1="Insert into meetings(date,description,location,start_time,end_time,initiator) values (?,?,?,?,?,?)";
				PreparedStatement ps=(PreparedStatement) con.prepareStatement(Query1);
				
				ps.setString(1, get_date);
				ps.setString(2, get_descriptions);
				ps.setString(3, get_location);
				ps.setString(4, get_start_time);
				ps.setString(5, get_end_time);
				ps.setString(6, get_initiator);


				ps.executeUpdate();

			
				String re ="Added successfully";
				request.setAttribute("delete", re);
				RequestDispatcher  rd1 = request.getRequestDispatcher("/Tem.jsp");
				rd1.forward(request, response);
			
			
			
			

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			String re ="Failed check again";
			request.setAttribute("delete", re);
			RequestDispatcher  rd1 = request.getRequestDispatcher("/Tem.jsp");
			rd1.forward(request, response);
		}
		
		
		
	}

}
