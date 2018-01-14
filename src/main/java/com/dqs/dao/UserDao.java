package com.dqs.dao;

import java.util.List;

import com.dqs.entity.User;

public interface UserDao {
	public void insertOne();
	public void deleteOne();
	public void updateOne(String account);
	public User selectOne(String account);
	public List<User> selectList();
	public List<User> selectWithRole(String role_id);
}
