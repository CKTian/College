package com.dqs.service.impl;

import java.util.List;

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
	public Teacher selectOne(String id) {
		return tdao.selectOne(id);
	}

}
