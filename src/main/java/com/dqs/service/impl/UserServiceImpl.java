package com.dqs.service.impl;

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

}
