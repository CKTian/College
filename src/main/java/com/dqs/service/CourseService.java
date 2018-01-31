package com.dqs.service;

import java.util.List;

import com.dqs.entity.Course;

public interface CourseService {

	public List<Course> selectList();
	public List showTeachCourse(String teacherId);

}
