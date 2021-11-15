package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.xml.ws.Dispatch;

import model.LeaveInfo;
import service.LeaveService;
import service.LeaveServieImpl;

//import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class ApplyLeaves
 */
@WebServlet("/ApplyLeaves")
public class ApplyLeaves extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyLeaves() {
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
		
		
		
		String type = request.getParameter("Leave_type");
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		String from_time = request.getParameter("from_time");
		String to_time = request.getParameter("to_time");
		String reason = request.getParameter("reason");
		
		
		
		
		LeaveInfo leave = new LeaveInfo();
		
		leave.setLeave_id("0");
		leave.setEmp_id("3");
		leave.setLeave_type(type);
		leave.setRequested_date(from_date);
		leave.setTo_date(to_date);
		leave.setFrom_time(from_time);
		leave.setTo_time(to_time);
		leave.setReason(reason);
		leave.setApproved_by("");
		leave.setState(0);
		
		
		
		LeaveService lvserviceimpl = new LeaveServieImpl();
		
		try {
			
			boolean isAdded = lvserviceimpl.addNewLeaveInfo(leave);
			System.out.println("Successfull");
			
			PrintWriter writer= response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Updated succesfully')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/ApplyLeaves2.jsp");
			response.setContentType("text/html;charset=UTF-8");
			dispatcher.include(request, response);
			
			
		} catch (SQLException e) {
		
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		
		} 	
		
		

		
		
		
		
		
		
	}

	

	

}
