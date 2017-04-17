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

    /**
     * 查询符合条件的教师的数量
     *
     * @param condition 教师查询条件
     * @return
     */
    public int selectTeaByConditionCount(TeacherCondition condition);

    /**
     * 查询符合条件的教师
     *
     * @param condition 条件
     * @param pageBean  分页bean
     * @return 分页util
     */
    public PageBean<EducationTeacher> selectTeaByCondition(TeacherCondition condition, PageBean<EducationTeacher> pageBean);

    public void saveOrUpdate(EducationTeacher teacher);

    public void saveTea(EducationTeacher teacher);

    public void updateTea(EducationTeacher teacher);

    List<EducationTeacher> selectAll();
}
