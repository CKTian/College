package com.dqs.dao;

import java.util.List;

import com.dqs.dto.ShowAllTeacherInfoDto;
import com.dqs.entity.User;

public interface UserDao {
	public void insertOne(User user);
	public void deleteOne(String userId);
	public void updateOne(String account);
	public void updateOneAccountGender(ShowAllTeacherInfoDto toUpdateInfo);
	public User selectOne(String account);
	public List<User> selectList();
	public List<User> selectWithRole(String role_id);
	public void updateOnePwd(User user);
	public void updateGender(User user);
	public Integer checkAccount(String accoount);
}
