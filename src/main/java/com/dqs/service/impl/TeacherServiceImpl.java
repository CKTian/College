package com.dqs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.TeacherDao;
import com.dqs.entity.Teacher;
import com.dqs.service.TeacherService;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao tdao;
	
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
	public List selectAllTeacherInfo() {
		return tdao.selectAllTeacherInfo();
	}

}
