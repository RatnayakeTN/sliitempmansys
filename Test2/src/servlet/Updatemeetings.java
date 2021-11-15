package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

/**
 * Servlet implementation class Updatemeetings
 */
@WebServlet("/Updatemeetings")
public class Updatemeetings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatemeetings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("post update");
		
		String meetID = request.getParameter("meetID");
		String description=request.getParameter("description");
		String location=request.getParameter("location");
		String date=request.getParameter("date");
		String start_time=request.getParameter("start_time");
		String end_time=request.getParameter("end_time");
		String initiator =request.getParameter("initiator");
		
		
		System.out.println(meetID);
		System.out.println(description);
		System.out.println(meetID);

		Connection con =null;
		PreparedStatement ps = null;
		int result;
		
	String sql="UPDATE `meetings` SET `date` = '"+date+"', `description` = '"+description+"', `location` = '"+location+"', `start_time` = '"+start_time+"', `end_time` = '"+end_time+"', `initiator` = '"+initiator+"' WHERE `meetings`.`meeting_id` = '"+meetID+"'";
		
			try {
				
				con = new MyDBconnectionUtil().getDBconnection();
				ps=con.prepareStatement(sql);
				result= ps.executeUpdate();
				System.out.println(ps);
				System.out.println(result);
				String re ="Update successfully";
				request.setAttribute("update", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/ShowMeetings.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				String re ="Update Failed";
				request.setAttribute("update", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/ShowMeetings.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}
	}
	}

