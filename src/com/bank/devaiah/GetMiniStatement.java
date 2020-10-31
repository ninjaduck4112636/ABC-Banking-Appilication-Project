package com.bank.devaiah;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetMiniStatement")
public class GetMiniStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int account_no = (int) session.getAttribute("account_no");
		Model model = new Model();
		model.setAccount_no(account_no);
		
		ResultSet res = model.getMiniStatement();
		
		if(res==null) {
			request.getRequestDispatcher("noMiniStatement.html").forward(request, response);
		}else {
			session.setAttribute("resultSet_of_Details_mini_statement", res);
			request.getRequestDispatcher("displayMiniStatement.jsp").forward(request, response);
		}
		
	}

}
