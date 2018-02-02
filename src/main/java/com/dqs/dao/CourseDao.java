package com.dqs.dao;

import java.util.List;

import com.dqs.entity.Course;


public interface CourseDao {
	public void insertOne();
	public void deleteOne();
	public void updateOne();
	public Course selectOne();
	public List<Course> selectList();
	public List showTeachCourse(String teacherId);
	public List showTimeTable(String userId);
}
