package com.dqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.CourseDao;
import com.dqs.entity.Course;
import com.dqs.service.CourseService;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao cdao;
	/**
	 * 查询全部的课程信息
	 */
	public List<Course> selectList() {
		return cdao.selectList();
	}
	/**
	 * 展示登录老师所教的课程
	 */
	public List showTeachCourse(String teacherId) {
		List list = cdao.showTeachCourse(teacherId);
		return list;
	}
	/**
	 * 展示登录老师所教课程的课表
	 */
	public List showTimeTable(String userId) {
		List list = cdao.showTimeTable(userId);
		return list;
	}
	/**
	 * 修改一个课程的信息
	 */
	public int updateOneCourse(Course course) {
		boolean isHad = false;
		//  查询出该老师id对应的全部上课时间
		String teacherId = course.getTeacher_id();
		String time = course.getTime();
		List list = cdao.selectTeachCourse(teacherId);
		// 把结果与新时间进行比对
		for(int i = 0;i<list.size();i++){
			Course listMap = (Course) list.get(i);
			String teacherTime = listMap.getTime();
			if (time.equals(teacherTime)){
				isHad = true;
			}
		}
		//  相同则 冲突--返回
		if (isHad) {
			return 0;
		} else {
			// 不同 则去修改
			cdao.updateOneCourse(course);
			return 1;
		}
	}
	/**
	 * 增加一个课程信息
	 */
	public void insertOneCourse(Course course) {
		//根据教师id查询他教过得课
		// 判断是否教过 --如果教过--提示课程冲突
		// 没教过继续判断
		// 判断该老师 当前时间是否有课 -- 有课--提示时间冲突
		// 设置课程号自增--插入数据库
	}

}
