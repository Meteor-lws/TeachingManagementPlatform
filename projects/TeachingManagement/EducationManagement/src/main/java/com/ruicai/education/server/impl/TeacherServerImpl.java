package com.ruicai.education.server.impl;

import com.ruicai.education.mapper.education.EducationTeacherMapper;
import com.ruicai.education.mapper.education.SystemDictionaryMapper;
import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.po.education.TeacherCondition;
import com.ruicai.education.server.TeacherServer;
import com.ruicai.education.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XM on 2017/4/13.
 */
@Service
public class TeacherServerImpl implements TeacherServer {

    @Autowired
    private EducationTeacherMapper educationTeacherMapper;

    @Override
    public int selectTeaByConditionCount(TeacherCondition condition) {
        return educationTeacherMapper.selectTeaByConditionCount(condition);
    }

    @Override
    public PageBean<EducationTeacher> selectTeaByCondition(TeacherCondition condition, PageBean<EducationTeacher> pageBean) {
        int total = selectTeaByConditionCount(condition);
        char[] page = condition.getPage();
        try {
            pageBean.setPage(Integer.parseInt(page[0] + ""));
        } catch (Exception e) {
            pageBean.setPage(1);
        }
        pageBean.setRowNums(condition.getRows());
        List<EducationTeacher> teacherList = educationTeacherMapper.selectTeaByCondition(condition);
        pageBean.setRows(teacherList);
        pageBean.setTotal(total);
        return pageBean;
    }
}
