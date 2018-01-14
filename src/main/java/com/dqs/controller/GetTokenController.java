package com.dqs.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqs.entity.User;
import com.dqs.service.UserService;
import com.dqs.util.CheckJWT;
import com.dqs.util.LoginCheckFilter;
import com.dqs.util.Status;

import io.jsonwebtoken.Claims;
@Controller
@RequestMapping("/Home/GetTokenController")
public class GetTokenController {
	@Autowired
	private UserService us;
	private Status status;
	GetTokenController (){
		status = new Status();
	}
	//--获取token--
	@RequestMapping("/token.do")
	@ResponseBody
	public Map token(HttpServletRequest req){
		Map map = new HashMap();
		//获取请求头中的token
		String token = req.getHeader("Authorization");
		//调用解析token的方法
		Claims claims = CheckJWT.parseJWT(token); 
		map.put("account", claims.get("account"));//用户名
		//查询出id--并放置
		User userinfo = us.selectOne((String) claims.get("account"));
		map.put("id", userinfo.getId());
		map.put("password", claims.get("password"));//密码
		map.put("role_id", claims.get("role_id"));//权限
		map.put("time", claims.getExpiration());//过期时间
		//判断token是否过期
		Date date=new Date();//获取当前系统时间
		int result = date.compareTo((Date) map.get("time"));//相等则返回0,前者大返回1,后者大返回-1;
		if(result == -1 || result == 0){
			//token 没有过期
			status.setValue("1");
			status.setMessage("token没过期");
		}else{
			//token 过期
			status.setValue("0");
			status.setMessage("token过期");
		}
		map.put("status", status);
		return map;
		
	}
}
