package com.dqs.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqs.entity.User;
import com.dqs.service.StudentService;
import com.dqs.service.TeacherService;
import com.dqs.service.UserService;
import com.dqs.util.CheckJWT;
import com.dqs.util.Status;
import com.dqs.util.UserBasicInfo;

import io.jsonwebtoken.Claims;
@Controller
@RequestMapping("/home/GetTokenController")
public class GetTokenController {
	@Autowired
	private UserService us;
	@Autowired
	private StudentService ss;
	@Autowired
	private TeacherService ts;
	
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
		Map user = (Map) req.getAttribute("user");
		String account = (String) user.get("account");
		User userInfo = us.selectOne(account);
		Map loginInfo = new HashMap();
		loginInfo.put("userinfo", userInfo);
		if((Integer)user.get("role_id") == 0){
			
		} else if ((Integer)user.get("role_id") == 1){
			// 查询老师基本信息
			List listInfo = ts.selectOne((String)user.get("id"));
			List list = UserBasicInfo.parseTeacherInfo(loginInfo, listInfo);
			map.put("basicInfoList", list);
		} else if ((Integer)user.get("role_id") == 2){
			// 查询学生表的基本信息--查出班级名
			Map basicInfo = ss.selectOne((String)user.get("id"));
			List list = UserBasicInfo.parseStuInfo(loginInfo, basicInfo);
			map.put("basicInfoList", list);
		}
		//设置状态
		status.setValue("1");
		status.setMessage("成功");
		map.put("status", status);//状态值
		map.put("loginInfo", loginInfo);
		//返回前台
		return map;
	}
}
