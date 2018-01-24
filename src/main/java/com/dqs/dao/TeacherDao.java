package com.dqs.dao;

import java.util.List;
import java.util.Map;

import com.dqs.entity.Teacher;

public interface TeacherDao {
	public void insertOne();
	public void deleteOne(String id);
	public void updateOne();
	public Map selectOne(String id);
	public List<Teacher> selectList();
	public List selectAllTeacherInfo();
	public List selectOneBasicInfo(String id);
}
