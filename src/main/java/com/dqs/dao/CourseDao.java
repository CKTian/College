package com.dqs.dao;

import java.util.List;

import com.dqs.entity.Course;


public interface CourseDao {
	public void insertOne();
	public void deleteOne();
	public Course selectOne();
	public List<Course> selectList();
	public List showTeachCourse(String teacherId);
	public List showTimeTable(String userId);
	public List selectTeachCourse(String userId);
	public void updateTeacherId(String courseId);
	public void updateOneCourse(Course course);
}
