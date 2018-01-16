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
 * ����û��Ƿ��¼���м��
 * @author ���첩
 * 2018��1��4��
 */
//@WebFilter(filterName = "LoginCheckFilter",urlPatterns = "/home/*")
public class LoginCheckFilter implements Filter {
	/* (non Javadoc) 
	 * @Title: destroy
	 * @Description: ���������ٵ�ǰ��������ʱ���Զ�����
	 * @see javax.servlet.Filter#destroy() 
	 * @athor ���첩
	 */ 
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non Javadoc) 
	 * @Title: doFilter
	 * @Description: ����������Ҫ����д������ط�--�ж��Ƿ��¼
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws ServletException 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain) 
	 * @athor ���첩
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		UserServiceImpl us = new UserServiceImpl();
		Status status = new Status();
		Map map = new HashMap();
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpResp = (HttpServletResponse) resp;
		//�ж��Ƿ��¼
		//--��ȡtoken�е�ֵ
		String token =httpReq.getHeader("Authorization");
		System.out.println(httpReq.getHeader("Authorization"));
		if(token != null||token != ""){
			//����token
			Claims claims = CheckJWT.parseJWT(token);
			//��ȡtoken�е��û���Ϣ
			//--��ѯ��id--������
			map.put("account", claims.get("account"));//�û���
			User userinfo = us.selectOne((String) map.get("account"));
			map.put("id", userinfo.getId());
			map.put("password", claims.get("password"));//����
			map.put("role_id", claims.get("role_id"));//Ȩ��
			map.put("time", claims.getExpiration());//����ʱ��
		}
		//�ж�token�Ƿ����
		Date date=new Date();//��ȡ��ǰϵͳʱ��
		int result = date.compareTo((Date) map.get("time"));//����򷵻�0,ǰ�ߴ󷵻�1,���ߴ󷵻�-1;
		if(result == -1 || result == 0){
			//token �Ϸ�û����
			//�ж��û����������Ƿ�Ϸ�
			User userinfo = us.selectOne((String) map.get("account"));//�����û�����ѯ���ݿ���Ϣ
			if((userinfo.getPassword()).equals(map.get("password"))){
				//�û����Ϸ�
				//--�������õ��û���Ϣ��ֵ������
				httpReq.setAttribute("user", map);
				//--�������ִ��������controller
				chain.doFilter(req, resp);
			}else{
				//�û������Ϸ�
				status.setValue("0");
				status.setMessage("�û�����������Ϣ�����������µ�¼");
				httpReq.setAttribute("status", status);
				httpResp.sendRedirect("/ErrorController/sendError.do");
			}
		}else{
			//����
			status.setValue("0");
			status.setMessage("��¼���ڡ������µ�¼");
			httpReq.setAttribute("status", status);
			httpResp.sendRedirect("/ErrorController/sendError.do");
		}
	}
	
	/* (non Javadoc) 
	 * @Title: init
	 * @Description: �����ڴ�����ǰ��������ʱ���Զ�����;
	 * @param arg0
	 * @throws ServletException 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig) 
	 * @athor ���첩
	 */ 
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
