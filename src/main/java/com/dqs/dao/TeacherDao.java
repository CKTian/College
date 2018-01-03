package com.dqs.dao;

import java.util.List;

import com.dqs.entity.Teacher;

public interface TeacherDao {
	public void insertOne();
	public void deleteOne();
	public void updateOne();
	public Teacher selectOne();
	public List<Teacher> selectList();
}
