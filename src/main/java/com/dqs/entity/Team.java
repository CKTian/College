package com.dqs.entity;
/**
 * 
 * �༶��
 * @author ���첩
 * 2018��1��3��
 */
public class Team {
	private String id ;//���
	private String name;//�༶��
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
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
	public Team(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
