package com.ruicai.edu.dao;

import java.util.List;
import java.util.Map;

import com.ruicai.edu.entity.Teacher;

public interface TeacherDao {
    public abstract int getSumTeachersCount();
    public abstract int checkTeacherLoginName(String loginName) ;
    public abstract int addTeacher(Teacher teacher) ;
    public abstract int queryNextID();
    public abstract Teacher getTeacherByID(int id);
    public abstract List<Teacher> loadTeachersByStudentID(int id);
    public abstract int updateTeacher(Teacher teacher);
    public abstract int deleteTeacher(String[] ids);
    public abstract Teacher login(Teacher teacher);
    public abstract List<Teacher> loadTeachersByFilter(Map<String, String> map);
    public abstract List<Teacher> loadTeachersByPages(Map<String, Integer> map);
    public abstract List<Teacher> loadAllteachersForSelect();
    
    
}
