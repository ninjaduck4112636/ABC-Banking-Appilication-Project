package com.bank.devaiah;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String new_password = request.getParameter("new_password");
		
		HttpSession session = request.getSession();
		Integer account_no = (Integer) session.getAttribute("account_no");
		
		try {
			
			Model m = new Model();
			m.setAccount_no(account_no);
			m.setPassword(new_password);
			
			Boolean b = m.changePassword();
			
			if(b)
				request.getRequestDispatcher("sucess.html").forward(request, response);
			else
				request.getRequestDispatcher("failure.html").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
