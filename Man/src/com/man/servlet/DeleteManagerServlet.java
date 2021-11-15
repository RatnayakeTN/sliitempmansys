package com.man.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.man.service.*;

/**
 * Servlet implementation class DeleteManagerServlet
 */
@WebServlet("/DeleteManagerServlet")
public class DeleteManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteManagerServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String managerID = request.getParameter("managerID");			
		
		IManagerService iManagerService = new ManagerService();
		iManagerService.removeManager(managerID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/ShowManagers.jsp");
		dispatcher.forward(request, response);
	}
	

}
