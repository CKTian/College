package com.dqs.dao;

import java.util.List;

import com.dqs.entity.Student;

public interface StudentDao {
	public void insertOne();
	public void deleteOne();
	public void updateOne(Student student);
	public Student selectOne(String user_id);
	public List<Student> selectList(String user_id);
	public void updateTel(Student student);
	public List selectOwnStuList(String teamName);
}
