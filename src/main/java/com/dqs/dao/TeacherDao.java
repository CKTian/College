package com.dqs.dao;

import java.util.List;

import com.dqs.entity.Teacher;

public interface TeacherDao {
	public void insertOne();
	public void deleteOne(String id);
	public void updateOne();
	public Teacher selectOne(String id);
	public List<Teacher> selectList();
}
