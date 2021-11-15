package servlet;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Master_Salary;
import service.IMasterSalaryService;
import service.ISalaryService;
import service.MasterSalaryServiceImpl;
import service.SalaryServiceImpl;

/**
 * Servlet implementation class CalculateSalary
 */
@WebServlet("/CalculateSalaryServlet")
public class CalculateSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateSalaryServlet() {
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
		
		
		
		try {
			String yearmonth = request.getParameter("yearmonth");
			String emp = request.getParameter("emp_id");		
	 		ISalaryService service = new SalaryServiceImpl();
				
	 		   
	 		   
	 			Master_Salary m = service.getBasicSalarym(emp);
	 			
	 			double salb = Double.parseDouble(m.getBasic_salary());
	 			double allow = Double.parseDouble(m.getAllowances());
	 			
	 			System.out.println(salb);
	 			System.out.println(allow);
	 			
	 			double sal = salb+allow;
	 			
	 			System.out.println(sal);
	 			
	 			
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CalculateSalary.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
	
	}

}
