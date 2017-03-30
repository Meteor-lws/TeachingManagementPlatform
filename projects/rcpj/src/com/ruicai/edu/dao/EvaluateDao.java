package com.ruicai.edu.dao;

import java.util.List;

import com.ruicai.edu.entity.Evaluate;

public interface EvaluateDao {

	public abstract List<Evaluate> queryEvaluateList();
	public abstract List<Evaluate> queryEvaluateListByTeacherID(String id);
	
	public abstract int deleteEvaluate(String[] ids);
	
	public abstract int addEvaluate(Evaluate evaluate) ;
	
	public abstract int updateEvaluate(Evaluate evaluate);
}
