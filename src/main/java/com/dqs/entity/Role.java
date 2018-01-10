package com.dqs.entity;
/**
 * 
 * 权限表
 * @author 王天博
 * 2018年1月3日
 */
public class Role {
	private int id ;//编号
	private String name ;//权限名
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		return "Role [id=" + id + ", name=" + name + "]";
	}
	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Role() {
		super();
	}
	
}
