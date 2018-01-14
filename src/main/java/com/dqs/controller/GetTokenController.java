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
	//--��ȡtoken--
	@RequestMapping("/token.do")
	@ResponseBody
	public Map token(HttpServletRequest req){
		Map map = new HashMap();
		//��ȡ����ͷ�е�token
		String token = req.getHeader("Authorization");
		//���ý���token�ķ���
		Claims claims = CheckJWT.parseJWT(token); 
		map.put("account", claims.get("account"));//�û���
		//��ѯ��id--������
		User userinfo = us.selectOne((String) claims.get("account"));
		map.put("id", userinfo.getId());
		map.put("password", claims.get("password"));//����
		map.put("role_id", claims.get("role_id"));//Ȩ��
		map.put("time", claims.getExpiration());//����ʱ��
		//�ж�token�Ƿ����
		Date date=new Date();//��ȡ��ǰϵͳʱ��
		int result = date.compareTo((Date) map.get("time"));//����򷵻�0,ǰ�ߴ󷵻�1,���ߴ󷵻�-1;
		if(result == -1 || result == 0){
			//token û�й���
			status.setValue("1");
			status.setMessage("tokenû����");
		}else{
			//token ����
			status.setValue("0");
			status.setMessage("token����");
		}
		map.put("status", status);
		return map;
		
	}
}
