package org.cc.ems.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns={"/*"})
public class EncodingFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
System.out.println("encoding filter...");		
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		chain.doFilter(req,resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
