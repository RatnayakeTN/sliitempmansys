package com.man.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PayrollCalServlet
 */
@WebServlet("/PayrollCalServlet")
public class PayrollCalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayrollCalServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String empid=request.getParameter("empid");
		String empname=request.getParameter("empname");
		int hours=Integer.parseInt(request.getParameter("hours"));
		int rate=Integer.parseInt(request.getParameter("rate"));
		double basic=Double.parseDouble(request.getParameter("basic"));
		double taxes=Double.parseDouble(request.getParameter("taxes"));
		double bonus=Double.parseDouble(request.getParameter("bonus"));
		
		
		double grossPay= rate * hours;
		double netPay = (grossPay) - taxes;
		double salary = basic + netPay + bonus;
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Pay.jsp");
		request.setAttribute("empid", empid);
		request.setAttribute("empname", empname);
		request.setAttribute("hours", hours);
		request.setAttribute("rate", rate);
		request.setAttribute("basic", basic);
		request.setAttribute("taxes", taxes);
		request.setAttribute("bonus", bonus);		
		request.setAttribute("gross", grossPay);
		request.setAttribute("netPay", netPay);
		request.setAttribute("salary", salary);
		
		dispatcher.forward(request, response);		
	}

}
