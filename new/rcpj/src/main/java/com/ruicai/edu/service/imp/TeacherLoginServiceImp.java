package com.ruicai.edu.service.imp;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.ruicai.edu.dao.StudentDao;
import com.ruicai.edu.dao.TeacherDao;
import com.ruicai.edu.entity.Teacher;
import com.ruicai.edu.getsqlsession.GetsqlSession;
import com.ruicai.edu.service.TeacherLoginService;

public class TeacherLoginServiceImp implements TeacherLoginService{

	public Teacher login(Teacher teacher) {
		GetsqlSession getsqlSession = new GetsqlSession();
		Teacher teacher2 = null;
		SqlSession sqlSession = null;
		try {
			sqlSession=GetsqlSession.getSqlsession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
		teacher2 = teacherDao.login(teacher);
		if(sqlSession != null){
			getsqlSession.closeSqlsession();
		}
		return teacher2;
		
	}

//	public static void main(String[] args) {
//		Teacher teacher = new Teacher();
//		teacher.setT_account("56");
//		teacher.setT_pass("456");
//		System.out.println(new TeacherLoginServiceImp().login(teacher));
//	}
}
