package com.dqs.util;
/**
 * 
 * ״̬ ������
 * @author ���첩
 * 2018��1��10��
 */
public class Status {
	private String value;//״ֵ̬ 0-ʧ�� 1-�ɹ�
	private String message;//״̬����
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
