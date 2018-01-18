package com.dqs.service;

import java.util.List;

import com.dqs.entity.User;

public interface UserService {
	public User selectOne(String account);
	public void updateOnePwd(User user);
	public List<User> selectTeacher();
}
