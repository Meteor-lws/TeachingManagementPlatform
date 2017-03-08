package com.ruicai.edu.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ruicai.edu.dao.ClassesDao;
import com.ruicai.edu.entity.Classes;
import com.ruicai.edu.entity.Teacher;
import com.ruicai.edu.getsqlsession.GetsqlSession;
import com.ruicai.edu.service.ClassesService;

public class ClasserServiceImp  implements ClassesService{

	SqlSession sqlSession;
	public List<Classes> selectClass() {
		try {
			sqlSession=GetsqlSession.getSqlsession();
			ClassesDao classesDao= sqlSession.getMapper(ClassesDao.class);
			List<Classes> list= new ArrayList<Classes>();
			list=classesDao.selectClass();
			if(list!=null)
			{
			   return list;	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return null;
	}
	public int addClass(Classes classes) {
		try {
			sqlSession=GetsqlSession.getSqlsession();
			ClassesDao classesDao=sqlSession.getMapper(ClassesDao.class);
			int count=classesDao.addClass(classes);
			sqlSession.commit();
			if(count!=0)
			{
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally
		{
			sqlSession.close();
		}
		return 0;
	}
	public int updateClass(Classes classes) {
		try {
			sqlSession=GetsqlSession.getSqlsession();
			ClassesDao classesDao=sqlSession.getMapper(ClassesDao.class);
			int count=classesDao.updateClass(classes);
			sqlSession.commit();
			if(count!=0)
			{
				return count;
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return 0;
	}
	public List<Classes> fidnall() {
		try {
			sqlSession=GetsqlSession.getSqlsession();
			ClassesDao classesDao= sqlSession.getMapper(ClassesDao.class);
			List<Classes> list= new ArrayList<Classes>();
			list=classesDao.findall();
			if(list!=null)
			{
			   return list;	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return null;
	}
	public List<Classes> findbyid(int cid) {
		try {
			sqlSession=GetsqlSession.getSqlsession();
			ClassesDao classesDao=sqlSession.getMapper(ClassesDao.class);
			List<Classes> list=new ArrayList<Classes>();
			list=classesDao.findbyid(cid);
			if(list!=null)
			{
				return list;
			}
		} catch (IOException e) {
			  
			e.printStackTrace();
		}finally
		{
			sqlSession.close();
		}
		return null;
	}
	public List<Teacher> findteacher() {
		  try {
			sqlSession=GetsqlSession.getSqlsession();
			ClassesDao classesDao=sqlSession.getMapper(ClassesDao.class);
			List<Teacher> list=new ArrayList<Teacher>();
			list=classesDao.findteacher();
			if(list!=null)
			{
				return list;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			sqlSession.close();
		}
		return null;
	}
   
	
}
