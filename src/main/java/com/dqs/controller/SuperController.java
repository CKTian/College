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
import com.dqs.entity.Course;
import com.dqs.entity.User;
import com.dqs.service.CourseService;
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
	@Autowired
	private CourseService cs;
	
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
		System.out.println("测试"+list);
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
		toUpdateInfo.setGender((Integer) info.get("gender"));
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
	/**
	 * 
	 * @Title: insertTeacher  
	 * @Description: 增加一位老师
	 * @author 王天博
	 * @param @param choosedInfo
	 * @param @return      
	 * @return Status
	 */
	@RequestMapping("/insertTeacher.do")
	@ResponseBody
	public Status insertTeacher(@RequestBody Object newInfo){
		// 转换参数类型
		Map news = (Map) newInfo;
		Map info = (Map) news.get("info");
		System.out.println(info);
		// 创建一个新对象
		ShowAllTeacherInfoDto toUpdateInfo = new ShowAllTeacherInfoDto();
		toUpdateInfo.setAccount((String)info.get("account"));
		String sex = (String)info.get("gender");
		Integer gender = Integer.valueOf(sex);
		toUpdateInfo.setGender(gender);
		toUpdateInfo.setTeacherName((String)info.get("name"));
		toUpdateInfo.setTeamId((String)info.get("teamName"));
		toUpdateInfo.setUserId((String)info.get("userId"));
		// 将新增的老师的信息插入到数据库中
		int flag = ts.inserOneTeacher(toUpdateInfo);
		if(flag !=0 ){
			// 插入失败
			status.setValue("0");
			status.setMessage("用户名重复！请重新填写");
		}else {
			//插入成功
			status.setValue("1");
			status.setMessage("添加成功哦~~");
		}
		return status;
	}
	@RequestMapping("/deleteselectAllTeacherInfoTeacher.do")
	@ResponseBody
	public Status deleteTeacher(@RequestBody Object info){
		// 转换参数类型
		Map infoMap = (Map) info;
		String userId = (String) infoMap.get("userId");
		ts.deleteOneTeacher(userId);
		status.setValue("1");
		status.setMessage("删除成功哦~~");
		return status;
	}
	/**
	 * 
	 * @Title: updateOneCourse  
	 * @Description: 修改一条课程信息
	 * @author 王天博
	 * @param @param info
	 * @param @return      
	 * @return Status
	 */
	@RequestMapping("/updateOneCourse.do")
	@ResponseBody
	public Status updateOneCourse(@RequestBody Object info) {
		// 转换参数类型
		Map infoMap = (Map) info;
		Map forUpdateInfo = (Map) infoMap.get("info");
//		// 获取选中老师的userid
//		String userId = (String)forUpdateInfo.get("userId");
//		// 通过userid 查询teacherid
//		String teacherId = ts.selectTeacherId(userId);
		// 创建一个新的对象
		Course course = new Course();
		course.setId((String)forUpdateInfo.get("courseId"));
		course.setName((String)forUpdateInfo.get("courseName"));
		course.setTname((String)forUpdateInfo.get("teacherName"));
		course.setTeacher_id((String)forUpdateInfo.get("teacherId"));
		course.setTime((String)forUpdateInfo.get("time"));
		// 去数据库修改
		int result = cs.updateOneCourse(course);
		//判断状态值
		if (result == 0){ 
			status.setValue("0");
			status.setMessage("改上课时间已经有课哦~请重新选课");
		} else if (result == 1) {
			status.setValue("1");
			status.setMessage("修改成功！");
		}
		return status;
	}
	/**
	 * 
	 * @Title: insertOneCourse  
	 * @Description: 增加一门课程信息
	 * @author 王天博
	 * @param @param info
	 * @param @return      
	 * @return Status
	 */
	@RequestMapping("/insertOneCourse.do")
	@ResponseBody
	public Status insertOneCourse(@RequestBody Object info) {
		// 转换参数类型
		Map infoMap = (Map) info;
		Map forInsertInfo = (Map) infoMap.get("info");
		// 创建一个新的对象
		Course course = new Course();
		course.setId((String)forInsertInfo.get("courseId"));
		course.setName((String)forInsertInfo.get("courseName"));
		course.setTname((String)forInsertInfo.get("teacherName"));
		course.setTeacher_id((String)forInsertInfo.get("teacherId"));
		course.setTime((String)forInsertInfo.get("time"));
		// 去数据库修改
		cs.insertOneCourse(course);
		return status;
	}
}
