package com.dqs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.StudentDao;
import com.dqs.dao.TeamDao;
import com.dqs.dao.UserDao;
import com.dqs.entity.Student;
import com.dqs.entity.Team;
import com.dqs.entity.User;
import com.dqs.service.StudentService;
import com.dqs.util.CreateUUID;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao sdao;
	@Autowired
	private TeamDao tdao;
	@Autowired 
	private UserDao udao;
	public List<Student> selectList(String user_id) {
		return sdao.selectList(user_id);
	}
	// 查询一个人信息
	public Map selectOne(String user_id) {
		Map map = new HashMap();
		Student student =  sdao.selectOne(user_id);
		String team_id = student.getTeam_id();//获取班级id 
		Team team = tdao.selectOne(team_id);//查询班级名
		String team_name = team.getName();//获取班级名
		map.put("student", student);
		map.put("team_name", team_name);
		return map;
	}
	/**
	 * 修改个人电话信息
	 */
	public void updateTel(Student student) {
		sdao.updateTel(student);
	}
	/**
	 * 查询老师所带班级的所有学生的信息
	 */
	public List selectOwnStuList(String teamName) {
		List list = sdao.selectOwnStuList(teamName);
		return list;
	}
	/**
	 * 查询全部的学生信息
	 */
	public List selectAllStuList() {
		List list = sdao.selectAllStuList();
		return list;
	}
	/**
	 * 老师修改一个所带学生的信息
	 */
	public int updateOne(Student student) {
		// 查询全部学生--
		List list = udao.selectList();
		boolean isHad = false;
		for (int i =0;i<list.size();i++){
			User user = (User) list.get(i);
			// 判断id不是一个
			if(!(student.getUser_id()).equals(user.getId())){
				// 判断用户名是不是一个
				if((student.getAccount()).equals(user.getAccount())){
					isHad = true;
				}
			}
		}
		if (isHad) {
			return 0;
		} else{
			// 修改学生表
			sdao.updateOne(student);
			// 修改用户表
			User user = new User();
			user.setId(student.getUser_id());
			user.setAccount(student.getAccount());
			user.setGender(student.getGender());
			udao.updateGenderAccount(user);
			return 1;
		}
	}
	/**
	 * 查询一个班级的所有学生名字
	 */
	public List selectTeamStus(String teamId) {
		return sdao.selectTeamStus(teamId);
	}
	/**
	 * 添加一个学生信息
	 */
	public int insertOneStu(Map info) {
		// 判断用户名是否相同--相同终止
		Integer count = udao.checkAccount((String)info.get("account"));
		if (count !=0){
			//重复 不能添加
			return 0;
		}else {
			// 向用户表中添加一个用户
			User user = new User();
			String id = CreateUUID.getUUID();
			user.setId(id);
			user.setAccount((String)info.get("account"));
			// 性别字符串转为int
			String sex = (String)info.get("gender");
			Integer gender = Integer.valueOf(sex);
			user.setGender(gender);
			user.setPassword("123");
			user.setRole_id(2);
			udao.insertOne(user);
			// 向学生表添加一个学生
			Student student = new Student();
			student.setId(CreateUUID.getUUID());
			student.setUser_id(id);
			student.setName((String)info.get("name"));
			student.setTeam_id((String)info.get("teamId"));
			student.setPoint("");
			student.setReward("");
			student.setTel("");
			sdao.insertOne(student);
			return 1;
		}
	}
}
