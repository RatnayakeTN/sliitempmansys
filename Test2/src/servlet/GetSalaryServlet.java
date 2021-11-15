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
import model.Salary;
import service.IMasterSalaryService;
import service.ISalaryService;
import service.MasterSalaryServiceImpl;
import service.SalaryServiceImpl;

/**
 * Servlet implementation class GetSalaryServlet
 */
@WebServlet("/GetSalaryServlet")
public class GetSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSalaryServlet() {
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
 		String sID = request.getParameter("updateSalary");			
 		ISalaryService service = new SalaryServiceImpl();
			ArrayList<Salary> list = service.getInfo(sID);
			request.setAttribute("salary", list);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UpdateSalary.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
