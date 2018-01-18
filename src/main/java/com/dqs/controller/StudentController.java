package com.dqs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqs.entity.Student;
import com.dqs.service.StudentService;
import com.dqs.service.UserService;
import com.dqs.util.Status;

@Controller
@RequestMapping("/home/StudentController")
public class StudentController {
	@Autowired
	private StudentService ss;
	private Status status;
	StudentController (){
		status = new Status();
	}
	/**
	 * 
	 * @Title: getBasicInfo  
	 * @Description: 查询学生的基本信息
	 * @author 王天博
	 * @param @param req
	 * @param @return      
	 * @return Map
	 */
	@RequestMapping("/getBasicInfo.do")
	@ResponseBody
	public Map getBasicInfo(HttpServletRequest req){
		Map map = new HashMap();
		Map user = (Map) req.getAttribute("user");
		// 获取登录者的id
		String id = (String) user.get("id");
		// 查询学生表的基本信息--查出班级名
		map = ss.selectOne(id);
		return map;
	}
}
