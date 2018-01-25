package com.dqs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	//--登录--
	@RequestMapping("/userLogin.do")
	public String userLogin(HttpServletRequest req, @RequestBody User user){
		String account = user.getAccount();
		User userinfo = us.selectOne(account);//查询出来的
		System.out.println(userinfo);
		Map map = new HashMap();
		if(userinfo != null&&(userinfo.getPassword()).equals(user.getPassword())){
			// 登录成功-->进行如下：
			// 获取登陆者的权限值
			Integer roleId = userinfo.getRole_id();
			// 根据权限设置路由
			String router = "";
			if (roleId == 0){// 超级管理员
				router = "";
			} else if (roleId == 1){// 老师
				router = "forward:/home/TeacherController/getBasicInfo.do";
			} else if (roleId == 2){// 学生
				router = "forward:/home/StudentController/getBasicInfo.do";
			}
			// 将用户信息形成token
			String token = JWTUtil.createJWT(userinfo,1000*60*60*2);
			status.setValue("1");
			status.setMessage("-=登录成功=-");
			map.put("status", status);
			map.put("token", token);
			userinfo.setPassword("");
			map.put("userinfo", userinfo);
			//将以上信息放到map中 放到请求中，重定向到对应controller中
			req.setAttribute("loginMap", map);
			return router;
		}else{
			status.setValue("0");
			status.setMessage("-=登录失败=-");
			req.setAttribute("status", status);
			return "forward:/ErrorController/sendError.do";  
		}
	}
}
