package com.dqs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqs.entity.User;
import com.dqs.service.UserService;
import com.dqs.util.SecurityUtil;
import com.dqs.util.Status;

@Controller
@RequestMapping("/UserController")
public class UserController {
	@Autowired
	private UserService us;
	@RequestMapping("/userLogin.do")
	@ResponseBody
	public Status userLogin(@RequestBody User user){
		Status status = new Status();
		String account = user.getAccount();
		User userinfo = us.selectOne(account);//��ѯ������
		if(userinfo != null&&(userinfo.getPassword()).equals(user.getPassword())){
			//��¼�ɹ�
			//���û���Ϣ�γ�token
			Map map=new HashMap();
			map.put("username", userinfo.getAccount());
			map.put("password", userinfo.getPassword());
			map.put("role_id", userinfo.getRole_id());
			System.out.println(userinfo.toString());
			String token = SecurityUtil.authentication(map);
			//����ֵ��ǰ̨
			status.setValue("1");
			status.setMessage("-=��¼�ɹ�=-");
			status.setToken(token);
			return status;
		}else{
			status.setValue("0");
			status.setMessage("-=��¼ʧ��=-");
			return status;
		}
	}
}
