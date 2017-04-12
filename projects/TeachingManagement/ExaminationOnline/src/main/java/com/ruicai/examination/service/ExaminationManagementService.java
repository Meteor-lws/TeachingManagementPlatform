package com.ruicai.examination.service;

import com.ruicai.examination.po.examination.ExaminationArrangement;
import com.ruicai.examination.vo.examination.ManagementDatagrid;

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
}
