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

import service.IRegisterUser;
import service.RegisterUserServiceImpl;

/**
 * Servlet implementation class ValidateUserLoginServlet
 */
@WebServlet("/ValidateUserLoginServlet")
public class ValidateUserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateUserLoginServlet() {
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
		
		String username = request.getParameter("InputUserName");
		String password = request.getParameter("InputPassword");
		
		IRegisterUser userService = new RegisterUserServiceImpl();
		
		boolean isValid = false;
		
		try {
			isValid = userService.validateUser(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isValid==true) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FrontPage.jsp");
			dispatcher.include(request, response);
		}
		else if(isValid==false) {
			
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Username or Password is incorrect')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.include(request, response);
			
		}
	}

}
