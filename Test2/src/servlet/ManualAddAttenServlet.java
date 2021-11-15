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

import model.AttendanceInfo;
import service.AttenService;
import service.AttenServiceImpl;

/**
 * Servlet implementation class ManualAddAttenServlet
 */
@WebServlet("/ManualAddAttenServlet")
public class ManualAddAttenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManualAddAttenServlet() {
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
		String EmpId = request.getParameter("empId");
		String createdBy= request.getParameter("user");
		String date = request.getParameter("date");
		String inTime= request.getParameter("inTime");
		String outTime = request.getParameter("outTime");
		
		AttendanceInfo atten= new AttendanceInfo();
		atten.setEmpId(EmpId);
		atten.setCreatedBy(createdBy);
		atten.setDate(date);
		atten.setInTime(inTime);
		atten.setOutTime(outTime);
		atten.setUpdatedBy("5");
		atten.setHoursWorked(atten.calchours());
		
		AttenService attenService = new AttenServiceImpl();
		
		try {
			boolean isAdded= attenService.addAttenRecord(atten);
			
			if(isAdded==true) {
				System.out.println("Record Added");
				PrintWriter writer= response.getWriter();
				writer.println("<script>");
				writer.println("alert('Added succesfully')");
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
