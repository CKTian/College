package com.dqs.util;

public class Status {
	private String value;//×´Ì¬Öµ
	private String message;//×´Ì¬ÃèÊö
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
		return "Status [value=" + value + ", message=" + message + "]";
	}
	public Status(String value, String message) {
		super();
		this.value = value;
		this.message = message;
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
