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

import model.PositionModel;
import service.IPosition;
import service.PositionServiceImpl;

/**
 * Servlet implementation class EditUserPositionServlet
 */
@WebServlet("/EditUserPositionServlet")
public class EditUserPositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserPositionServlet() {
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
		
try {
			
			String Did = request.getParameter("edit");	
			
			IPosition position = new PositionServiceImpl();
			
				ArrayList<PositionModel> newPosotion = position.getEditedPosition(Did);
				request.setAttribute("ulx", newPosotion);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EditPosition.jsp");
				dispatcher.forward(request, response);
				
				System.out.println("Edit complete");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
