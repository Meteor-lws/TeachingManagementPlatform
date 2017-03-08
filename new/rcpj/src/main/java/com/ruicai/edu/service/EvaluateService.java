package com.ruicai.edu.service;

import java.util.List;

import com.ruicai.edu.entity.Evaluate;

public interface EvaluateService {

	public abstract List<Evaluate> queryEvaluateList();
	public abstract List<Evaluate> queryEvaluateListByTeacherID(String id);
	
	public abstract String deleteEvaluate(String ids);
	
	public abstract String addEvaluate(Evaluate evaluate);
	
	public abstract String updateEvaluate(Evaluate evaluate);
}
