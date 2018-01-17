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
import com.dqs.util.Status;

import io.jsonwebtoken.Claims;
@Controller
@RequestMapping("/home/GetTokenController")
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
		//获取请求中的用户信息
		Map userMap = (Map) req.getAttribute("user");
		userMap.put("password", "");//将密码置空
		//设置状态
		status.setValue("1");
		status.setMessage("成功");
		map.put("status", status);//状态值
		map.put("userMap", userMap);
		//返回前台
		return map;
	}
}
