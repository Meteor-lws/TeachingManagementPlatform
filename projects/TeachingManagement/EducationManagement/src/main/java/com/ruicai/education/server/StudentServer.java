package com.ruicai.education.server;

import com.ruicai.education.po.education.EducationStudent;
import com.ruicai.education.po.education.StudentCondition;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.util.PageBean;

import java.util.List;

/**
 * Created by wy on 2017/4/19.
 */
public interface StudentServer {
    /**
     * 条件分页查询学生
     *
     * @param condition 条件
     * @param pageBean  分页bean
     * @return 分页数据
     */
    public PageBean<EducationStudent> getStudentSelectByCondition(StudentCondition condition, PageBean<EducationStudent> pageBean);

    /**
     * 添加或更新学生信息
     *
     * @param student 学生信息
     */
    public void saveOrUpdateStudent(EducationStudent student);

    /**
     * 添加学生信息
     *
     * @param student 学生信息
     */
    public void saveStudent(EducationStudent student);

    /**
     * 更新学生信息
     *
     * @param student
     */
    public void updateStudent(EducationStudent student);

    public List<SystemDictionary> getStudentStatu();
}
