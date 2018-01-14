package com.dqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.UserDao;
import com.dqs.entity.User;
import com.dqs.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao udao;
	
	public User selectOne(String account) {
		return udao.selectOne(account);
	}
	
	public void updateOne(String account) {
		 udao.updateOne(account);
	}
	public List<User> selectTeacher() {
		String role_id = "2";//∆’Õ®¿œ ¶
		return udao.selectWithRole(role_id);
	}
}
