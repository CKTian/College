package com.dqs.service;

import java.util.List;
import java.util.Map;

import com.dqs.dto.ShowAllTeamDto;

public interface TeamService {
	public List selectList();
	public List selectAllTeam();
	public int updateOneTeam(ShowAllTeamDto updateInfo);
	public int insertOneTeam(String teamName);
	public void deleteOneTeam(Map forDeleteInfo);
}
