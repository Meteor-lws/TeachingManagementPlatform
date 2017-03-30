package com.ruicai.edu.service;

import java.util.List;
import java.util.Map;

import com.ruicai.edu.entity.Grade;
import com.ruicai.edu.entity.GradeInfo;
import com.ruicai.edu.entity.Relation;

public interface GradeService {

	
	public int addGrade(List list);
	
	public int addGradeAdvice(Grade grade,Relation relation);
	
	public int beginNext();
	
	public List selectNoPinJia();
	
	public List selectAvg(String g_time);
	
	public List<Grade> findgrade();
	
	public List<Grade> selectBYtime(String g_time);
	
	public List<Grade> selectBYname(String g_name);
	
	public List<Grade> selectAll(Map<String,Object>map);
	
	public List<Grade> findgradeByStudentID(String sid,String tid);
	public int getSumMark(String sid,String tid);
	//根据学生ID查询建议
	public String findAdviceByStudentID(String sid,String tid);
	
	public List<GradeInfo> loadGradeInfoByTeacherId(String tid);
	
}
