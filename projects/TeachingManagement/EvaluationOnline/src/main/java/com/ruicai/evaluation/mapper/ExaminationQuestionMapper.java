package com.ruicai.evaluation.mapper;

import com.ruicai.evaluation.po.ExaminationQuestion;
import com.ruicai.evaluation.po.ExaminationQuestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationQuestionMapper {
    int countByExample(ExaminationQuestionExample example);

    int deleteByExample(ExaminationQuestionExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExaminationQuestion record);

    int insertSelective(ExaminationQuestion record);

    List<ExaminationQuestion> selectByExample(ExaminationQuestionExample example);

    ExaminationQuestion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExaminationQuestion record, @Param("example") ExaminationQuestionExample example);

    int updateByExample(@Param("record") ExaminationQuestion record, @Param("example") ExaminationQuestionExample example);

    int updateByPrimaryKeySelective(ExaminationQuestion record);

    int updateByPrimaryKey(ExaminationQuestion record);
}