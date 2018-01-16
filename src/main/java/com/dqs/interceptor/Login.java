package com.dqs.interceptor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dqs.entity.User;
import com.dqs.service.UserService;
import com.dqs.service.impl.UserServiceImpl;
import com.dqs.util.CheckJWT;
import com.dqs.util.Status;

import io.jsonwebtoken.Claims;

public class Login implements HandlerInterceptor {
	@Autowired
	private UserService us;
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Status status = new Status();
		Map map = new HashMap();
		//�ж��Ƿ��¼
		//--��ȡtoken�е�ֵ
		String token =request.getHeader("Authorization");
		System.out.println(request.getHeader("Authorization"));
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
				request.setAttribute("user", map);
				//--�������ִ��������controller
				return true;
			}else{
				//�û������Ϸ�
				status.setValue("0");
				status.setMessage("�û�����������Ϣ�����������µ�¼");
				request.setAttribute("status", status);
				response.sendRedirect("/ErrorController/sendError.do");
			}
		}else{
			//����
			status.setValue("0");
			status.setMessage("��¼���ڡ������µ�¼");
			request.setAttribute("status", status);
			response.sendRedirect("/ErrorController/sendError.do");
		}
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("222");

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("333");
	}

}
