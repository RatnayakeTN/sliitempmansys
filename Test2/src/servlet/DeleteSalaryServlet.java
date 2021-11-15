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

import service.ISalaryService;
import service.SalaryServiceImpl;

/**
 * Servlet implementation class DeleteSalary
 */
@WebServlet("/DeleteSalaryServlet")
public class DeleteSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSalaryServlet() {
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
		
        String sID = request.getParameter("deleteSalary");
		
        System.out.println("Error");
        
		ISalaryService salaryService = new SalaryServiceImpl();
		
		boolean isDeleted=false;
		
		try {
			isDeleted = salaryService.deleteSalary(sID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isDeleted==true) {
			
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Salary Details Deleted Successfully')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplaySalary.jsp");
			dispatcher.include(request, response);
		}
		else if(isDeleted==false) {
			System.out.println("Error");
		}
	}

}
