package com.dqs.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/**
 * 
 * 检查用户是否登录的中间件
 * @author 王天博
 * 2018年1月4日
 */
//@WebFilter(filterName = "LoginCheckFilter",urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
	
	/* (non Javadoc) 
	 * @Title: destroy
	 * @Description: 容器在销毁当前过滤器的时候自动调用
	 * @see javax.servlet.Filter#destroy() 
	 * @athor 王天博
	 */ 
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non Javadoc) 
	 * @Title: doFilter
	 * @Description: 过滤器的主要代码写在这个地方--判断是否登录
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws ServletException 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain) 
	 * @athor 王天博
	 */ 
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		//判断是否登录-获取token中的值
		System.out.println("！！！！！！！");
		//ckJwt.parseJWT(jwt);
		//判断 token 是否超时 
		//
		//最后一步：如果还有其他的过滤器就调用其它的过滤器
		
		chain.doFilter(req, resp);

	}
	
	/* (non Javadoc) 
	 * @Title: init
	 * @Description: 容器在创建当前过滤器的时候自动调用;
	 * @param arg0
	 * @throws ServletException 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig) 
	 * @athor 王天博
	 */ 
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
