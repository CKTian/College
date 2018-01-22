package com.dqs.dao;

import java.util.List;

import com.dqs.entity.Choosed;

public interface ChoosedDao {
	public void insertOne(Choosed choosed);
	public void deleteOne();
	public void updateOne();
	public Choosed selectOne();
	public List<Choosed> selectList();
	public List selectOwnCourse(String userId);
}
