package com.ruicai.edu.service.imp;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ruicai.edu.dao.PinJiaDAO;
import com.ruicai.edu.entity.Relation;
import com.ruicai.edu.getsqlsession.GetsqlSession;
import com.ruicai.edu.service.PinJiaService;

public class PinjiaServiceImp implements PinJiaService{
	

	public List<Relation> select(int s_id) {//根据学生id查出老师id
		SqlSession session = null;
		try {
			session=GetsqlSession.getSqlsession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PinJiaDAO pinJiaDAO= session.getMapper(PinJiaDAO.class);
		List<Relation> list=pinJiaDAO.select(s_id);
		session.close();
		return list;
	}
	
  public static void main(String[] args) {
	 System.out.println(new PinjiaServiceImp().select(25));
}
}
