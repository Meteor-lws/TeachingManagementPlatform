package com.ruicai.education.dao;

import com.ruicai.education.entity.ExamAnswer;
import com.ruicai.education.entity.ExamAnswerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamAnswerMapper {
    int countByExample(ExamAnswerExample example);

    int deleteByExample(ExamAnswerExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExamAnswer record);

    int insertSelective(ExamAnswer record);

    List<ExamAnswer> selectByExample(ExamAnswerExample example);

    ExamAnswer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExamAnswer record, @Param("example") ExamAnswerExample example);

    int updateByExample(@Param("record") ExamAnswer record, @Param("example") ExamAnswerExample example);

    int updateByPrimaryKeySelective(ExamAnswer record);

    int updateByPrimaryKey(ExamAnswer record);
}