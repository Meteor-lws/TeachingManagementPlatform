package com.ruicai.edu.service.imp;

/*
 * 接口实现类
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ruicai.edu.dao.BBS_Dao;
import com.ruicai.edu.entity.BBS;
import com.ruicai.edu.entity.Teacher;
import com.ruicai.edu.getsqlsession.GetsqlSession;
import com.ruicai.edu.service.BBS_Service;


public class BBS_Serviceipm implements BBS_Service{

	/*
	 * 查询留言
	 * 
	 */
	public List<BBS> liuyanAll() {
		SqlSession  sqlSession =null;
		try {
			sqlSession=GetsqlSession.getSqlsession();
			BBS_Dao bbsDao=sqlSession.getMapper(BBS_Dao.class);
			List list=bbsDao.liuyanAll();
			return list;
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally
		{
			if(sqlSession!=null)
			{
			sqlSession.close();
			}
		}
		return null;
	}

	
	/*
	 * 删除方法
	 * 
	 */
	public int liuyanDelete(String ids) {
		SqlSession  sqlSession =null;
		try {
			sqlSession=GetsqlSession.getSqlsession();
			String[]delete=ids.split(",");
			BBS_Dao bbsDao=sqlSession.getMapper(BBS_Dao.class);
			for(int i=0;i<delete.length;i++)//循环删除
			{
				int k= Integer.parseInt(delete[i]);
				bbsDao.liuyanDelete(k);
				sqlSession.commit();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			if(sqlSession !=null)
			{
				sqlSession.close();
			}
		}
		return 1;	
	}

    /*
     *
     *查询指定留言 
     */
	public List<BBS> liuyanFind(String b_ly) {
		// TODO Auto-generated method stub
		SqlSession sqlSession=null;
		List<BBS>list=null;
		try {
			sqlSession=GetsqlSession.getSqlsession();
			BBS_Dao bbsDao=sqlSession.getMapper(BBS_Dao.class);
		    list=bbsDao.liuyanFind(b_ly);
		} catch (IOException e) {
			e.printStackTrace();
		}finally
		{
			if(sqlSession!=null)
			{
				sqlSession.close();
			}
		}
		return list;
	}

	/*
	 * 
	 * 在前台显示老师数据
	 */
	public List<Teacher> liuyanShow(int t_id) {
		  SqlSession sqlSession=null;
		  List<Teacher>tlist=null;
		try {
			  sqlSession=GetsqlSession.getSqlsession();
			  BBS_Dao bbsDao=sqlSession.getMapper(BBS_Dao.class);
			  tlist=bbsDao.liuyanShow(t_id);
		} catch (IOException e) {
			e.printStackTrace();
		}finally
		{
			if(sqlSession!=null)
			{
				sqlSession.close();
			}
		}
		return tlist;
	}

/*
 * 添加留言
 * 
 */
	public int liuyanAdd(String text,String b_time,int s_id,int t_id) {
		SqlSession sqlSession=null;
		try {
			sqlSession=GetsqlSession.getSqlsession();
			BBS_Dao bbsDao=sqlSession.getMapper(BBS_Dao.class);
			Map<String,Object>map=new HashMap();
			map.put("text",text);
			map.put("b_time",b_time);
			map.put("s_id",s_id);
			map.put("t_id",t_id);
			bbsDao.liuyanAdd(map);
			sqlSession.commit();
		} catch (IOException e) {
			System.out.println("出错");
			sqlSession.rollback();
		}finally{
			if(sqlSession!=null)
			{
				sqlSession.close();
			}
			
		}
		
		return 1;
	}

/*
 * 显示留言
 * 
 */
	public List<BBS> liuyanOnclick(int t_id) {
		
		  SqlSession sqlSession=null;
		  List<BBS>list=null;
		try {
			  sqlSession=GetsqlSession.getSqlsession();
			  BBS_Dao bbsDao=sqlSession.getMapper(BBS_Dao.class);
			   list=bbsDao.liuyanOnclick(t_id);
		} catch (IOException e) {
			e.printStackTrace();
		}finally
		{
			if(sqlSession!=null)
			{
				sqlSession.close();
			}
		}
		return list;
	}

}
