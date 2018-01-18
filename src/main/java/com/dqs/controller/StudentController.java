package com.dqs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqs.entity.Student;
import com.dqs.entity.User;
import com.dqs.service.StudentService;
import com.dqs.service.UserService;
import com.dqs.util.Status;

@Controller
@RequestMapping("/home/StudentController")
public class StudentController {
	@Autowired
	private StudentService ss;
	@Autowired
	private UserService us;
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
	/**
	 * 
	 * @Title: updatePwd  
	 * @Description: 修改密码
	 * @author 王天博
	 * @param @param req
	 * @param @return      
	 * @return Map
	 */
	@RequestMapping("/updatePwd.do")
	@ResponseBody
	public Status updatePwd(HttpServletRequest req,String pwd){
		Map userMap = (Map) req.getAttribute("user");
		System.out.println(pwd);
		// 获取登录者的id
		String id = (String) userMap.get("id");
		//放置成对象
		User user = new User();
		user.setId(id);
		user.setPassword(pwd);
		// 根据id 修改密码
		System.out.println(user);
		us.updateOnePwd(user);
		status.setValue("1");
		status.setMessage("修改成功");
		return status;
	}
}
