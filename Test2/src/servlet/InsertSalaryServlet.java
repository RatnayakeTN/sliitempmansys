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

import model.Salary;
import service.ISalaryService;
import service.SalaryServiceImpl;

/**
 * Servlet implementation class InsertSalary
 */
@WebServlet("/InsertSalaryServlet")
public class InsertSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSalaryServlet() {
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
	
		Salary sal = new Salary();
		
		String emp_id = request.getParameter("emp_id");
		String yearmonth = request.getParameter("month");
		String epf_deductions = request.getParameter("epf_deductions");
		String OT = request.getParameter("OT");
		String deductions = request.getParameter("deductions");
		String net_salary = request.getParameter("net_salary");
		

		
		sal.setEmp_id(emp_id);
		sal.setMonth(yearmonth);
		sal.setEpf_deductions(epf_deductions);
		sal.setOT(OT);
		sal.setDeductions(deductions);
		sal.setNet_salary(net_salary);

		ISalaryService salaryService = new SalaryServiceImpl();
		
		
		try {
			boolean isadded = salaryService.addSalary(sal);
			
			if(isadded==true) {	
				
					PrintWriter writer = response.getWriter();

					writer.println("<script>");
					writer.println("alert('Added Successfully')");
					writer.println("</script>");
					
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplaySalary.jsp");
					dispatcher.include(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
