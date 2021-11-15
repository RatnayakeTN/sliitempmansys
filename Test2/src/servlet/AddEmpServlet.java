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


import model.Promotion;
import service.EmployeeService;
import service.PromotionService;
import service.EmployeeServiceImpl;
import service.PromotionServiceImpl;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet("/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpServlet() {
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
		System.out.println("Served to promotion");
		int promotedEmp = Integer.parseInt(request.getParameter("promotedEmp"));
		String newPosition= request.getParameter("newPosition");
		String date = request.getParameter("date");
		int createdBy= Integer.parseInt(request.getParameter("createdBy"));
		String remark= request.getParameter("remark");

		/*
		 * Promotion promo= new Promotion(); promo.setPromotedEmp(promotedEmp);
		 * promo.setCreatedBy(createdBy); promo.setDate(date);
		 * promo.setPosition(newPosition); promo.setRemark(remark);
		 */
		
		
		PromotionService promoService= new PromotionServiceImpl();
		try {
			boolean isAdded=false; //promoService.addPromo(promo);
			
			if(isAdded==true) {
				System.out.println("Promotion Added");
				PrintWriter writer= response.getWriter();
				writer.println("<script>");
				writer.println("alert('Added succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.include(request, response);
						
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
