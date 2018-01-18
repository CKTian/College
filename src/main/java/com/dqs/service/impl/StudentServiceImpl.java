package com.dqs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.StudentDao;
import com.dqs.dao.TeamDao;
import com.dqs.entity.Student;
import com.dqs.entity.Team;
import com.dqs.service.StudentService;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao sdao;
	@Autowired
	private TeamDao tdao;
	public List<Student> selectList(String user_id) {
		return sdao.selectList(user_id);
	}
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

}
