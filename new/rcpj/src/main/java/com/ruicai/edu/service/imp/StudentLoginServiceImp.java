package com.ruicai.edu.service.imp;


import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.ruicai.edu.dao.StudentDao;
import com.ruicai.edu.entity.Student;
import com.ruicai.edu.getsqlsession.GetsqlSession;
import com.ruicai.edu.service.StudentLoginService;

public class StudentLoginServiceImp implements StudentLoginService {

	public Student login(Student student) {
		Student student2 = null;
		GetsqlSession getsqlSession = new GetsqlSession();
		SqlSession sqlSession = null;
		try {
		  sqlSession = getsqlSession.getSqlsession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		student2 = studentDao.login(student);
		if(sqlSession != null){
			getsqlSession.closeSqlsession();
		}
		
		return student2;
	}
	public static void main(String[] args) {
		Student student = new Student();
		student.setS_account("123");
		student.setS_pass("123");
		Student student1 = new StudentLoginServiceImp().login(student);
		if(student1 != null){
			System.out.println("测试成功");
		}
	}
}
