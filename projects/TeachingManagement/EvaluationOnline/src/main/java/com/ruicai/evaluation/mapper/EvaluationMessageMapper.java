package com.ruicai.evaluation.mapper;

import com.ruicai.evaluation.po.EvaluationMessage;
import com.ruicai.evaluation.po.EvaluationMessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluationMessageMapper {
    int countByExample(EvaluationMessageExample example);

    int deleteByExample(EvaluationMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(EvaluationMessage record);

    int insertSelective(EvaluationMessage record);

    List<EvaluationMessage> selectByExample(EvaluationMessageExample example);

    EvaluationMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EvaluationMessage record, @Param("example") EvaluationMessageExample example);

    int updateByExample(@Param("record") EvaluationMessage record, @Param("example") EvaluationMessageExample example);

    int updateByPrimaryKeySelective(EvaluationMessage record);

    int updateByPrimaryKey(EvaluationMessage record);
}