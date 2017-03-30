package com.ruicai.edu.service.imp;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ruicai.edu.dao.StudentDao;
import com.ruicai.edu.entity.Student;
import com.ruicai.edu.getsqlsession.GetsqlSession;
import com.ruicai.edu.service.StudentService;

public class StudentServiceImp implements StudentService {
	private SqlSession sqlSession = null;
	private StudentDao studentDao = null;

	public List<Student> queryStudent() {// c查
		// TODO Auto-generated method stub
		try {
			sqlSession = GetsqlSession.getSqlsession();
			studentDao = sqlSession.getMapper(StudentDao.class);
			List<Student> studentlist = studentDao.selectAllStudent();
			// System.out.println(studentlist);
			return studentlist;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return null;
	}

	
	public int deleteStudent(String[] sid) {// 删除学生信息
		System.out.println("dele");
		try {
			sqlSession = GetsqlSession.getSqlsession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		studentDao = sqlSession.getMapper(StudentDao.class);
		System.out.println(studentDao + "123");
		int num = studentDao.deleteStudent(sid);//
		System.out.println(num + "影响数据条数");
		sqlSession.commit();
		sqlSession.close();

		return num;
	}

	public List<Student> showStudent(String s_name) {// 显示对应学生信息
		try {
			sqlSession = GetsqlSession.getSqlsession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		studentDao = sqlSession.getMapper(StudentDao.class);

		List<Student> studentlist = studentDao.selectStudentOne(s_name);
		// System.out.println(studentlist);

		sqlSession.close();

		return studentlist;
	}

	public int addStudent(Student student) {// 添加学生信息
		int num = 0;
		try {
			sqlSession=GetsqlSession.getSqlsession();
			studentDao=sqlSession.getMapper(StudentDao.class);
			num=studentDao.insertStudent(student);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sqlSession.rollback();
		}finally
		{
			sqlSession.close();
		}
		return num;
		
	}

	public int updateOneStudent(Student student) {// 更新对应学生信息
		int num = 0;
		try {
			sqlSession = GetsqlSession.getSqlsession();
			studentDao = sqlSession.getMapper(StudentDao.class);
			num=studentDao.updateStudent(student);
			System.out.println(studentDao.updateStudent(student) + "测试返回类型");
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sqlSession.rollback();
		}finally
		{
			sqlSession.close();
		}
		
		return num;
	}

	public List<String> validateAccount() {
		
		try {
			sqlSession=GetsqlSession.getSqlsession();
			studentDao=sqlSession.getMapper(StudentDao.class);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			sqlSession.close();
		}
		
		return null;
	}


	public List<Student> selectStudentsByTeacherid(String id) {
		try {
			sqlSession = GetsqlSession.getSqlsession();
			studentDao = sqlSession.getMapper(StudentDao.class);
			List<Student> studentlist = studentDao.selectStudentsByTeacherid(id);
			// System.out.println(studentlist);
			return studentlist;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return null;
	}

}
