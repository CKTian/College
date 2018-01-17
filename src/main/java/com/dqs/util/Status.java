package com.dqs.util;
/**
 * 
 * 状态 工具类
 * @author 王天博
 * 2018年1月10日
 */
public class Status {
	private String value;//状态值 0-失败 1-成功
	private String message;//状态描述
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
		return "Status [value=" + value + ", message=" + message +  "]";
	}
	public Status(String value, String message, String token) {
		super();
		this.value = value;
		this.message = message;
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
