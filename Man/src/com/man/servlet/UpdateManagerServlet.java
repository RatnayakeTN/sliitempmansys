package com.man.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.man.model.Manager;
import com.man.service.*;


/**
 * Servlet implementation class UpdateManagerServlet
 */
@WebServlet("/UpdateManagerServlet")
public class UpdateManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateManagerServlet() {
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

		Manager manager = new Manager();
		String managerID = request.getParameter("managerID");	
		manager.setManagerID(managerID);
		manager.setName(request.getParameter("managerName"));
		manager.setAddress(request.getParameter("address"));
		manager.setDepartment(request.getParameter("department"));
		manager.setQualifications(request.getParameter("qualification"));
		manager.setGender(request.getParameter("gender"));
		
		IManagerService iManagerService = new ManagerService();
		iManagerService.updateManager(managerID, manager);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/ShowManagers.jsp");
		dispatcher.forward(request, response);	
	}

}
