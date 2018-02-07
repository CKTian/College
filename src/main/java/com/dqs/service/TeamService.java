package com.dqs.service;

import java.util.List;

import com.dqs.dto.ShowAllTeamDto;

public interface TeamService {
	public List selectList();
	public List selectAllTeam();
	public void updateOneTeam(ShowAllTeamDto updateInfo);
}
