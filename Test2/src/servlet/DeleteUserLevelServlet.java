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

import service.IUserLevel;
import service.UserLevelServiceImpl;

/**
 * Servlet implementation class DeleteUserLevelServlet
 */
@WebServlet(name = "/DeleteUserLevelServlet", urlPatterns = { "/DeleteUserLevelServlet" })
public class DeleteUserLevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserLevelServlet() {
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
		
		String Did = request.getParameter("delete");
		
		IUserLevel userLevel = new UserLevelServiceImpl();
		
		boolean isDeleted = false;
		
		try {
			isDeleted = userLevel.deleteUserlevel(Did);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (isDeleted==true) {
			
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Deleted succesfully')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UserLevel.jsp");
			dispatcher.include(request, response);
			
			
		}
	}

}
