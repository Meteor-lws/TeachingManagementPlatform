package com.ruicai.edu.dao;

import java.util.List;

import com.ruicai.edu.entity.Student;

public interface StudentDao {
	public abstract List<Student> selectAllStudent();// 查询所有学生信息
	
	public abstract List<Student> selectStudentsByTeacherid(String id);// 根据老师ID查询学生

	public abstract List<Student> selectStudentOne(String s_name);// 查询对应学生信息

	public abstract int updateStudent(Student student);// 更新学生信息

	public abstract int deleteStudent(String[] sid);// 删除学生信息

	public abstract int insertStudent(Student student);// 插入学生信息

	public abstract int selectStudentAccount(String saccount);// 查询是否账号已经存在

	public abstract Student login(Student student);
	
	public abstract List<String> validateAccount();

}
