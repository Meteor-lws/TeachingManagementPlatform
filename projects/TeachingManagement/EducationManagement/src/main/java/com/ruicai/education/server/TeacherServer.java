package com.ruicai.education.server;

import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.TeacherCondition;
import com.ruicai.education.util.PageBean;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 添加或修改教师    有id则修改   无id则添加
     *
     * @param teacher 教师信息
     */
    public void saveOrUpdate(EducationTeacher teacher);

    /**
     * 添加教师
     * @param teacher 教师信息
     */
    public void saveTea(EducationTeacher teacher);

    /**
     * 修改教师信息
     * @param teacher 教师信息
     */
    public void updateTea(EducationTeacher teacher);

    /**
     * 查询所有的教师
     *
     * @return 所有的教师列表
     */
    public List<EducationTeacher> selectAll();

    /**
     * 批量删除教师
     *
     * @param tids 教师id集合
     * @param uids 用户id集合
     */
    void deleteTeacherByBatch(List<String> tids, List<String> uids);

    public String uploadPic(HttpServletRequest request);

    /**
     * 查询所有讲师
     *
     * @return
     */
    public List<EducationTeacher> getAllMainTeacher();

    /**
     * 查询所有班主任
     *
     * @return
     */
    public List<EducationTeacher> getAllHeadTeacher();

    /**
     * 查询所有助教
     *
     * @return
     */
    public List<EducationTeacher> getAllAssiTeacher();
}
