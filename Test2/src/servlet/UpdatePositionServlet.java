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
 * Servlet implementation class UpdatePositionServlet
 */
@WebServlet("/UpdatePositionServlet")
public class UpdatePositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePositionServlet() {
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
		
		String pId = request.getParameter("pid");
		String pName = request.getParameter("NewPositionName");
		String psal = request.getParameter("NewSalary");
		
		PositionModel newP = new PositionModel();
		
		newP.setPid(pId);
		newP.setPositionName(pName);
		newP.setBasicSalary(psal);
		
		IPosition positions = new PositionServiceImpl();
		
		try {
			boolean isAdded= positions.updatePosition(newP);
			
			if(isAdded==true) {
				System.out.println("Record Updated");
				PrintWriter writer= response.getWriter();
				writer.println("<script>");
				writer.println("alert('Updated succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Positions.jsp");
				dispatcher.include(request, response);
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
