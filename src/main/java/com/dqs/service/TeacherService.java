package com.dqs.service;

import java.util.List;
import java.util.Map;

import com.dqs.dto.ShowAllTeacherInfoDto;
import com.dqs.entity.Teacher;

public interface TeacherService {

	public List<Teacher> selectList();

	public void deleteOneTeacher(String userId);

	public List selectOne(String id);
	
	public List selectAllTeacherTeachInfo();

	public List selectAllTeacherInfo();
	
	public int updateOneTeacherInfo(ShowAllTeacherInfoDto toUpdateInfo);
	
	public int inserOneTeacher(ShowAllTeacherInfoDto toUpdateInfo);
	
	public String selectTeacherId(String userId);
}
