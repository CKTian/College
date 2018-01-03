package com.dqs.entity;
/**
 * 
 * 学生信息表
 * @author 王天博
 * 2018年1月3日
 */
public class Student {
	private String id      ; //编号
	private String user_id ; //用户编号
	private String name    ; //姓名
	private String team_id ; //班级编号
	private Integer gender ; //性别
	private String tel     ; //电话
	private String reward  ; //奖惩
	private String point   ; //学分
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", user_id=" + user_id + ", name=" + name + ", team_id=" + team_id + ", gender="
				+ gender + ", tel=" + tel + ", reward=" + reward + ", point=" + point + "]";
	}
	public Student(String id, String user_id, String name, String team_id, Integer gender, String tel, String reward,
			String point) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.name = name;
		this.team_id = team_id;
		this.gender = gender;
		this.tel = tel;
		this.reward = reward;
		this.point = point;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
