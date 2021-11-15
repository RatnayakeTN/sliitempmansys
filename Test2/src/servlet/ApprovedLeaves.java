package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LeaveService;
import service.LeaveServieImpl;

/**
 * Servlet implementation class ApprovedLeaves
 */
@WebServlet("/ApprovedLeaves")
public class ApprovedLeaves extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovedLeaves() {
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
		
		String pprove = request.getParameter("Leave_id");
		
		System.out.println(pprove);
		
		LeaveService leaveservice = new LeaveServieImpl();
		
		try {
			boolean isApproved = leaveservice.Approvedlv(pprove);
			PrintWriter writer= response.getWriter();
			writer.println("<script>");
			writer.println("alert('Leave Approved')");
			writer.println("</script>");
			
			
			RequestDispatcher dispacher = getServletContext().getRequestDispatcher("/Leaveapprove.jsp");
			response.setContentType("text/html;charset=UTF-8");
			dispacher.include(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
