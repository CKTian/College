package com.dqs.entity;
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
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", team_id=" + team_id + ", name=" + name + "]";
	}
	public Teacher(String id, String team_id, String name) {
		super();
		this.id = id;
		this.team_id = team_id;
		this.name = name;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
