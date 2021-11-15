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

import model.Master_Salary;
import service.IMasterSalaryService;
import service.MasterSalaryServiceImpl;

/**
 * Servlet implementation class InsertSalaryInfoServlet
 */
@WebServlet("/InsertSalaryInfoServlet")
public class InsertSalaryInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSalaryInfoServlet() {
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
		
		
		Master_Salary sal = new Master_Salary();
		
		String emp_id = request.getParameter("employeeid");
		String basic = request.getParameter("basicsalary");
		String allowances = request.getParameter("allowances");
		
		sal.setEmp_id(emp_id);
		sal.setBasic_salary(basic);
		sal.setAllowances(allowances);

		
		IMasterSalaryService salaryService = new MasterSalaryServiceImpl();
		
		
		try {
			boolean isadded = salaryService.addSalaryInfo(sal);
			
			if(isadded==true) {	
				
					PrintWriter writer = response.getWriter();

					writer.println("<script>");
					writer.println("alert('Salary Details Added Successfully')");
					writer.println("</script>");
					
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Register.jsp");
					dispatcher.include(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	

}
