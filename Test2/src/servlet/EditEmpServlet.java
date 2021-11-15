package servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;
import service.EmployeeServiceImpl;

/**
 * Servlet implementation class EditEmpServlet
 */
@WebServlet("/EditEmpServlet")
public class EditEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmpServlet() {
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
		System.out.println("Served to Edit");
		String userId= request.getParameter("userId");
		String field= request.getParameter("field");
		String update= request.getParameter("edit");
		
		EmployeeService empService= new EmployeeServiceImpl();
		
		try {
			boolean isUpdated=  empService.updateEmployee(userId, field, update);
			
			if(isUpdated) {
				System.out.println("Employee Updated");
				RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/FinalUserprofile.jsp");
				dispatcher.include(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
