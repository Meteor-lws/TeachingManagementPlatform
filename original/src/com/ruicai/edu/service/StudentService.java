package com.ruicai.edu.service;

import java.util.List;

import com.ruicai.edu.entity.Student;

public interface StudentService {
    public List<Student> queryStudent();//查询所有学生信息
    public abstract List<Student> selectStudentsByTeacherid(String id);// 根据老师ID查询学生
	public  List<Student> showStudent(String  s_name);//按姓名显示学生信息
	public int deleteStudent(String[] sid);//删除学生信息
	public int  addStudent(Student student);//添加学生信息
	public  int  updateOneStudent(Student student);//更新学生信息
	public List<String> validateAccount();
}
