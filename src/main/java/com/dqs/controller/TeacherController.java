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

import com.dqs.entity.Student;
import com.dqs.entity.Teacher;
import com.dqs.entity.User;
import com.dqs.service.ChoosedService;
import com.dqs.service.CourseService;
import com.dqs.service.StudentService;
import com.dqs.service.TeacherService;
import com.dqs.service.UserService;
import com.dqs.util.Status;
import com.dqs.util.UserBasicInfo;

@Controller
@RequestMapping("/home/TeacherController")
public class TeacherController {
	@Autowired
	private UserService us;
	@Autowired 
	private TeacherService ts;
	@Autowired 
	private StudentService ss;
	@Autowired
	private ChoosedService chs;
	@Autowired 
	private CourseService cs;
	
	private Status status;
	TeacherController (){
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
		// 获取登录者的id
		String id = (String) user.getId();
		// 查询老师表的基本信息--查出班级名
		List listInfo = ts.selectOne(id);
		List list = UserBasicInfo.parseTeacherInfo(loginMap, listInfo);
		loginMap.put("basicInfoList", list);
		return loginMap;
	}
	/**
	 * 
	 * @Title: updatePwd  
	 * @Description: 修改老师的登录密码
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
	 * @Title: UpdateBasicInfo  
	 * @Description: 修改老师的基本信息
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
		// 获取参数--性别
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
		// 设置成Teacher对象
		Teacher teacher = new Teacher();
		teacher.setUser_id(id);
		// 根据id修改性别
		us.updateGender(user);
		status.setValue("1");
		status.setMessage("修改成功");
		return status;
	}
	/**
	 * 
	 * @Title: selectOwnStu  
	 * @Description: 查询登录老师所带班级的学生
	 * @author 王天博
	 * @param @param tName
	 * @param @return      
	 * @return List
	 */
	@RequestMapping("/selectOwnStu.do")
	@ResponseBody
	public List selectOwnStu(@RequestBody Object tName){
		// 转换参数类型
		Map teamNameMap = (Map) tName;
		String teamName = (String) teamNameMap.get("teamName");
		List list = ss.selectOwnStuList(teamName);
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/toUpdateStuInfo.do")
	@ResponseBody
	public Status toUpdateStuInfo(@RequestBody Object formInfo){
		Map Info = (Map) formInfo;
		Map newInfo = (Map) Info.get("form");
		Student student = new Student();
		student.setUser_id((String)Info.get("id"));
		student.setName((String)newInfo.get("name"));
		student.setGender((Integer)newInfo.get("gender"));
		student.setTel((String)newInfo.get("tel"));
		student.setPoint((String)newInfo.get("point"));
		student.setReward((String)newInfo.get("reward"));
		//修改学生信息
		ss.updateOne(student);
		status.setValue("1");
		status.setMessage("修改成功");
		return status;
	}
	@RequestMapping("/showStuChoosed.do")
	@ResponseBody
	public List showStuChoosed(@RequestBody Object tName){
		Map teamNameMap = (Map) tName;
		String teamName = (String) teamNameMap.get("teamName");// 获得班级名称
		// 根据班级名查出 所带班级
		List list = chs.showStuCourse(teamName);
		System.out.println(list);
		return list;
	}
	/**
	 * 
	 * @Title: showTeachCourse  
	 * @Description: 展示登录的老师所教的课程
	 * @author 王天博
	 * @param @param req
	 * @param @return      
	 * @return List
	 */
	@RequestMapping("/showTeachCourse.do")
	@ResponseBody
	public List showTeachCourse(HttpServletRequest req){
		//从请求头中获取user信息
		Map userMap = (Map) req.getAttribute("user");
		// 获取登录者的id
		String id = (String) userMap.get("id");
		List list = cs.showTeachCourse(id);
		return list;
	}
	/**
	 * 
	 * @Title: showChoosedCourseStu  
	 * @Description: 展示选择该课程的学生的成绩信息
	 * @author 王天博
	 * @param @param Cid
	 * @param @return      
	 * @return List
	 */
	@RequestMapping("/showChoosedCourseStu.do")
	@ResponseBody
	public List showChoosedCourseStu(@RequestBody Object Cid){
		// 转换参数类型
		Map CourseIdMap = (Map) Cid;
		String courseId = (String) CourseIdMap.get("courseId");
		List list = chs.showChoosedCourseStu(courseId);
		return list;
	}
	/**
	 * 
	 * @Title: updateScore  
	 * @Description: 修改学生成绩
	 * @author 王天博
	 * @param @param tableData
	 * @param @return      
	 * @return Status
	 */
	@RequestMapping("/updateScore.do")
	@ResponseBody
	public Status updateScore(@RequestBody Object tableData){
		// 转换参数类型
		Map tableDataMap = (Map) tableData;
		List dataList = (List) tableDataMap.get("tableData");
		// 将修改的信息传入到数据库
		chs.updateScore(dataList);
		//返回状态值
		status.setValue("1");
		status.setMessage("分数提交成功");
		return status;
	}
	/**
	 * 
	 * @Title: showOwnStuChoosedScore  
	 * @Description: 查询一位同学的所有科目的成绩
	 * @author 王天博
	 * @param @param UserId
	 * @param @return      
	 * @return List
	 */
	@RequestMapping("/showOwnStuChoosedScore.do")
	@ResponseBody
	public List showOwnStuChoosedScore(@RequestBody Object uid){
		// 转换参数类型uid
		Map UserIdMap = (Map) uid;
		String userId = (String) UserIdMap.get("uid");
		List list = chs.showOwnStuChoosedScore(userId);
		return list;
	}
	
}
