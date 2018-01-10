package com.dqs.util;
/**
 * 
 * 状态 工具类
 * @author 王天博
 * 2018年1月10日
 */
public class Status {
	private String value;//状态值
	private String message;//状态描述
	private String token;//用户信息
	
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
