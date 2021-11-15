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
 * Servlet implementation class UpdateSalaryInfoServlet
 */
@WebServlet("/UpdateSalaryInfoServlet")
public class UpdateSalaryInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSalaryInfoServlet() {
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
		String sID = request.getParameter("tableid");
		String basic_salary= request.getParameter("basicsalary");
		String allowances = request.getParameter("allowances");
		
		
		Master_Salary m= new Master_Salary();
		m.setTable_id(sID);
		m.setBasic_salary(basic_salary);
		m.setAllowances(allowances);
		
		IMasterSalaryService serv = new MasterSalaryServiceImpl();
		
		try {
			boolean isAdded= serv.updateSalaryInfo(m);
			
			if(isAdded==true) {
				
				PrintWriter writer= response.getWriter();
				writer.println("<script>");
				writer.println("alert('Updated succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/ListMasterSalaryInfo.jsp");
				response.setContentType("text/html;charset=UTF-8");
				dispatcher.include(request, response);
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
