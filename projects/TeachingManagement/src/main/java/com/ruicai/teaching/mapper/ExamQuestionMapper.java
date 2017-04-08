package com.ruicai.teaching.mapper;

import com.ruicai.teaching.po.ExamQuestion;
import com.ruicai.teaching.po.ExamQuestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamQuestionMapper {
    int countByExample(ExamQuestionExample example);

    int deleteByExample(ExamQuestionExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExamQuestion record);

    int insertSelective(ExamQuestion record);

    List<ExamQuestion> selectByExample(ExamQuestionExample example);

    ExamQuestion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExamQuestion record, @Param("example") ExamQuestionExample example);

    int updateByExample(@Param("record") ExamQuestion record, @Param("example") ExamQuestionExample example);

    int updateByPrimaryKeySelective(ExamQuestion record);

    int updateByPrimaryKey(ExamQuestion record);
}