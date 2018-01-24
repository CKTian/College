package com.dqs.entity;

import java.util.List;

/**
 * 
 * TODO 老师实体类
 * @author 王天博
 * 2018年1月22日
 */
public class Teacher {
	private String id      ;//id
	private String team_id ;//班级id
	private String name    ;//老师名
	private String user_id;//教师编号
	
	private Team team;//与班级表一对一
	private String tname;
	
	private List courseList;// 与课程表一对多
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public List getCourseList() {
		return courseList;
	}
	public void setCourseList(List courseList) {
		this.courseList = courseList;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", team_id=" + team_id + ", name=" + name + ", user_id=" + user_id + ", team="
				+ team + ", tname=" + tname + ", courseList=" + courseList + "]";
	}
	public Teacher(String id, String team_id, String name, String user_id, Team team, String tname, List courseList) {
		super();
		this.id = id;
		this.team_id = team_id;
		this.name = name;
		this.user_id = user_id;
		this.team = team;
		this.tname = tname;
		this.courseList = courseList;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
