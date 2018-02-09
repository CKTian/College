package com.dqs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.CourseDao;
import com.dqs.dao.TeacherDao;
import com.dqs.dao.TeamDao;
import com.dqs.dto.ShowAllTeamDto;
import com.dqs.entity.Course;
import com.dqs.entity.Teacher;
import com.dqs.entity.Team;
import com.dqs.service.TeamService;
import com.dqs.util.CreateUUID;
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
	public int updateOneTeam(ShowAllTeamDto updateInfo) {
		boolean isHad = false;
		// 查询全部的班级名
		List list = tdao.selectList();
		// 判断id 是否相同
		// 判断名字是否重复----------------------
		for(int i = 0;i<list.size();i++){
			Team listMap = (Team) list.get(i);
			String teamName = listMap.getName();
			String teamId = listMap.getId();
			if(!(updateInfo.getTeamId()).equals(teamId)){// 同一个id则不进行名字的判断
				if((updateInfo.getTeamName()).equals(teamName)){
					isHad = true;
				}
			}
		}
		if (isHad) {
			return 0;
		}else{
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
			return 1;
		}
		
	}
	/**
	 * 增加一个班级
	 */
	public int insertOneTeam(String teamName) {
		boolean isHad = false;
		// 查询全部的班级名
		List list = tdao.selectList();
		// 判断名字是否重复----------------------
		for(int i = 0;i<list.size();i++){
			Team listMap = (Team) list.get(i);
			String OldteamName = listMap.getName();
			if(teamName.equals(OldteamName)){
				isHad = true;
			}
		}
		if (isHad){
			// 重复 返回0
			return 0;
		}else {
			// 没重 增加
			// 创建一个新的对象
			Team team = new Team();
			team.setId(CreateUUID.getUUID());
			team.setName(teamName);
			// 增加一条班级信息
			tdao.insertOne(team);
			return 1;
		}
	}
	/**
	 * 删除一条班级信息
	 */
	public void deleteOneTeam(Map forDeleteInfo) {
		String teacherId = (String)forDeleteInfo.get("teacherId");
		String teamId = (String)forDeleteInfo.get("teamId");
		// 将该班主任的班级id 设置为0000
		Teacher teacher = new Teacher();
		teacher.setId(teacherId);
		teacher.setTeam_id("0000");
		thdao.updateOneTeamId(teacher);
		// 删除一条班级信息
		tdao.deleteOne(teamId);
	}
	

}