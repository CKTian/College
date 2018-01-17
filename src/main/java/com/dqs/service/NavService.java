package com.dqs.service;

import java.util.List;

import com.dqs.entity.Nav;
public interface NavService {
	public List<Nav> selectList(Integer role_id);
}
