package com.dqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqs.dao.CourseDao;
import com.dqs.entity.Course;
import com.dqs.service.CourseService;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao cdao;
	public List<Course> selectList() {
		return cdao.selectList();
	}

}
