package com.dqs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dqs.entity.Student;
import com.dqs.entity.User;

/**
 * 
 * 用户信息基本选项
 * @author 王天博
 * 2018年1月25日
 */
public class UserBasicInfo {
	private String name;  // 键名
	private String value; // 值
	private String type;  // 展示类型
	public UserBasicInfo(String name, String value) {
		super();
		this.name = name;
		this.value = value;
		this.type = "message";
	}
	public UserBasicInfo(String name, String value, String type) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	// set学生 set老师  set 超级管理员
	/**
	 * 
	 * @Title: parseStuInfo  
	 * @Description: 解析学生的个人信息
	 * @author 王天博
	 * @param @param loginMap
	 * @param @param basicMap
	 * @param @return      
	 * @return List<UserBasicInfo>
	 */
	public static List<UserBasicInfo> parseStuInfo(Map loginMap,Map basicMap){
		List list = new ArrayList();
		User userinfo = (User) loginMap.get("userinfo");
		Student student = (Student) basicMap.get("student");
		// 将学生的 所有信息存放在当前类创建的对象里
		UserBasicInfo name = new UserBasicInfo("姓名", student.getName());
		UserBasicInfo account = new UserBasicInfo("用户名", userinfo.getAccount());
		String sex = "";
		if(userinfo.getGender() == 0 ){
			sex = "男";
		}else if(userinfo.getGender() == 1){
			sex = "女";
		}
		UserBasicInfo gender = new UserBasicInfo("性别", sex);
		UserBasicInfo team_name = new UserBasicInfo("班级",(String)basicMap.get("team_name"));
		UserBasicInfo tel = new UserBasicInfo("电话", student.getTel());
		UserBasicInfo reward = new UserBasicInfo("奖惩", student.getReward());
		UserBasicInfo point = new UserBasicInfo("学分", student.getPoint());
		UserBasicInfo image = new UserBasicInfo("", "#icon-nvtongxue", "picture");
		list.add(image);
		list.add(account);
		list.add(name);
		list.add(gender);
		list.add(team_name);
		list.add(tel);
		list.add(reward);
		list.add(point);
		return list;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
