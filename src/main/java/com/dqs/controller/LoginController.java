package com.dqs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqs.entity.User;
import com.dqs.service.UserService;
import com.dqs.util.JWTUtil;
import com.dqs.util.Status;

@Controller
@RequestMapping("/LoginController")
public class LoginController {
	@Autowired
	private UserService us;
	private Status status;
	LoginController (){
		status = new Status();
	}
	//--��¼--
	@RequestMapping("/userLogin.do")
	@ResponseBody
	public Map userLogin(@RequestBody User user){
		String account = user.getAccount();
		User userinfo = us.selectOne(account);//��ѯ������
		Map map = new HashMap();
		if(userinfo != null&&(userinfo.getPassword()).equals(user.getPassword())){
			//��¼�ɹ�
			//���û���Ϣ�γ�token
			String token = JWTUtil.createJWT(userinfo,1000*60*60*2);
			//����ֵ��ǰ̨
			status.setValue("1");
			status.setMessage("-=��¼�ɹ�=-");
			map.put("status", status);
			map.put("token", token);
			userinfo.setPassword("");
			map.put("userinfo", userinfo);
			
			return map;
		}else{
			status.setValue("0");
			status.setMessage("-=��¼ʧ��=-");
			map.put("status", status);
			return map;
		}
	}
}
