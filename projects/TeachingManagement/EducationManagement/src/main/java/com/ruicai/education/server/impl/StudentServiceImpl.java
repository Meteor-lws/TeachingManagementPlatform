package com.ruicai.education.server.impl;

import com.ruicai.education.mapper.education.EducationStudentMapper;
import com.ruicai.education.po.education.EducationStudent;
import com.ruicai.education.po.education.StudentCondition;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.po.education.SystemUser;
import com.ruicai.education.server.DictionaryServer;
import com.ruicai.education.server.StudentServer;
import com.ruicai.education.server.UserServer;
import com.ruicai.education.util.PageBean;
import com.ruicai.education.util.ReadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by wy on 2017/4/19.
 */
@Service
public class StudentServiceImpl implements StudentServer {
    @Autowired
    private EducationStudentMapper educationStudentMapper;
    @Autowired
    private DictionaryServer dictionaryServer;

    @Autowired
    private UserServer userServer;


    /**
     * 分页条件查询学生列表
     *
     * @param condition 条件
     * @param pageBean  分页bean
     * @return 分页BEAN
     */
    @Override
    public PageBean<EducationStudent> getStudentSelectByCondition(StudentCondition condition, PageBean<EducationStudent> pageBean) {
        /*List<EducationStudent> stuList = educationStudentMapper.selectStudentBycondition(condition);
        pageBean.setRows(stuList);
        pageBean.setTotal(educationStudentMapper.selectStudentByconditionCount());*/
        return pageBean;
    }

    /**
     * 添加或更新学生信息
     *
     * @param student 学生信息
     */
    @Override
    public void saveOrUpdateStudent(EducationStudent student) {
        if (student.getId() != null) {
            updateStudent(student);
        } else {
            saveStudent(student);
        }

    }

    /**
     * 添加学生信息
     *
     * @param student 学生信息
     */
    @Override
    public void saveStudent(EducationStudent student) {
        //可用状态的字典对象
        SystemDictionary enableDic = dictionaryServer.selectDicByValue(ReadProperties.read("enable"));
        //学生的字典对象
        SystemDictionary studentDic = dictionaryServer.selectDicByValue(ReadProperties.read("student"));
        SystemUser user = new SystemUser();
        user.setUserName(student.getStudentPhone());
        user.setUserStatus(enableDic.getId());
        user.setUserType(studentDic.getId());
        user.setUserPwd("123456");
        user.setUserNumber(UUID.randomUUID().toString().substring(0, 9));
        //保存用户表
        userServer.insertUser(user);
        student.setUserId(user.getId());
        //保存学生表
        educationStudentMapper.insert(student);
    }

    /**
     * 更新学生信息
     *
     * @param student
     */
    @Override
    public void updateStudent(EducationStudent student) {

    }

    @Override
    public List<SystemDictionary> getStudentStatu() {
        return dictionaryServer.selectDicByName(ReadProperties.read("studentStatu"));
    }


}
