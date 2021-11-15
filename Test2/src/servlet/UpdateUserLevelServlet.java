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
 * Servlet implementation class UpdateUserLevelServlet
 */
@WebServlet("/UpdateUserLevelServlet")
public class UpdateUserLevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserLevelServlet() {
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
		
		String ULevelName = request.getParameter("NewUlevel");
		String ULevelNo = request.getParameter("NewNo");
		
		UserLevelModel newUL = new UserLevelModel();
		
		newUL.setUlevel(ULevelName);
		newUL.setNo(ULevelNo);
		
		IUserLevel userLevel = new UserLevelServiceImpl();
		
		try {
			boolean isAdded= userLevel.updateUserlevel(newUL);
			
			if(isAdded==true) {
				System.out.println("Record Updated");
				PrintWriter writer= response.getWriter();
				writer.println("<script>");
				writer.println("alert('Updated succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/UserLevel.jsp");
				response.setContentType("text/html;charset=UTF-8");
				dispatcher.include(request, response);
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
