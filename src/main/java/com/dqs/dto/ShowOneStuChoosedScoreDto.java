package com.dqs.dto;

public class ShowOneStuChoosedScoreDto {
	private String courseId;
	private String cname;
	private String score;
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "ShowOneStuChoosedScoreDto [courseId=" + courseId + ", cname=" + cname + ", score=" + score + "]";
	}
	public ShowOneStuChoosedScoreDto(String courseId, String cname, String score) {
		super();
		this.courseId = courseId;
		this.cname = cname;
		this.score = score;
	}
	public ShowOneStuChoosedScoreDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
