package com.ruicai.evaluation.mapper;

import com.ruicai.evaluation.po.EducationWork;
import com.ruicai.evaluation.po.EducationWorkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EducationWorkMapper {
    int countByExample(EducationWorkExample example);

    int deleteByExample(EducationWorkExample example);

    int deleteByPrimaryKey(String id);

    int insert(EducationWork record);

    int insertSelective(EducationWork record);

    List<EducationWork> selectByExample(EducationWorkExample example);

    EducationWork selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EducationWork record, @Param("example") EducationWorkExample example);

    int updateByExample(@Param("record") EducationWork record, @Param("example") EducationWorkExample example);

    int updateByPrimaryKeySelective(EducationWork record);

    int updateByPrimaryKey(EducationWork record);
}