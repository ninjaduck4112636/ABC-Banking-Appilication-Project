package com.bank.devaiah;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String customer_id = request.getParameter("customer_id");
		String iaccount_no = request.getParameter("account_no");
		Integer account_no = Integer.valueOf(iaccount_no);
		String password = request.getParameter("password");
		String ibalance = request.getParameter("balance");
		Integer balance = Integer.valueOf(ibalance);
		String e_mail = request.getParameter("e_mail");
		
		Model m = new Model();
		
		m.setName(name);
		m.setCustomer_id(customer_id);
		m.setAccount_no(account_no);
		m.setPassword(password);
		m.setBalance(balance);
		m.setE_mail(e_mail);
		
		Boolean identifier = m.register();
		
		if(identifier==true)
			request.getRequestDispatcher("sucess.html").forward(request, response);
		else
			request.getRequestDispatcher("failure.html").forward(request, response);
	}

}
