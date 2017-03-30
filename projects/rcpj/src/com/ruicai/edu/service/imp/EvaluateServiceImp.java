package com.ruicai.edu.service.imp;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ruicai.edu.dao.EvaluateDao;
import com.ruicai.edu.dao.TeacherDao;
import com.ruicai.edu.entity.Evaluate;
import com.ruicai.edu.getsqlsession.GetsqlSession;

import com.ruicai.edu.service.EvaluateService;

public class EvaluateServiceImp implements EvaluateService{
	SqlSession session;
    EvaluateDao evaluateDao;
    String returnString;
    
	/**
	 * 查看所有的评价信息
	 * return List<Evaluate>
	 */
	public List<Evaluate> queryEvaluateList() {
		try {
			session=GetsqlSession.getSqlsession();
			evaluateDao=session.getMapper(EvaluateDao.class);
			return evaluateDao.queryEvaluateList();
		} catch (Exception e) {
			System.out.println("select error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	/**
	 * 删除评价项信息
	 * return String 
	 */
	public String deleteEvaluate(String ids) {
		System.out.println("进行删除..");
		returnString ="error";
		ids = ids.substring(0,ids.length()-1);
		String[] id = ids.split(",");
		
		try {
			session=GetsqlSession.getSqlsession();
			evaluateDao=session.getMapper(EvaluateDao.class);
			System.out.println(id);
			evaluateDao.deleteEvaluate(id);
			session.commit();
			System.out.println("delete success");
			returnString ="isOK";
		} catch (IOException e) { 
			session.rollback();
			System.out.println("删除失败");
			e.printStackTrace();
		} finally{
			session.close();
		}
		
		return returnString;
	}
	
	/**
	 * 添加评价项信息
	 * return String
	 */
	public String addEvaluate(Evaluate evaluate) {
		returnString = "error";
		try {
			session = GetsqlSession.getSqlsession();
			evaluateDao = session.getMapper(EvaluateDao.class);
			evaluateDao.addEvaluate(evaluate);
			session.commit();
			returnString = "isOk";
		} catch (IOException e) {
			System.out.println("添加评价项信息失败");
			e.printStackTrace();
		} finally{
			session.close();
		}
		return returnString;
	}
	
	/**
	 * 修改评价项信息
	 * return String 
	 */
	public String updateEvaluate(Evaluate evaluate) {
		returnString = "error";
		try {
			session = GetsqlSession.getSqlsession();
			evaluateDao = session.getMapper(EvaluateDao.class);
			evaluateDao.updateEvaluate(evaluate);
			session.commit();
			System.out.println("update success");
			returnString = "isOk";
		} catch (IOException e) {
			System.out.println("update error");
			e.printStackTrace();
		} finally{
			session.close();
		}
		return returnString;
	}
	public List<Evaluate> queryEvaluateListByTeacherID(String id) {
		
		try {
			session=GetsqlSession.getSqlsession();
			evaluateDao=session.getMapper(EvaluateDao.class);
			return evaluateDao.queryEvaluateListByTeacherID(id);
		} catch (Exception e) {
			System.out.println("select error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}

}
