package com.ruicai.edu.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ruicai.edu.dao.GradeDao;
import com.ruicai.edu.entity.Grade;
import com.ruicai.edu.entity.GradeInfo;
import com.ruicai.edu.entity.Relation;
import com.ruicai.edu.getsqlsession.GetsqlSession;
import com.ruicai.edu.service.GradeService;

public class GradeServiceImp implements GradeService{
	
	private SqlSession session;
	private GradeDao  gradeDao;
	public void openSession(){
			try {
				session=GetsqlSession.getSqlsession();
				gradeDao =session.getMapper(GradeDao.class);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void closeSession(){
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public int addGrade(List list) {
		try {
			session=GetsqlSession.getSqlsession();
			GradeDao gradeDao =session.getMapper(GradeDao.class);
			int n=0;
			List<Grade> list1=list;
			for (Grade grade : list1) {
				gradeDao.addGrade(grade);
				n++;
			}
//			for(int i=0;i<list.size();i++){
//				gradeDao.addGrade((Grade)list.get(i));
//				n++;
//			}
			session.commit();
			return n;
		} catch (Exception e) {
			System.out.println("GradeSerciceImp的addGrade方法出错");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return 0;
	}


	public int addGradeAdvice(Grade grade,Relation relation) {
		try {
			session=GetsqlSession.getSqlsession();
			GradeDao gradeDao =session.getMapper(GradeDao.class);
			int i=gradeDao.addGradeAdvice(grade);
			System.out.println("建议进GradeServiceImp的addGradeAdvice方法了"+grade.getG_advice());	
			gradeDao.changeRelation(relation);
			session.commit();
			return i;
		} catch (Exception e) {
			System.out.println("GradeSerciceImp的addGradeService方法出错");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return 0;
	}


	//开始下一轮投票
	public int beginNext() {
		try {
			session = GetsqlSession.getSqlsession();
			GradeDao gradeDao = session.getMapper(GradeDao.class);
			int count = gradeDao.beginNext();
			System.out.println("进入beginNext()方法");
			session.commit();
			return count;
		} catch (IOException e) {
			System.out.println("beginNext()方法错误");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return 0;
	}


	//查询平均分，每月评分
	public List selectAvg(String g_time) {
		try {
			session = GetsqlSession.getSqlsession();
			GradeDao gradeDao = session.getMapper(GradeDao.class);
			List<Grade> teacherList =  gradeDao.selectAvg(g_time);
			System.out.println(teacherList.size());
			if(teacherList != null){
				for (Grade  grade: teacherList) {
					System.out.println("老师名字"+grade.getT_name());
					System.out.println("得分"+grade.getAvg());
				}
				return teacherList;
			}else{
				System.out.println("teacherList为空");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println("出现异常");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return null;
	}


	//查询每月没有评价的学生

	public List selectNoPinJia() {
		try {
			session = GetsqlSession.getSqlsession();
			GradeDao gradeDao = session.getMapper(GradeDao.class);
			List studentList = gradeDao.selectNoPinJia();
			if(studentList != null){
				return studentList;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}


	public List<Grade> findgrade() {
		try {
			session=GetsqlSession.getSqlsession();
			GradeDao gradeDao=session.getMapper(GradeDao.class);
			List<Grade> list=new ArrayList<Grade>();
			list=gradeDao.findgrade();
			if(list!=null)
			{
				return list;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			session.close();
		}
		return null;
	}


	public List<Grade> selectBYtime(String g_time) {
		try {
			session=GetsqlSession.getSqlsession();
			GradeDao gradeDao=session.getMapper(GradeDao.class);
			List<Grade>list=new ArrayList<Grade>();
			list=gradeDao.selectBYtime(g_time);
			if(list!=null)
			{
				return list;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			session.close();
		}
		return null;
	}


	public List<Grade> selectBYname(String g_name) {
		
		try {
			session=GetsqlSession.getSqlsession();
			GradeDao gradeDao=session.getMapper(GradeDao.class);
			List<Grade>list=new ArrayList<Grade>();
			list=gradeDao.selectBYname(g_name);
			if(list!=null)
			{
				return list;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			session.close();
		}
		
		return null;
	}


	public List<Grade> selectAll(Map<String,Object>map) {
		try {
			session=GetsqlSession.getSqlsession();
			GradeDao gradeDao=session.getMapper(GradeDao.class);
			List<Grade>list=new ArrayList<Grade>();
			list=gradeDao.selectAll(map);
			if(list!=null)
			{
				return list;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			session.close();
		}
		
		return null;
	}
	public int getSumMark(String sid,String tid){
		int sum=0;
		try {
			session=GetsqlSession.getSqlsession();
			GradeDao gradeDao=session.getMapper(GradeDao.class);
			sum=gradeDao.getSumMark(sid, tid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			session.close();
		}
		return sum;
	}
	public String findAdviceByStudentID(String sid,String tid){
		String advice="";
		try {
			session=GetsqlSession.getSqlsession();
			GradeDao gradeDao=session.getMapper(GradeDao.class);
			advice=gradeDao.findAdviceByStudentID(sid,tid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			session.close();
		}
		return advice;
	}
	
	public List<GradeInfo> loadGradeInfoByTeacherId(String tid) {
		List<GradeInfo> list=new ArrayList<GradeInfo>();
		
		try {
			session=GetsqlSession.getSqlsession();
			GradeDao gradeDao=session.getMapper(GradeDao.class);
			list=gradeDao.loadGradeInfoByTeacherId(tid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			session.close();
		}
		return list;
	}
	public List<Grade> findgradeByStudentID(String sid,String tid) {
		try {
			session=GetsqlSession.getSqlsession();
			GradeDao gradeDao=session.getMapper(GradeDao.class);
			List<Grade>list=new ArrayList<Grade>();
			list=gradeDao.findgradeByStudentID( sid, tid);
			if(list!=null)
			{
				return list;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			session.close();
		}
		return null;
	}

	

//
//	public int changeRelation(Relation relation) {
//		try {
//			session=GetsqlSession.getSqlsession();
//			GradeDao gradeDao =session.getMapper(GradeDao.class);
//			int i=gradeDao.changeRelation(relation);
//			return i;
//		} catch (Exception e) {
//			System.out.println("GradeSerciceImp的changeRelation方法出错");
//			e.printStackTrace();
//		}
//		return 0;
//	}

	
	
	

}
