package com.dqs.util;
/**
 * 
 * ״̬ ������
 * @author ���첩
 * 2018��1��10��
 */
public class Status {
	private String value;//״ֵ̬
	private String message;//״̬����
	private String token;//�û���Ϣ
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Status [value=" + value + ", message=" + message + ", token=" + token + "]";
	}
	public Status(String value, String message, String token) {
		super();
		this.value = value;
		this.message = message;
		this.token = token;
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
