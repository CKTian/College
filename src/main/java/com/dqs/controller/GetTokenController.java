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
	//--��ȡtoken--
	@RequestMapping("/token.do")
	@ResponseBody
	public Map token(HttpServletRequest req){
		Map map = new HashMap();
		//��ȡ�����е��û���Ϣ
		Map userMap = (Map) req.getAttribute("user");
		userMap.put("password", "");//�������ÿ�
		//����״̬
		status.setValue("1");
		status.setMessage("�ɹ�");
		map.put("status", status);//״ֵ̬
		map.put("userMap", userMap);
		//����ǰ̨
		return map;
	}
}
