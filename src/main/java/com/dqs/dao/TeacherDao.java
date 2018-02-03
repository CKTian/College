package com.dqs.dao;

import java.util.List;
import java.util.Map;

import com.dqs.entity.Teacher;

public interface TeacherDao {
	public void insertOne();
	public void deleteOne(String id);
	public void updateOne();
	public void updateOneTeamId(Teacher teacher);
	public Map selectOne(String id);
	public List<Teacher> selectList();
	public List selectAllTeacherTeachInfo();
	public List selectOneBasicInfo(String id);
	public List selectAllTeacherInfo();
	public String selectTeacherId(String choosedteamId);
}
