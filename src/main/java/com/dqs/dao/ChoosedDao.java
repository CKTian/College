package com.dqs.dao;

import java.util.List;

import com.dqs.entity.Choosed;

public interface ChoosedDao {
	public void insertOne(Choosed choosed);
	public void deleteOne(Choosed choosed);
	public void deleteAllChoose(String userId);
	public void updateOne();
	public Choosed selectOne();
	public List<Choosed> selectList();
	public List selectOwnCourse(String userId);// 查询出课程号
	public List selectOwnChoosed(String userId);// 多表联查
	public List showStuCourse(String teamName);
	public List showChoosedCourseStu(String courseId);
	public void updateList(List dataList);// 多条语句一起更新
	public List showOwnStuChoosedScore(String userId);
	public List selectChoosedId(String courseId);
	public void deleteChoosedCourseId(List list);//多条语句一起删除
}
