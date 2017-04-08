package com.ruicai.evaluation.mapper;

import com.ruicai.evaluation.po.EduStudent;
import com.ruicai.evaluation.po.EduStudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EduStudentMapper {
    int countByExample(EduStudentExample example);

    int deleteByExample(EduStudentExample example);

    int deleteByPrimaryKey(String id);

    int insert(EduStudent record);

    int insertSelective(EduStudent record);

    List<EduStudent> selectByExample(EduStudentExample example);

    EduStudent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EduStudent record, @Param("example") EduStudentExample example);

    int updateByExample(@Param("record") EduStudent record, @Param("example") EduStudentExample example);

    int updateByPrimaryKeySelective(EduStudent record);

    int updateByPrimaryKey(EduStudent record);
}