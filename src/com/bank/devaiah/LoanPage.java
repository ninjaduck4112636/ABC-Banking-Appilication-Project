package com.bank.devaiah;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoanPage")
public class LoanPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Model model = new Model();
			
			String loan_reason = request.getParameter("loan_reason");
			String iamount_for_loan = request.getParameter("amount_for_loan");
			int amount_for_loan = Integer.valueOf(iamount_for_loan);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loan_reason", loan_reason);
			session.setAttribute("amount_for_loan", amount_for_loan);
			
			int b = model.applyForLoan();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
