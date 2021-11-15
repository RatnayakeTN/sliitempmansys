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
 * Servlet implementation class Delmeetings
 */
@WebServlet("/Delmeetings")
public class Delmeetings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delmeetings() {
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
		System.out.println("success");
		String Vid =request.getParameter("voter");
		
		Connection con =null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM `meetings` WHERE `meetings`.`meeting_id` = '"+Vid+"'";
			int result=0;
		
		try {
			con = new MyDBconnectionUtil().getDBconnection();
			ps = con.prepareStatement(sql);
			result=ps.executeUpdate();
			System.out.println(ps);
			System.out.println(result);
			String re ="Delete successfully";
			request.setAttribute("delete", re);
			RequestDispatcher  rd = request.getRequestDispatcher("/ShowMeetings.jsp");
			rd.forward(request, response);
			
		
			
		} catch (Exception e1) {
		
			e1.printStackTrace();
			String re ="Invalid meeting ID";
			request.setAttribute("delete", re);
			RequestDispatcher  rd = request.getRequestDispatcher("/ShowMeetings.jsp");
			rd.forward(request, response);
		}
	}
	}

