package com.ruicai.examination.service;

import com.ruicai.examination.po.education.EducationTeacher;
import com.ruicai.examination.po.examination.ExaminationArrangement;
import com.ruicai.examination.po.system.SystemDictionary;
import com.ruicai.examination.vo.examination.ClassTree;
import com.ruicai.examination.vo.examination.ManagementDatagrid;

import java.util.List;

/**
 * Created by 朱高 on 2017/4/10.
 */
public interface ExaminationManagementService {
    /**
     * 添加考试安排
     *
     * @param examinationManagement
     */
    void addExaminationManagement(ExaminationArrangement examinationManagement);

    /**
     * 查询考试安排，分页查询
     * @return
     */
    //Management findAllManagement(ManagementDatagrid managementDatagrid);

    /**
     * 分页查询监考老师信息
     * @param managementDatagrid
     * @return
     */
    //EducationTeacher findTeacher(ManagementDatagrid managementDatagrid);

    /**
     * 分页查询考试班级
     * @param managementDatagrid
     * @return
     */
    //EducationClass findClass(ManagementDatagrid managementDatagrid);

    /**
     * 分页查询考试安排
     *
     * @param managementDatagrid
     * @return
     */
    ManagementDatagrid findManagementDatagrid(ManagementDatagrid managementDatagrid);

    /**
     * 查询所有的考试阶段
     * @return
     */
    List<SystemDictionary> findDicTypeName(String dicTypeName);

    /**
     * 查询监考老师的姓名和ID
     * @return
     */
    List<EducationTeacher> findTeacherName();

    /**
     * 查询所有班级名字
     * @return
     */
    List<ClassTree> findClassName();

    List<ClassTree> findClassMessageByClassType(String classType);

    void insert(ExaminationArrangement examinationArrangement);

    /**
     * 更新考试安排
     * @param examinationArrangement
     */
    void updateExaminationArrangementMessage(ExaminationArrangement examinationArrangement);

    /**
     * 批量删除考试信息
     * @param ids
     */
    void deleteExaminationArrangement(String ids);
}
