package com.bank.devaiah;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String iamount = request.getParameter("amount");
		int amount = Integer.valueOf(iamount);
		
		String ireciverAccountNO = request.getParameter("reciverAccountNO");
		int reciverAccountNO = Integer.valueOf(ireciverAccountNO);
		
		HttpSession session = request.getSession();
		int account_no = (int) session.getAttribute("account_no");
		
		try {
			
			Model model = new Model();
			model.setAccount_no(account_no);
			model.setBalance(amount);
			model.setReciverAccountNO(reciverAccountNO);
			boolean b = model.transferAmount();
			if(b) {
				request.getRequestDispatcher("sucess.html").forward(request, response);
			}
			else {
				request.getRequestDispatcher("failure.html").forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
