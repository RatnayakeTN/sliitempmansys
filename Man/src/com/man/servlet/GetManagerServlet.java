package com.man.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.man.service.*;
import com.man.model.*;

/**
 * Servlet implementation class GetManagerServlet
 */
@WebServlet("/GetManagerServlet")
public class GetManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetManagerServlet() {
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
		Manager manager = iManagerService.getManagerById(managerID);

		request.setAttribute("manager", manager);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/GetManager.jsp");
		dispatcher.forward(request, response);		
	}

}
