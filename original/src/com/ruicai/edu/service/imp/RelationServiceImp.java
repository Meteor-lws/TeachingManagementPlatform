package com.ruicai.edu.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ruicai.edu.dao.RelationDao;
import com.ruicai.edu.entity.Relation;
import com.ruicai.edu.getsqlsession.GetsqlSession;
import com.ruicai.edu.service.RelationService;

public class RelationServiceImp implements RelationService{

	private  SqlSession sqlSession;
	public List<Relation> findbyid(int r_sid) {
		try {
			sqlSession=GetsqlSession.getSqlsession();
			RelationDao relationDao= sqlSession.getMapper(RelationDao.class);
			List<Relation> list=new ArrayList<Relation>();
			list=relationDao.findbyid(r_sid);
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
