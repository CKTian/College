package com.dqs.service;

import java.util.List;

import com.dqs.entity.Teacher;

public interface TeacherService {

	public List<Teacher> selectList();

	public void deleteOne(String id);

	public Teacher selectOne(String id);

}
