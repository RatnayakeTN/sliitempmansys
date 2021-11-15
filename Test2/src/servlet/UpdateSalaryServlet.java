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
import model.Salary;
import service.IMasterSalaryService;
import service.ISalaryService;
import service.MasterSalaryServiceImpl;
import service.SalaryServiceImpl;

/**
 * Servlet implementation class UpdateSalary
 */
@WebServlet("/UpdateSalaryServlet")
public class UpdateSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSalaryServlet() {
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
		String sID = request.getParameter("salary_id");
		String month = request.getParameter("month");
		String epf = request.getParameter("epf_deductions");
		String OT = request.getParameter("OT");
		String deductions= request.getParameter("deductions");
		String netsalary = request.getParameter("net_salary");
		
		Salary m= new Salary();
	
		m.setSalary_id(sID);
		m.setMonth(month);
		m.setEpf_deductions(epf);
		m.setOT(OT);
		m.setDeductions(deductions);
		m.setNet_salary(netsalary);
		
		ISalaryService serv = new SalaryServiceImpl();
		
		try {
			boolean isAdded= serv.updateSalaryInfo(m);
			
			if(isAdded==true) {
				
				PrintWriter writer= response.getWriter();
				writer.println("<script>");
				writer.println("alert('Salary Details Updated succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/DisplaySalary.jsp");
				response.setContentType("text/html;charset=UTF-8");
				dispatcher.include(request, response);
						
			}else {
				System.out.println("error");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
