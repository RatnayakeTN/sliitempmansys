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

import model.BasicSalaryDetailsModel;
import service.BasicSalaryServiceImpl;
import service.IBasicSalaryDetails;

/**
 * Servlet implementation class AddBasicSalaryDetailsServlet
 */
@WebServlet("/AddBasicSalaryDetailsServlet")
public class AddBasicSalaryDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBasicSalaryDetailsServlet() {
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
		
		BasicSalaryDetailsModel my = new BasicSalaryDetailsModel();
		
		String empId = request.getParameter("employeeid");
		String basicsal = request.getParameter("basicsalary");
		String allowances = request.getParameter("allowances");
		
		my.setEmpId(empId);
		my.setBasicSalary(basicsal);
		my.setAllowances(allowances);
		
		IBasicSalaryDetails salarydetails = new BasicSalaryServiceImpl();
		
		try {
			boolean isadded = salarydetails.addBasicSalaryDetails(my);
			
			if(isadded == true) {
				System.out.println("success");
				
				PrintWriter writer = response.getWriter();
				
				writer.println("<script>");
				writer.println("alert('Details added succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Register.jsp");
				dispatcher.include(request, response);
			}
			else if(isadded == false) {
				System.out.println("Error");
		    }
		
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
