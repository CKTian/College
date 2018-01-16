package com.dqs.util;

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
/**
 * 
 * 服务器请求跨域的中间件
 * @author 王天博
 * 2018年1月16日
 */
//@WebFilter(filterName = "CorsFilter",urlPatterns = "/*")
public class CorsFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse  httpServletResponse = (HttpServletResponse) res;
		HttpServletRequest  httpServletRequest = (HttpServletRequest) req;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "accept,content-type,Authorization"); 
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST"); 
        if((httpServletRequest.getMethod()).equals("OPTIONS")){
        	httpServletResponse.setStatus(200);
        	httpServletResponse.getWriter();
        }else{
        	chain.doFilter(req, httpServletResponse); 
        }
        

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
