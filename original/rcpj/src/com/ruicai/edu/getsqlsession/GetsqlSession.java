package com.ruicai.edu.getsqlsession;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetsqlSession {

private static SqlSession sqlSession = null;
	
	public  static SqlSession getSqlsession() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
}
	public static void closeSqlsession(){
		if(sqlSession != null){
			sqlSession.close();
		}
	}
	public static void main(String[] args) {
		try {
			System.out.println(getSqlsession());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}