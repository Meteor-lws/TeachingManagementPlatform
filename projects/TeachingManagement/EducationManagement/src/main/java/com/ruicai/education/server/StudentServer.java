package com.ruicai.education.server;

import com.ruicai.education.po.education.EducationStudent;
import com.ruicai.education.po.education.StudentCondition;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.po.education.SystemRole;
import com.ruicai.education.util.PageBean;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 查询专业
     *
     * @return
     */
    public List<SystemDictionary> getStudentSpeciality();

    /**
     * 查询性别
     *
     * @return 性别列表
     */
    public List<SystemDictionary> getSexRedio();

    /**
     * 查询保险单选按钮
     *
     * @return
     */
    public List<SystemDictionary> getInsurance();

    /**
     * 上传学生图片
     *
     * @return 学生图片在文件服务器上的路径
     */
    public String UpLoadStudentPic(HttpServletRequest request);

    /**
     * 学历
     *
     * @return
     */
    public List<SystemDictionary> getEducation();

    /**
     * 所有的学生角色
     *
     * @return
     */
    public List<SystemRole> getAllStudentRole();

    /**
     * 该学生具有的角色
     *
     * @param userId
     * @return
     */
    public List<SystemRole> getStudentRole(String userId);

    public void deleteByBatch(List<String> studentIds, List<String> userIds);
}
