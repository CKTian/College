package com.dqs.service;

import java.util.List;

import com.dqs.entity.Course;

public interface CourseService {

	public List<Course> selectList();
	public List showTeachCourse(String teacherId);
	public List showTimeTable(String userId);
	public int updateOneCourse(Course course);
	public int insertOneCourse(Course course);
	public void deleteOneCourse(String courseId);

}
