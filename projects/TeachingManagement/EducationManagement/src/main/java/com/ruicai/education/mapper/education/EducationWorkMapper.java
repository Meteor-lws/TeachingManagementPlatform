package com.ruicai.education.mapper.education;

import com.ruicai.education.po.education.EducationWork;
import com.ruicai.education.po.education.WorkCondition;

import java.util.List;

public interface EducationWorkMapper {

    int deleteByPrimaryKey(String id);

    int insert(EducationWork record);

    int insertSelective(EducationWork record);

    EducationWork selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EducationWork record);

    int updateByPrimaryKey(EducationWork record);

    List<EducationWork> selectWorkBycondition(WorkCondition condition);

    int selectWorkByconditionCount(WorkCondition condition);
}