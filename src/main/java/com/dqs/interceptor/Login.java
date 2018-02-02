package com.dqs.interceptor;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dqs.entity.User;
import com.dqs.service.UserService;
import com.dqs.service.impl.UserServiceImpl;
import com.dqs.util.CheckJWT;
import com.dqs.util.Status;

import io.jsonwebtoken.Claims;
import net.sf.json.JSONObject;

public class Login implements HandlerInterceptor {
	@Autowired
	private UserService us;
	@ResponseBody
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Map loginMap = (Map) request.getAttribute("loginMap");
		String token = "";
		// 
		try {
			token = (String) loginMap.get("token");//获取请求中的token--因为请求转发
		}catch(Exception e){
			token =request.getHeader("Authorization");//获取请求头中的token
		}
		
		Status status = new Status();
		Map map = new HashMap();
		PrintWriter out = null ;  
		JSONObject res = new JSONObject();  
		//判断是否登录
		//--获取token中的值
		if(token != null){
			//解析token
			Claims claims = CheckJWT.parseJWT(token);
			if(claims == null){
				status.setValue("0");
				status.setMessage("登陆过期");
			    res.put("status",status);  
			    out = response.getWriter();  
			    out.append(res.toString());  
				return false;
			}else{
				//获取token中的用户信息
				//--查询出id--并放置
				map.put("account", claims.get("account"));//用户名
				User userinfo = us.selectOne((String) map.get("account"));
				map.put("id", userinfo.getId());
				map.put("password", claims.get("password"));//密码
				map.put("role_id", claims.get("role_id"));//权限
				map.put("gender", claims.get("gender"));//性别
				map.put("time", claims.getExpiration());//过期时间
				//判断token是否过期
				Date date=new Date();//获取当前系统时间
				int result = date.compareTo((Date) map.get("time"));//相等则返回0,前者大返回1,后者大返回-1;
				if(result == -1 || result == 0){
					//token 合法没过期
					//判断用户名、密码是否合法
					if((userinfo.getPassword()).equals(map.get("password"))){
						//用户名合法
						//--讲解析好的用户信息放值请求中
						request.setAttribute("user", map);
						//--过滤完成执行正常的controller
						return true;
					}else{
						//用户名不合法
						status.setValue("0");
						status.setMessage("用户名、密码信息不符。请重新登录");
					    res.put("status",status);  
					    out = response.getWriter();  
					    out.append(res.toString());  
						return false;
					}
				}else{
					//过期
					status.setValue("0");
					status.setMessage("登录过期。请重新登录");
				    res.put("status",status);  
				    out = response.getWriter();  
				    out.append(res.toString());  
					return false;
					//response.sendRedirect("/ErrorController/sendError.do");
				}
			}
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
