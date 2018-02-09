package com.dqs.dao;

import java.util.List;

import com.dqs.dto.ShowAllTeamDto;
import com.dqs.entity.Team;

public interface TeamDao {
	public void insertOne(Team team);
	public void deleteOne(String teamId);
	public void updateOne(ShowAllTeamDto updateInfo);
	public Team selectOne(String team_id);
	public List<Team> selectList();
	public List selectAllTeam();
}
