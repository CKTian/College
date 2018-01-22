package com.dqs.service;

import java.util.List;
import java.util.Map;

import com.dqs.entity.Student;
import com.dqs.entity.User;

public interface StudentService {
	public List<Student> selectList(String user_id);
	public Map selectOne(String user_id);
	public void updateTel(Student student);
}
