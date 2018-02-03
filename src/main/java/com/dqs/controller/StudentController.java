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

import com.dqs.entity.Choosed;
import com.dqs.entity.Course;
import com.dqs.entity.Student;
import com.dqs.entity.User;
import com.dqs.service.ChoosedService;
import com.dqs.service.CourseService;
import com.dqs.service.StudentService;
import com.dqs.service.TeacherService;
import com.dqs.service.UserService;
import com.dqs.util.Status;
import com.dqs.util.UserBasicInfo;

@Controller
@RequestMapping("/home/StudentController")
public class StudentController {
	@Autowired
	private StudentService ss;
	@Autowired
	private UserService us;
	@Autowired
	private CourseService cs;
	@Autowired
	private ChoosedService chs;
	@Autowired 
	private TeacherService ts;
	
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
		Map loginMap = new HashMap();
		//从请求头中 登录controller传过来的信息
		loginMap = (Map) req.getAttribute("loginMap");
		User user= (User) loginMap.get("userinfo");//用户登录信息
		// 获取登录者的id
		String id = (String) user.getId();
		// 查询学生表的基本信息--查出班级名
		Map basicMap = ss.selectOne(id);
		List list = UserBasicInfo.parseStuInfo(loginMap, basicMap);
		loginMap.put("basicInfoList", list);
		return loginMap;
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
	 * @Title: UpdateBasicInfo  
	 * @Description: 修改基本信息
	 * @author 王天博
	 * @param @param req
	 * @param @param basicInfo
	 * @param @return      
	 * @return Status
	 */
	@RequestMapping("/UpdateBasicInfo.do")
	@ResponseBody
	public Status UpdateBasicInfo(HttpServletRequest req,@RequestBody Object basicInfo){
		//从请求头中获取user信息
		Map userMap = (Map) req.getAttribute("user");
		// 转换参数类型
		Map basicInfoMap = (Map) basicInfo;
		// 获取登录者的id
		String id = (String) userMap.get("id");
		// 获取参数--电话性别
		String tel = (String) basicInfoMap.get("tel");
		Integer gender = null;
		if(basicInfoMap.get("gender").equals("男")){
			gender =0;
		}else if (basicInfoMap.get("gender").equals("女")){
			gender = 1;
		}
		//放置成User对象
		User user = new User();
		user.setId(id);
		user.setGender(gender);
		// 设置成Student对象
		Student student = new Student();
		student.setUser_id(id);
		student.setTel(tel);
		// 根据id去修改电话
		ss.updateTel(student);
		// 根据id修改性别
		us.updateGender(user);
		status.setValue("1");
		status.setMessage("修改成功");
		return status;
	}
	/**
	 * 
	 * @Title: selectAllCourse  
	 * @Description: 查询全部的课程信息
	 * @author 王天博
	 * @param @return      
	 * @return List
	 */
	@RequestMapping("/selectAllCourse.do")
	@ResponseBody
	public List selectAllCourse(){
		List list = cs.selectList();
		return list;
	}
	/**
	 * 
	 * @Title: selectCourse  
	 * @Description:学生进行选课
	 * @author 王天博
	 * @param       
	 * @return void
	 */
	@RequestMapping("/selectCourse.do")
	@ResponseBody
	public Status selectCourse(HttpServletRequest req,@RequestBody Object selectedList){
		Choosed choosed = new Choosed();
		//从请求头中获取user信息
		Map userMap = (Map) req.getAttribute("user");
		//转换参数类型
		Map listMap = (Map) selectedList;
		ArrayList<Map> list = (ArrayList<Map>) listMap.get("list");
		// 获取登录者的id
		String id = (String) userMap.get("id");
		// 遍历list
		for(int i = 0;i<list.size();i++){
			//获取课程号
			String courseId = (String) list.get(i).get("id");
			//将课程号等信息插入到选课表
			choosed.setUser_id(id);
			choosed.setCourse_id(courseId);
			chs.insertOne(choosed);
		}
		status.setValue("1");
		status.setMessage("添加成功");
		return status;
	}
	/**
	 * 
	 * @Title: selectChoosedList  
	 * @Description: 查询登录者的所有选课
	 * @author 王天博
	 * @param @param req
	 * @param @return      
	 * @return List
	 */
	@RequestMapping("/selectChoosedList.do")
	@ResponseBody
	public List selectChoosedList(HttpServletRequest req){
		//从请求头中获取user信息
		Map userMap = (Map) req.getAttribute("user");
		// 获取登录者的id
		String userId = (String) userMap.get("id");
		List list = chs.selectOwnChoosed(userId);
		System.out.println(list);
		return list;
	}
	/**
	 * 
	 * @Title: deleteChoosedCourse  
	 * @Description: 登陆者删除选课
	 * @author 王天博
	 * @param @param req
	 * @param @param deleteChoosedList
	 * @param @return      
	 * @return Status
	 */
	@RequestMapping("/deleteChoosedCourse.do")
	@ResponseBody
	public Status deleteChoosedCourse(HttpServletRequest req,@RequestBody Object deleteChoosedList){
		Choosed choosed = new Choosed();
		//从请求头中获取user信息
		Map userMap = (Map) req.getAttribute("user");
		//转换参数类型
		Map listMap = (Map) deleteChoosedList;
		ArrayList<Map> list = (ArrayList<Map>) listMap.get("list");
		// 获取登录者的id
		String id = (String) userMap.get("id");
		// 遍历list
		for(int i = 0;i<list.size();i++){
			//获取课程号
			String courseId = (String) list.get(i).get("course_id");
			//将课程号等信息插入到选课表
			choosed.setUser_id(id);
			choosed.setCourse_id(courseId);
			chs.deleteOne(choosed);
		}
		status.setValue("1");
		status.setMessage("删除成功");
		return status;
	}
	/**
	 * 
	 * @Title: selectAllTeacher  
	 * @Description: 查询全部老师授课的信息
	 * @author 王天博
	 * @param @return      
	 * @return List
	 */
	@RequestMapping("/selectAllTeacher.do")
	@ResponseBody
	public List selectAllTeacher() {
		List list = ts.selectAllTeacherTeachInfo();
		return list;
	}
}
