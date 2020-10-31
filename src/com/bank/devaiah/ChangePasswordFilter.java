package com.bank.devaiah;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/ChangePassword")
public class ChangePasswordFilter implements Filter {

    public ChangePasswordFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_password");
		
		if(new_password.equals(confirm_password))
			chain.doFilter(request, response);
		else {
			PrintWriter out = response.getWriter();
			out.print("<h1 style=\"color: red; text-align: center; font-family:Courier New; font-size: 200%;\"><b>THE TWO PASSWORD DID NOT MATCH. PLEASE TRY AGAIN</b></h1>");
			out.print("<br>");
			request.getRequestDispatcher("ChangePassword.html").include(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
