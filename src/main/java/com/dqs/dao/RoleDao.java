package com.dqs.dao;

import java.util.List;

import com.dqs.entity.Role;

public interface RoleDao {
	public void insertOne();
	public void deleteOne();
	public void updateOne();
	public Role selectOne();
	public List<Role> selectList();
}
