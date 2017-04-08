package com.ruicai.evaluation.dao;

import com.ruicai.evaluation.entity.EduWork;
import com.ruicai.evaluation.entity.EduWorkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EduWorkMapper {
    int countByExample(EduWorkExample example);

    int deleteByExample(EduWorkExample example);

    int deleteByPrimaryKey(String id);

    int insert(EduWork record);

    int insertSelective(EduWork record);

    List<EduWork> selectByExample(EduWorkExample example);

    EduWork selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EduWork record, @Param("example") EduWorkExample example);

    int updateByExample(@Param("record") EduWork record, @Param("example") EduWorkExample example);

    int updateByPrimaryKeySelective(EduWork record);

    int updateByPrimaryKey(EduWork record);
}