package com.dqs.dao;

import java.util.List;

import com.dqs.entity.Nav;

public interface NavDao {
	public List<Nav> selectList(Integer role_id);
}
