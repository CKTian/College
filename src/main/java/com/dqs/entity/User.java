package com.dqs.entity;
/**
 * 
 * �û���
 * @author ���첩
 * 2018��1��3��
 */
public class User {
	private String id       ;// �û����
	private String account  ;//�û���
	private String password ;//����
	private int role_id ;//Ȩ�ޱ�ʶ��
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
