package com.dqs.dto;

public class ShowAllTeacherInfoDto {
	private String teacherId;
	private String userId;
	private String teamId;
	private String teacherName;
	private String teamName;
	private Integer gender;
	private String account;
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	@Override
	public String toString() {
		return "ShowAllTeacherInfoDto [teacherId=" + teacherId + ", userId=" + userId + ", teamId=" + teamId
				+ ", teacherName=" + teacherName + ", teamName=" + teamName + ", gender=" + gender + ", account="
				+ account + "]";
	}
	
	public ShowAllTeacherInfoDto(String teacherId, String userId, String teamId, String teacherName, String teamName,
			Integer gender, String account) {
		super();
		this.teacherId = teacherId;
		this.userId = userId;
		this.teamId = teamId;
		this.teacherName = teacherName;
		this.teamName = teamName;
		this.gender = gender;
		this.account = account;
	}
	public ShowAllTeacherInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
