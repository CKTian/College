package com.dqs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.TeacherDao;
import com.dqs.dao.UserDao;
import com.dqs.dto.ShowAllTeacherInfoDto;
import com.dqs.entity.Teacher;
import com.dqs.service.TeacherService;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao tdao;
	@Autowired
	private UserDao udao;
	
	public List<Teacher> selectList() {
		return tdao.selectList();
	}
	public void deleteOne(String id) {
		 tdao.deleteOne(id);
	}
	public List selectOne(String userId) {
		//查询出老师信息
		List teacher = tdao.selectOneBasicInfo(userId);
		return teacher;
	}
	// 查询所有老师的授课信息
	public List selectAllTeacherTeachInfo() {
		return tdao.selectAllTeacherTeachInfo();
	}
	// 查询老师的基本信息
	public List selectAllTeacherInfo() {
		return tdao.selectAllTeacherInfo();
	}
	// 超级管理员修改一个老师的信息
	public void updateOneTeacherInfo(ShowAllTeacherInfoDto toUpdateInfo) {
		// 修改教师的用户名、性别
		udao.updateOneAccountGender(toUpdateInfo);
		// 查询出 即将要选的班级 的原班主任
		String choosedteamId = toUpdateInfo.getTeamId();
		System.out.println(choosedteamId);
		String id = tdao.selectTeacherId(choosedteamId);
		// 将原班主任的个人信息中的所带班级置空
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setTeam_id("0000");
		tdao.updateOneTeamId(teacher);
		// 修改教师的姓名和所带班级
	}

}
