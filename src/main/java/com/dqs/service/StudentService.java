package com.dqs.service;

import java.util.List;
import java.util.Map;

import com.dqs.entity.Student;

public interface StudentService {
	public List<Student> selectList(String user_id);
	public Map selectOne(String user_id);
}
