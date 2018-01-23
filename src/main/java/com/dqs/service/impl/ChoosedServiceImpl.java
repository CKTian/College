package com.dqs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	// 增加一条选课
	public void insertOne(Choosed choosed) {
		// 生成编号
		String id = CreateUUID.getUUID();
		System.out.println(id);
		// 初始设置分数为 空 
		String score = "";
		choosed.setId(id);
		choosed.setScore(score);
		// 查询登录者的所有的选课
		List list =cdao.selectOwnCourse(choosed.getUser_id());
		System.out.println(list);
		// 比较 所选的课 与 已选的课是否相同
		boolean isHadCourse = false;
		if(list.size()==0){
			cdao.insertOne(choosed);
		} else {
			for(int i = 0;i<list.size();i++){
				//获取课程号
				Choosed getGhoosed =  (Choosed) list.get(i);
				if(choosed.getCourse_id().equals(getGhoosed.getCourse_id())){
					//相同不进行操作
					isHadCourse = true;
					break;
				}
			}
			if (!isHadCourse) {
				//不同插入数据库
				cdao.insertOne(choosed);
			}
		}
	}
	// 查询登录者的所有选课
	public List selectOwnChoosed(String userId) {
		List list = cdao.selectOwnChoosed(userId);
		return list;
	}
	// 删除选课信息
	public void deleteOne(Choosed choosed) {
		cdao.deleteOne(choosed);
	}

}
