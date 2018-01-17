package com.dqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.NavDao;
import com.dqs.entity.Nav;
import com.dqs.service.NavService;
@Service
@Transactional
public class NavServiceImpl implements NavService {
	@Autowired
	private NavDao ndao;
	public List<Nav> selectList(Integer role_id) {
		// TODO Auto-generated method stub
		return ndao.selectList(role_id);
	}

}
