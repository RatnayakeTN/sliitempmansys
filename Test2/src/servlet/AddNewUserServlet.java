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

import model.RegisterModel;
import service.IRegisterUser;
import service.RegisterUserServiceImpl;

/**
 * Servlet implementation class AddNewUserServlet
 */
@WebServlet("/AddNewUserServlet")
public class AddNewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewUserServlet() {
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
		
		
		RegisterModel my = new RegisterModel();
		
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String email = request.getParameter("Email");
		String contactNo = request.getParameter("ContactNo");
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		String address = request.getParameter("Address");
		String position = request.getParameter("Position");
		String uLvel = request.getParameter("UserLevel");
		
		my.setFname(firstName);
		my.setLname(lastName);
		my.setEmail(email);
		my.setContactNo(contactNo);
		my.setUserName(userName);
		my.setPassword(password);
		my.setAddrerss(address);
		my.setPosition(position);
		my.setUserLevel(uLvel);
		
		IRegisterUser newuser = new RegisterUserServiceImpl();
		
		
		try {
			boolean isadded = newuser.registerUser(my);
			
			if(isadded == true) {
				System.out.println("success");
				
				PrintWriter writer = response.getWriter();
				
				writer.println("<script>");
				writer.println("alert('User Details added succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SalaryDetails.jsp");
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
