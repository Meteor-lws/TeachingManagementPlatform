package com.ruicai.education.server;

import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.EducationWork;
import com.ruicai.education.po.education.WorkCondition;
import com.ruicai.education.util.PageBean;

import java.util.List;

/**
 * Created by wy on 2017/4/24.
 */
public interface WorkServer {

    /**
     * 获取全部教师
     *
     * @return
     */
    public List<EducationTeacher> selectAllTeacher();

    /**
     * 条件分页查询
     *
     * @param condition 条件
     * @param pageBean
     * @return
     */
    public PageBean<EducationWork> getResByCondition(WorkCondition condition, PageBean<EducationWork> pageBean);

    /**
     * 查询满足条件的课件有多少
     *
     * @param condition
     * @return
     */
    public int getResByConditionCount(WorkCondition condition);

    public void deleteResByBatch(List<String> rids);

    public void deleteWeeByBatch(List<String> idList);

    public PageBean<EducationWork> selectWeeByCondition(WorkCondition condition);
}
