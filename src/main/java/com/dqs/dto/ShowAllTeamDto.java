package com.dqs.dto;

public class ShowAllTeamDto {
	private String teamId;
	private String teamName;
	private String teacherName;
	private String teacherId;
	private Integer CountStu;
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getCountStu() {
		return CountStu;
	}
	public void setCountStu(Integer countStu) {
		CountStu = countStu;
	}
	@Override
	public String toString() {
		return "ShowAllTeamDto [teamId=" + teamId + ", teamName=" + teamName + ", teacherName=" + teacherName
				+ ", teacherId=" + teacherId + ", CountStu=" + CountStu + "]";
	}
	public ShowAllTeamDto(String teamId, String teamName, String teacherName, String teacherId, Integer countStu) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.teacherName = teacherName;
		this.teacherId = teacherId;
		CountStu = countStu;
	}
	public ShowAllTeamDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
