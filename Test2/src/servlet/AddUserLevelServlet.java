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

import model.UserLevelModel;
import service.IUserLevel;
import service.UserLevelServiceImpl;

/**
 * Servlet implementation class AddUserLevelServlet
 */
@WebServlet("/AddUserLevelServlet")
public class AddUserLevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserLevelServlet() {
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
		
		UserLevelModel my = new UserLevelModel();
		
		String ulevels = request.getParameter("Ulevel");
		String uNo = request.getParameter("No");
		
		my.setUlevel(ulevels);
		my.setNo(uNo);
		
		IUserLevel userLevel = new UserLevelServiceImpl();
		
		
		try {
			boolean isadded = userLevel.addNewUserLevel(my);
			
			if(isadded == true) {
				System.out.println("success");
				
				PrintWriter writer = response.getWriter();
				
				writer.println("<script>");
				writer.println("alert('Destination added succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UserLevel.jsp");
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
