package com.dqs.service;

import java.util.List;

import com.dqs.entity.Student;

public interface StudentService {
	public List<Student> selectList(String user_id);
}
