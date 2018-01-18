package com.dqs.entity;
/**
 * 
 * 用户表
 * @author 王天博
 * 2018年1月18日
 */
public class User {
	private String id       ;// id
	private String account  ;//用户名
	private String password ;//密码
	private Integer role_id ;//权限
	private Integer gender ;//性别
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
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
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", role_id=" + role_id
				+ ", gender=" + gender + "]";
	}
	public User(String id, String account, String password, Integer role_id, Integer gender) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.role_id = role_id;
		this.gender = gender;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
