package com.dqs.entity;
/**
 * 
 * 学生实体类
 * @author 王天博
 * 2018年1月18日
 */
public class Student {
	private String id      ; //id
	private String user_id ; //用户编号
	private String name    ; //姓名
	private String team_id ; //班级id
	private String tel     ; //电话
	private String reward  ; //奖惩
	private String point   ; //绩点
	
	private User user;//设置一对一的关系
	private String account;
	private Integer gender;// 设置显示性别
	
	private Course course;//设置学生表 和课程表一对多
	private String cname;//设置显示课程名称
	
	private Team team;
	private String tid;
	private String tname;
	
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
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
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public Student(String id, String user_id, String name, String team_id, String tel, String reward, String point,
			User user, String account, Integer gender, Course course, String cname, Team team, String tid,
			String tname) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.name = name;
		this.team_id = team_id;
		this.tel = tel;
		this.reward = reward;
		this.point = point;
		this.user = user;
		this.account = account;
		this.gender = gender;
		this.course = course;
		this.cname = cname;
		this.team = team;
		this.tid = tid;
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", user_id=" + user_id + ", name=" + name + ", team_id=" + team_id + ", tel=" + tel
				+ ", reward=" + reward + ", point=" + point + ", user=" + user + ", account=" + account + ", gender="
				+ gender + ", course=" + course + ", cname=" + cname + ", team=" + team + ", tid=" + tid + ", tname="
				+ tname + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
