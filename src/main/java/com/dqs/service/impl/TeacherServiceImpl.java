package com.dqs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.CourseDao;
import com.dqs.dao.TeacherDao;
import com.dqs.dao.UserDao;
import com.dqs.dto.ShowAllTeacherInfoDto;
import com.dqs.entity.Course;
import com.dqs.entity.Teacher;
import com.dqs.entity.User;
import com.dqs.service.TeacherService;
import com.dqs.util.CreateUUID;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao tdao;
	@Autowired
	private UserDao udao;
	@Autowired
	private CourseDao cdao;
	
	public List<Teacher> selectList() {
		return tdao.selectList();
	}
	/**
	 * 删除一位老师
	 */
	public void deleteOneTeacher(String userId) {
		// 根据传递来的参数 查出该老师的teacherid
		String teacherId = tdao.selectTeacherIdWithUserId(userId);
		// 查出课程表中的该老师上的课
		List list = cdao.selectTeachCourse(teacherId);
		// 循环遍历获取到课程id 将课程对应的老师置0000
		for(int i = 0;i<list.size();i++){
			Course listMap = (Course) list.get(i);
			String courseId = listMap.getId();
			cdao.updateTeacherId(courseId);
		}
		//删除该老师--老师表
		tdao.deleteOneTeacher(teacherId);
		// 删除老师--用户表
		udao.deleteOne(userId);
	}
	public List selectOne(String userId) {
		//查询出老师信息
		List teacher = tdao.selectOneBasicInfo(userId);
		return teacher;
	}
	/**
	 * 查询所有老师的授课信息
	 */
	public List selectAllTeacherTeachInfo() {
		return tdao.selectAllTeacherTeachInfo();
	}
	/**
	 * 查询老师的基本信息
	 */
	public List selectAllTeacherInfo() {
		return tdao.selectAllTeacherInfo();
	}
	/**
	 * 超级管理员修改一个老师的信息
	 */
	public void updateOneTeacherInfo(ShowAllTeacherInfoDto toUpdateInfo) {
		// 修改教师的用户名、性别
		udao.updateOneAccountGender(toUpdateInfo);
		// 查询出 即将要选的班级 的原班主任
		String choosedteamId = toUpdateInfo.getTeamId();
		String id = tdao.selectTeacherId(choosedteamId);
		// 将原班主任的个人信息中的所带班级置空
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setTeam_id("0000");
		tdao.updateOneTeamId(teacher);
		// 修改教师的姓名和所带班级
		tdao.updateNameTeam(toUpdateInfo);
	}
	/**
	 * 超级管理员添加一位老师
	 */
	public int inserOneTeacher(ShowAllTeacherInfoDto toUpdateInfo) {
		// 向用户表增加一条信息--创建一个user对象
		User user = new User();
		user.setAccount(toUpdateInfo.getAccount());// 用户名
		user.setGender(toUpdateInfo.getGender()); // 性别
		  // 密码设置为123 权限为 1 id自增
		user.setPassword("123");//密码
		user.setRole_id(1);
		user.setId(CreateUUID.getUUID());
		  // 查询数据 ，判断是否含有该account
		Integer count = udao.checkAccount(toUpdateInfo.getAccount());
		if (count !=0){
			//重复 不能添加
			return count;
		}else {
			// 插入到用户表
			udao.insertOne(user);
			// 插入到老师表
				// 判断选中班级是否含有老师
				// 查询出 即将要选的班级 的原班主任
				String choosedteamId = toUpdateInfo.getTeamId();
				String id = tdao.selectTeacherId(choosedteamId);
				// 将原班主任的个人信息中的所带班级置空
				Teacher teacher = new Teacher();
				teacher.setId(id);
				teacher.setTeam_id("0000");
				tdao.updateOneTeamId(teacher);
	
			Teacher newTeacher = new Teacher();
			newTeacher.setId(CreateUUID.getUUID());
			newTeacher.setName(toUpdateInfo.getTeacherName());
			newTeacher.setTeam_id(toUpdateInfo.getTeamId());
			newTeacher.setUser_id(user.getId());
			tdao.insertOne(newTeacher);
			count = 0;
			return count;
		}
	}

}
