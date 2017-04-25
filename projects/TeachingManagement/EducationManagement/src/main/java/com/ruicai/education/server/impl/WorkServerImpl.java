package com.ruicai.education.server.impl;

import com.ruicai.education.mapper.education.EducationWorkMapper;
import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.EducationWork;
import com.ruicai.education.po.education.WorkCondition;
import com.ruicai.education.server.TeacherServer;
import com.ruicai.education.server.WorkServer;
import com.ruicai.education.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wy on 2017/4/24.
 */
@Service
public class WorkServerImpl implements WorkServer {

    @Autowired
    private TeacherServer teacherServer;

    @Autowired
    private EducationWorkMapper educationWorkMapper;

    @Override
    public List<EducationTeacher> selectAllTeacher() {
        return teacherServer.selectAll();
    }

    @Override
    public PageBean<EducationWork> getResByCondition(WorkCondition condition, PageBean<EducationWork> pageBean) {
        condition.setStartNum((condition.getPage() - 1) * condition.getRows());
        condition.setEndNum(condition.getPage() * condition.getRows() + 1);
        List<EducationWork> works = educationWorkMapper.selectWorkBycondition(condition);
        pageBean.setRows(works);
        int total = getResByConditionCount(condition);
        pageBean.setTotal(total);
        return pageBean;
    }

    @Override
    public int getResByConditionCount(WorkCondition condition) {
        return educationWorkMapper.selectWorkByconditionCount(condition);
    }

    @Override
    public void deleteResByBatch(List<String> rids) {
        for (int i = 0; i < rids.size(); i++) {
            educationWorkMapper.deleteByPrimaryKey(rids.get(i));
        }
    }

    @Override
    public void deleteWeeByBatch(List<String> idList) {
        for (int i = 0; i < idList.size(); i++) {
            educationWorkMapper.deleteByPrimaryKey(idList.get(i));
        }
    }

    @Override
    public PageBean<EducationWork> selectWeeByCondition(WorkCondition condition) {
        condition.setStartNum((condition.getPage() - 1) * condition.getRows());
        condition.setEndNum(condition.getPage() * condition.getRows() + 1);
        List<EducationWork> works = educationWorkMapper.selectWorkBycondition(condition);
        PageBean<EducationWork> pageBean = new PageBean<>();
        pageBean.setRows(works);
        int total = getResByConditionCount(condition);
        pageBean.setTotal(total);
        return pageBean;
    }


}
