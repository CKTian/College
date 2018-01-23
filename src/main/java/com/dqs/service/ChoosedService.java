package com.dqs.service;

import java.util.List;

import com.dqs.entity.Choosed;

public interface ChoosedService {
	public void insertOne(Choosed choosed);
	public List selectOwnChoosed(String userId);
	public void deleteOne(Choosed choosed);
}
