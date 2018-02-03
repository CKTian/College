package com.dqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.TeamDao;
import com.dqs.service.TeamService;
@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamDao tdao;
	// 查询出所有班级的名称
	public List selectList() {
		return tdao.selectList();
	}

}
