package com.dqs.entity;
/**
 * 
 * 课程实体类
 * @author 王天博
 * 2018年1月22日
 */
public class Course {
	private String id         ;//课程编号
	private String name       ;//课程名
	private String teacher_id ;//老师id
	private String time       ;//上课时间
	
	private Teacher teacher; //一个老师对应多门课程--多对一的关系
	private String tname;//要查询出 老师的名字
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teacher_id=" + teacher_id + ", time=" + time + ", teacher="
				+ teacher + ", tname=" + tname + "]";
	}
	public Course(String id, String name, String teacher_id, String time, Teacher teacher, String tname) {
		super();
		this.id = id;
		this.name = name;
		this.teacher_id = teacher_id;
		this.time = time;
		this.teacher = teacher;
		this.tname = tname;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
