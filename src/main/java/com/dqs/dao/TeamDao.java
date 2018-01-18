package com.dqs.dao;

import java.util.List;

import com.dqs.entity.Team;

public interface TeamDao {
	public void insertOne();
	public void deleteOne();
	public void updateOne();
	public Team selectOne(String team_id);
	public List<Team> selectList();
}
