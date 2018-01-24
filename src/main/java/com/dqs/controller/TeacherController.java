package com.dqs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqs.service.TeacherService;
import com.dqs.service.UserService;
import com.dqs.util.Status;

@Controller
@RequestMapping("/home/TeacherController")
public class TeacherController {
	@Autowired
	private UserService us;
	@Autowired 
	private TeacherService ts;
	
	private Status status;
	TeacherController (){
		status = new Status();
	}
	@RequestMapping("/getBasicInfo.do")
	@ResponseBody
	public Object getBasicInfo(HttpServletRequest req){
		//从请求头中获取user信息
		Map user = (Map) req.getAttribute("user");
		// 获取登录者的id
		String id = (String) user.get("id");
		// 查询老师表的基本信息--查出班级名
		List list = ts.selectOne(id);
		return list.get(0);
	}
}
