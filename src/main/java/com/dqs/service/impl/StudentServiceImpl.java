package com.dqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.StudentDao;
import com.dqs.entity.Student;
import com.dqs.service.StudentService;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao sdao;
	public List<Student> selectList(String user_id) {
		return sdao.selectList(user_id);
	}

}
