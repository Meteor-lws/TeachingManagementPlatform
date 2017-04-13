package com.ruicai.education.server;

import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.po.education.TeacherCondition;
import com.ruicai.education.util.PageBean;

import java.util.List;

/**
 * Created by XM on 2017/4/13.
 */
public interface TeacherServer {

    public int selectTeaByConditionCount(TeacherCondition condition);

    public PageBean<EducationTeacher> selectTeaByCondition(TeacherCondition condition,PageBean<EducationTeacher> pageBean);

}
