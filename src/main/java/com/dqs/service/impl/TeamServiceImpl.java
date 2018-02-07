package com.dqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.CourseDao;
import com.dqs.dao.TeacherDao;
import com.dqs.dao.TeamDao;
import com.dqs.dto.ShowAllTeamDto;
import com.dqs.entity.Teacher;
import com.dqs.service.TeamService;
@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamDao tdao;
	@Autowired
	private TeacherDao thdao;
	// 查询出所有班级的名称
	public List selectList() {
		return tdao.selectList();
	}
	/**
	 * 查询出所有班级的信息
	 */
	public List selectAllTeam() {
		return tdao.selectAllTeam();
	}
	/**
	 * 修改一个班级的信息
	 */
	public void updateOneTeam(ShowAllTeamDto updateInfo) {
		// 判断名字是否重复----------------------
		// 修改班级表中的班级名称
		tdao.updateOne(updateInfo);
		// 根据班级id 查询出原老师id
		String id = thdao.selectTeacherId(updateInfo.getTeamId());
		// 根据原老师的teacherID 查出 对应的班级id 并置0000
		Teacher oldTeacher = new Teacher();
		oldTeacher.setId(id);
		oldTeacher.setTeam_id("0000");
		thdao.updateOneTeamId(oldTeacher);
		// 修改选中老师的班级id 
		Teacher newTeacher = new Teacher();
		newTeacher.setId(updateInfo.getTeacherId());
		newTeacher.setTeam_id(updateInfo.getTeamId());
		thdao.updateOneTeamId(newTeacher);
		
	}
	

}
