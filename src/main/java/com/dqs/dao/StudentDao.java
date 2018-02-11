package com.dqs.dao;

import java.util.List;

import com.dqs.entity.Student;

public interface StudentDao {
	public void insertOne(Student student);
	public void deleteOne(String stuId);
	public void updateOne(Student student);
	public Student selectOne(String user_id);
	public List<Student> selectList(String user_id);
	public void updateTel(Student student);
	public List selectOwnStuList(String teamName);// 老师
	public List selectAllStuList();// 超级管理员
	public List showStuCourse(String teamName);
	public List selectTeamStus(String teamId);
}
