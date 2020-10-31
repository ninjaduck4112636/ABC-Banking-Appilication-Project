package com.bank.devaiah;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customer_id = request.getParameter("customer_id");
		String password = request.getParameter("password");
		
		try {
			
			Model m = new Model();
			
			m.setCustomer_id(customer_id);
			m.setPassword(password);
			
			Boolean res = m.login();
			if(res) {
				HttpSession session = request.getSession();
				session.setAttribute("account_no", m.getAccount_no());
				session.setAttribute("user_name", m.getName());
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("failure.html").forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
