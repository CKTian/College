package com.dqs.entity;
/**
 * 
 * 班级表实体类
 * @author 王天博
 * 2018年1月24日
 */
public class Team {
	private String id ;//班级编号
	private String name;//班级名
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
