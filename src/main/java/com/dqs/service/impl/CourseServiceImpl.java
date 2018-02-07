package com.dqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.ChoosedDao;
import com.dqs.dao.CourseDao;
import com.dqs.entity.Course;
import com.dqs.service.CourseService;
import com.dqs.util.CreateUUID;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao cdao;
	@Autowired
	private ChoosedDao chdao;
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
	public int insertOneCourse(Course course) {
		String teacherId = course.getTeacher_id();
		String courseName = course.getName();
		String teachTime = course.getTime();
		boolean isHadSameName = false;
		boolean isHadSameTime = false;
		//根据教师id查询他教过得课
		List list = cdao.selectTeachCourse(teacherId);
		// 判断是否教过 --如果教过--提示课程冲突
		for (int i= 0;i<list.size();i++){
			Course listMap = (Course) list.get(i);
			String cName = listMap.getName();
			String tTime = listMap.getTime();
			if (teachTime.equals(tTime)){
				isHadSameTime = true;
			}
			if(courseName.equals(cName)){
				isHadSameName = true;
			}
		}
		// --如果教过--提示课程冲突
		if (isHadSameName) {
			return 0;
		}else {
			// 没教过继续判断
			// 判断该老师 当前时间是否有课 -- 有课--提示时间冲突
			if(isHadSameTime){
				return 2;
			}else{
				// 设置课程号自增--插入数据库
				String courseId = CreateUUID.getUUID();
				course.setId(courseId);
				cdao.insertOne(course);
				return 1;
			}
		}
	}
	/**
	 * 删除一门课程
	 */
	public void deleteOneCourse(String courseId) {
		// 查询出选了该课程的 选课id
		List list = chdao.selectChoosedId(courseId);
		if (list.size()!= 0){
			// 将查询出的选课中的 课程号 都删除
			chdao.deleteChoosedCourseId(list);
		}
		//删除该课程
		cdao.deleteOne(courseId);
	}

}
