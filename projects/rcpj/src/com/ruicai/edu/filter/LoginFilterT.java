package com.ruicai.edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilterT implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest rs, ServletResponse rsp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)rs;
		HttpServletResponse response = (HttpServletResponse)rsp;
		HttpSession session = request.getSession();
		if(session.getAttribute("student")!= null || session.getAttribute("teacher") != null){
			System.out.println("释放");
			chain.doFilter(rs, rsp);
		}else{
			response.sendRedirect("login.jsp");
		}
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
