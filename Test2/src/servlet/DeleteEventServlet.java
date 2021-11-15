package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AttendanceInfo;
import service.AttenService;
import service.AttenServiceImpl;

/**
 * Servlet implementation class DeleteEventServlet
 */
@WebServlet("/DeleteEventServlet")
public class DeleteEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEventServlet() {
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
String AttenId = request.getParameter("AttenId");
		
		AttenService attenService = new AttenServiceImpl();
		
		try {
			boolean isAdded= attenService.deleteAttenRecord(AttenId);
			
			if(isAdded==true) {
			System.out.println("Record Deleted");
			PrintWriter writer= response.getWriter();
			writer.println("<script>");
			writer.println("alert('Deleted succesfully')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/AttenMan.jsp");
			response.setContentType("text/html;charset=UTF-8");
			dispatcher.include(request, response);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
