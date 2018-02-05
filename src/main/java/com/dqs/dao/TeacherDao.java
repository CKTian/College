package com.dqs.dao;

import java.util.List;
import java.util.Map;

import com.dqs.dto.ShowAllTeacherInfoDto;
import com.dqs.entity.Teacher;

public interface TeacherDao {
	public void insertOne(Teacher newTeacher);
	public void deleteOneTeacher(String userId);
	public void updateOne();
	public void updateOneTeamId(Teacher teacher);
	public void updateNameTeam(ShowAllTeacherInfoDto toUpdateInfo);
	public Map selectOne(String id);
	public List<Teacher> selectList();
	public List selectAllTeacherTeachInfo();
	public List selectOneBasicInfo(String id);
	public List selectAllTeacherInfo();
	public String selectTeacherId(String choosedteamId);
	public String selectTeacherIdWithUserId(String userId);
}
