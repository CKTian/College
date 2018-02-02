package com.dqs.dto;

public class showTimeTableDto {
	private String courseId;
	private String courseName;
	private String courseTime;
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	@Override
	public String toString() {
		return "showTimeTableDto [courseId=" + courseId + ", courseName=" + courseName + ", courseTime=" + courseTime
				+ "]";
	}
	public showTimeTableDto(String courseId, String courseName, String courseTime) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseTime = courseTime;
	}
	public showTimeTableDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
