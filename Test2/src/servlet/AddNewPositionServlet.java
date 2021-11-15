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

import model.PositionModel;
import service.IPosition;
import service.PositionServiceImpl;

/**
 * Servlet implementation class AddNewPosition
 */
@WebServlet("/AddNewPositionServlet")
public class AddNewPositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewPositionServlet() {
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
		
		PositionModel my = new PositionModel();
		
		String pname = request.getParameter("PositionName");
		String basicsal = request.getParameter("BasicSalary");
		
		my.setPositionName(pname);
		my.setBasicSalary(basicsal);
		
		IPosition position = new PositionServiceImpl();
		
		try {
			boolean isadded = position.addNewPosition(my);
			
			if(isadded == true) {
				System.out.println("success");
				
				PrintWriter writer = response.getWriter();
				
				writer.println("<script>");
				writer.println("alert('New position added succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Positions.jsp");
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
