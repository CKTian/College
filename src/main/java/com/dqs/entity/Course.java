package com.dqs.entity;
/**
 * 
 * �γ̱�
 * @author ���첩
 * 2018��1��3��
 */
public class Course {
	private String id         ;//���
	private String name       ;//�γ�  
	private String teacher_id ;//��ʦ���
	private String time       ;//�Ͽ�ʱ��
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
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teacher_id=" + teacher_id + ", time=" + time + "]";
	}
	public Course(String id, String name, String teacher_id, String time) {
		super();
		this.id = id;
		this.name = name;
		this.teacher_id = teacher_id;
		this.time = time;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
