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
import service.PromotionService;
import service.PromotionServiceImpl;

/**
 * Servlet implementation class AddPromotion
 */
@WebServlet("/AddPromotion")
public class AddPromotion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPromotion() {
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
		int applicant = Integer.parseInt(request.getParameter("applicant"));
		String designation= request.getParameter("designation");
		String stat_date = request.getParameter("date");
		int approved_by= Integer.parseInt(request.getParameter("approved_by"));
		String description= request.getParameter("description");

		Promotion promo= new Promotion();
		promo.setApplicant(applicant);
		promo.setApproved_by(approved_by);
		promo.setStat_date(stat_date);
		promo.setDesignation(designation);
		promo.setDescription(description);
		
		
		PromotionService promoService= new PromotionServiceImpl();
		try {
			boolean isAdded= promoService.addPromo(promo);
			
			if(isAdded==true) {
				System.out.println("Promotion Added");
				PrintWriter writer= response.getWriter();
				writer.println("<script>");
				writer.println("alert('Added succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/FinalPromotion.jsp");
				dispatcher.include(request, response);
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
