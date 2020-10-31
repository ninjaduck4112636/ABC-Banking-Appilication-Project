package com.bank.devaiah;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckBalance")
public class CheckBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		Integer account_no = (Integer) session.getAttribute("account_no");
		
		Model m = new Model();
		m.setAccount_no(account_no);
		
		Boolean b = m.showBalance();
		
		if(b) {
			session.setAttribute("balance", m.getBalance());
			request.getRequestDispatcher("balanceView.jsp").forward(request, response);
		}
		else {
			out.print("<h1 style=\"color: red; text-align: center; font-family:Courier New; font-size: 200%;\"><b>UNABLE TO FETCH BALANCE AT A MOMENT</b></h1>");
			out.print("<br>");
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
		
	}

}
