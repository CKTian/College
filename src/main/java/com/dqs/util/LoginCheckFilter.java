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
 * ����û��Ƿ��¼���м��
 * @author ���첩
 * 2018��1��4��
 */
//@WebFilter(filterName = "LoginCheckFilter",urlPatterns = "/*")
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
		
		//�ж��Ƿ��¼-��ȡtoken�е�ֵ
		System.out.println("��������������");
		//ckJwt.parseJWT(jwt);
		//�ж� token �Ƿ�ʱ 
		//
		//���һ����������������Ĺ������͵��������Ĺ�����
		
		chain.doFilter(req, resp);

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
