package com.dqs.entity;
/**
 * 
 * 用户表
 * @author 王天博
 * 2018年1月3日
 */
public class User {
	private String id       ;// 用户编号
	private String account  ;//用户名
	private String password ;//密码
	private int role_id ;//权限标识符
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", role_id=" + role_id + "]";
	}
	public User(String id, String account, String password, int role_id) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.role_id = role_id;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
