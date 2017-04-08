package com.ruicai.evaluation.mapper;

import com.ruicai.evaluation.po.ExamAnswerDetail;
import com.ruicai.evaluation.po.ExamAnswerDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamAnswerDetailMapper {
    int countByExample(ExamAnswerDetailExample example);

    int deleteByExample(ExamAnswerDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExamAnswerDetail record);

    int insertSelective(ExamAnswerDetail record);

    List<ExamAnswerDetail> selectByExample(ExamAnswerDetailExample example);

    ExamAnswerDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExamAnswerDetail record, @Param("example") ExamAnswerDetailExample example);

    int updateByExample(@Param("record") ExamAnswerDetail record, @Param("example") ExamAnswerDetailExample example);

    int updateByPrimaryKeySelective(ExamAnswerDetail record);

    int updateByPrimaryKey(ExamAnswerDetail record);
}