package com.dqs.entity;
/**
 * 
 * 选课表实体类
 * @author 王天博
 * 2018年1月23日
 */
public class Choosed {
	private String id        ;//编号
	private String user_id   ;//登陆者id
	private String course_id ;//课程编号
	private String score     ;//分数
	
	private Course course; //选课对课程--多对一的关系
	private String cname; // 查询出 课程的名字
	private String cid;//要查询出 课程的编号
	private String time;// 上课时间
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
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Choosed [id=" + id + ", user_id=" + user_id + ", course_id=" + course_id + ", score=" + score
				+ ", course=" + course + ", cname=" + cname + ", cid=" + cid + ", time=" + time + "]";
	}
	public Choosed(String id, String user_id, String course_id, String score, Course course, String cname, String cid,
			String time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.course_id = course_id;
		this.score = score;
		this.course = course;
		this.cname = cname;
		this.cid = cid;
		this.time = time;
	}
	public Choosed() {
		super();
		// TODO Auto-generated constructor stub
	}


}
