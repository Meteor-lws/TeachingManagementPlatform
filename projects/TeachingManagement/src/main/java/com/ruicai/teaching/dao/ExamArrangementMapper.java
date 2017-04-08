package com.ruicai.teaching.dao;

import com.ruicai.teaching.entity.ExamArrangement;
import com.ruicai.teaching.entity.ExamArrangementExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamArrangementMapper {
    int countByExample(ExamArrangementExample example);

    int deleteByExample(ExamArrangementExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExamArrangement record);

    int insertSelective(ExamArrangement record);

    List<ExamArrangement> selectByExample(ExamArrangementExample example);

    ExamArrangement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExamArrangement record, @Param("example") ExamArrangementExample example);

    int updateByExample(@Param("record") ExamArrangement record, @Param("example") ExamArrangementExample example);

    int updateByPrimaryKeySelective(ExamArrangement record);

    int updateByPrimaryKey(ExamArrangement record);
}