package com.dqs.dao;

import java.util.List;

import com.dqs.entity.Student;

public interface StudentDao {
	public void insertOne();
	public void deleteOne();
	public void updateOne();
	public Student selectOne();
	public List<Student> selectList();
}
