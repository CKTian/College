package com.dqs.entity;
/**
 * 
 * 权限表
 * @author 王天博
 * 2018年1月3日
 */
public class Role {
	private String id ;//编号
	private String name ;//权限名
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
		return "Role [id=" + id + ", name=" + name + "]";
	}
	public Role(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
