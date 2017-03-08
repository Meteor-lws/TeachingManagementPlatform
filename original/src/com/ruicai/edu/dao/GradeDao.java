package com.ruicai.edu.dao;

import java.util.List;
import java.util.Map;

import com.ruicai.edu.entity.Grade;
import com.ruicai.edu.entity.GradeInfo;
import com.ruicai.edu.entity.Relation;
import com.ruicai.edu.entity.Student;
import com.ruicai.edu.entity.Teacher;

public interface GradeDao {
	
	public int addGrade(Grade grade);
	
	public int addGradeAdvice(Grade grade);
	
	public int changeRelation(Relation relation);  
	
	//开启下一轮投票
	public int beginNext();
	
	//查询未评价学生
	public List selectNoPinJia();
	
	//查询每个教师月平均分
	public List selectAvg(String g_time);
	//查詢所有記錄
	public List<Grade> findgrade();
	//根据学生ID查找学生的评分
	public List<Grade> findgradeByStudentID(String sid,String tid);
	//根据学生ID查询建议
	public String findAdviceByStudentID(String sid,String tid);
	
	public List<GradeInfo> loadGradeInfoByTeacherId(String tid);
	
	public int getSumMark(String sid,String tid);
	
	//查詢所有記錄 BY 時間
	public List <Grade> selectBYtime(String g_time);
	//查詢所有記錄 BY 名字
	public List<Grade>selectBYname(String g_name);
	//查詢所有記錄BY 時間 和名字
	public List<Grade>selectAll(Map<String,Object> map);
}
