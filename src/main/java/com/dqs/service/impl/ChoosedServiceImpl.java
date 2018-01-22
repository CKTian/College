package com.dqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.ChoosedDao;
import com.dqs.entity.Choosed;
import com.dqs.service.ChoosedService;
import com.dqs.util.CreateUUID;
@Service
@Transactional
public class ChoosedServiceImpl implements ChoosedService {
	@Autowired
	private ChoosedDao cdao;
	
	public void insertOne(Choosed choosed) {
		// 生成编号
		String id = CreateUUID.getUUID();
		// 初始设置分数为 空 
		String score = "";
		choosed.setId(id);
		choosed.setScore(score);
//		// 查询登录者的所有的选课
//		List list = cdao.selectOwnCourse(choosed.getUser_id());
//		// 比较 所选的课 与 已选的课是否相同
//		for(int i = 0;i<list.size();i++){
//			if(choosed.getCourse_id().equals(list.get(i))){
//				//相同不进行操作
//			}else{
//				//不同插入数据库
//			}
//		}
		cdao.insertOne(choosed);
	}

}
