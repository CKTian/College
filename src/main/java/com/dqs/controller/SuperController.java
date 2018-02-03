package com.dqs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqs.dto.ShowAllTeacherInfoDto;
import com.dqs.entity.User;
import com.dqs.service.TeacherService;
import com.dqs.service.TeamService;
import com.dqs.service.UserService;
import com.dqs.util.Status;
import com.dqs.util.UserBasicInfo;

@Controller
@RequestMapping("/home/SuperController")
public class SuperController {
	@Autowired
	private UserService us;
	@Autowired
	private TeacherService ts;
	@Autowired
	private TeamService tms;
	
	private Status status;
	SuperController (){ // 只有在方法中才能new对象
		status = new Status();
	}
	/**
	 * 
	 * @Title: getBasicInfo  
	 * @Description: 查询基本信息
	 * @author 王天博
	 * @param @param req
	 * @param @return      
	 * @return Map
	 */
	@RequestMapping("/getBasicInfo.do")
	@ResponseBody
	public Map getBasicInfo(HttpServletRequest req){
		Map loginMap = new HashMap();
		//从请求头中 登录controller传过来的信息
		loginMap = (Map) req.getAttribute("loginMap");
		User user= (User) loginMap.get("userinfo");//用户登录信息
		// 展示登录者的所有信息
		List list = UserBasicInfo.parseSuperInfo(user);
		loginMap.put("basicInfoList", list);
		return loginMap;
	}
	
	/**
	 * 
	 * @Title: updatePwd  
	 * @Description: 修超级管理员改的登录密码
	 * @author 王天博
	 * @param @param req
	 * @param @param pwd
	 * @param @return      
	 * @return Status
	 */
	@RequestMapping("/updatePwd.do")
	@ResponseBody
	public Status updatePwd(HttpServletRequest req,@RequestBody Object pwd){
		//从请求头中获取user信息
		Map userMap = (Map) req.getAttribute("user");
		// 转换参数类型
		Map pwdMap = (Map) pwd;
		String pwssaord = (String) pwdMap.get("pwd");
		// 获取登录者的id
		String id = (String) userMap.get("id");
		//放置成对象
		User user = new User();
		user.setId(id);
		user.setPassword(pwssaord);
		// 根据id 修改密码
		us.updateOnePwd(user);
		status.setValue("1");
		status.setMessage("修改成功");
		return status;
	}
	/**
	 * 
	 * @Title: selectAllTeacherInfo  
	 * @Description:超级管理员查看所有的老师
	 * @author 王天博
	 * @param @return      
	 * @return List
	 */
	@RequestMapping("/selectAllTeacherInfo.do")
	@ResponseBody
	public List selectAllTeacherInfo() {
		List list =ts.selectAllTeacherInfo(); 
		System.out.println(list);
		return list;
	}
	/**
	 * 
	 * @Title: selectAllTeamInfo  
	 * @Description: 查询全部的班级
	 * @author 王天博
	 * @param @return      
	 * @return List
	 */
	@RequestMapping("/selectAllTeamInfo.do")
	@ResponseBody
	public List selectAllTeamInfo(){
		List list = tms.selectList();
		return list;
	}
	/**
	 * 
	 * @Title: updateOneTeacher  
	 * @Description: 修改一个老师的信息
	 * @author 王天博
	 * @param @return      
	 * @return Status
	 */
	@RequestMapping("/updateOneTeacher.do")
	@ResponseBody
	public Status updateOneTeacher(@RequestBody Object choosedInfo){
		// 转换参数类型
		Map choosed = (Map) choosedInfo;
		Map info = (Map) choosed.get("info");
		// 创建一个新对象
		ShowAllTeacherInfoDto toUpdateInfo = new ShowAllTeacherInfoDto();
		toUpdateInfo.setAccount((String)info.get("account"));
		toUpdateInfo.setGender((Integer)info.get("gender"));
		toUpdateInfo.setTeacherName((String)info.get("name"));
		toUpdateInfo.setTeamId((String)info.get("teamName"));
		toUpdateInfo.setUserId((String)info.get("userId"));
		// 修改数据库中的信息
		ts.updateOneTeacherInfo(toUpdateInfo);
		//修改成功
		status.setValue("1");
		status.setMessage("修改成功哦~~");
		return status;
	}
	
}