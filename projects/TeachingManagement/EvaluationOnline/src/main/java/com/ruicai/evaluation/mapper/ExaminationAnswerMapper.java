package com.ruicai.evaluation.mapper;

import com.ruicai.evaluation.po.ExaminationAnswer;
import com.ruicai.evaluation.po.ExaminationAnswerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationAnswerMapper {
    int countByExample(ExaminationAnswerExample example);

    int deleteByExample(ExaminationAnswerExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExaminationAnswer record);

    int insertSelective(ExaminationAnswer record);

    List<ExaminationAnswer> selectByExample(ExaminationAnswerExample example);

    ExaminationAnswer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExaminationAnswer record, @Param("example") ExaminationAnswerExample example);

    int updateByExample(@Param("record") ExaminationAnswer record, @Param("example") ExaminationAnswerExample example);

    int updateByPrimaryKeySelective(ExaminationAnswer record);

    int updateByPrimaryKey(ExaminationAnswer record);
}