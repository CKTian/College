package com.dqs.entity;
/**
 * 
 * ѡ�α�
 * @author ���첩
 * 2018��1��3��
 */
public class Choosed {
	private String id        ;//���
	private String user_id   ;//�û����
	private String course_id ;//�γ̱��
	private String score     ;//�ɼ�
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
	@Override
	public String toString() {
		return "Choosed [id=" + id + ", user_id=" + user_id + ", course_id=" + course_id + ", score=" + score + "]";
	}
	public Choosed(String id, String user_id, String course_id, String score) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.course_id = course_id;
		this.score = score;
	}
	public Choosed() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
