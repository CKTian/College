package com.dqs.entity;
/**
 * 
 * Ȩ�ޱ�
 * @author ���첩
 * 2018��1��3��
 */
public class Role {
	private String id ;//���
	private String name ;//Ȩ����
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
