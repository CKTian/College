package com.dqs.util;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;

import com.dqs.entity.User;
import com.dqs.service.UserService;
import com.dqs.service.impl.UserServiceImpl;

import io.jsonwebtoken.Claims;
/**
 * 
 * 检查用户是否登录的中间件
 * @author 王天博
 * 2018年1月4日
 */
//@WebFilter(filterName = "LoginCheckFilter",urlPatterns = "/home/*")
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
		UserServiceImpl us = new UserServiceImpl();
		Status status = new Status();
		Map map = new HashMap();
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpResp = (HttpServletResponse) resp;
		//判断是否登录
		//--获取token中的值
		String token =httpReq.getHeader("Authorization");
		System.out.println(httpReq.getHeader("Authorization"));
		if(token != null||token != ""){
			//解析token
			Claims claims = CheckJWT.parseJWT(token);
			//获取token中的用户信息
			//--查询出id--并放置
			map.put("account", claims.get("account"));//用户名
			User userinfo = us.selectOne((String) map.get("account"));
			map.put("id", userinfo.getId());
			map.put("password", claims.get("password"));//密码
			map.put("role_id", claims.get("role_id"));//权限
			map.put("time", claims.getExpiration());//过期时间
		}
		//判断token是否过期
		Date date=new Date();//获取当前系统时间
		int result = date.compareTo((Date) map.get("time"));//相等则返回0,前者大返回1,后者大返回-1;
		if(result == -1 || result == 0){
			//token 合法没过期
			//判断用户名、密码是否合法
			User userinfo = us.selectOne((String) map.get("account"));//根据用户名查询数据库信息
			if((userinfo.getPassword()).equals(map.get("password"))){
				//用户名合法
				//--讲解析好的用户信息放值请求中
				httpReq.setAttribute("user", map);
				//--过滤完成执行正常的controller
				chain.doFilter(req, resp);
			}else{
				//用户名不合法
				status.setValue("0");
				status.setMessage("用户名、密码信息不符。请重新登录");
				httpReq.setAttribute("status", status);
				httpResp.sendRedirect("/ErrorController/sendError.do");
			}
		}else{
			//过期
			status.setValue("0");
			status.setMessage("登录过期。请重新登录");
			httpReq.setAttribute("status", status);
			httpResp.sendRedirect("/ErrorController/sendError.do");
		}
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
