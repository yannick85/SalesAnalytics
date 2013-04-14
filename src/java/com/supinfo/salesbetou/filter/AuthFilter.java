/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Yannick
 */
public class AuthFilter implements Filter{
    	private FilterConfig config;
	
	@Override
	public void destroy() {
		this.config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,	FilterChain chain) throws IOException, ServletException {
		if(request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			if(httpServletRequest.getSession().getAttribute("user") == null) {
				//REDIRECT TO LOGIN
                                httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/");
                                return;
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}
}
