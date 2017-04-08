package com.ruicai.teaching.mapper;

import com.ruicai.teaching.po.EvaEvaluation;
import com.ruicai.teaching.po.EvaEvaluationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaEvaluationMapper {
    int countByExample(EvaEvaluationExample example);

    int deleteByExample(EvaEvaluationExample example);

    int deleteByPrimaryKey(String id);

    int insert(EvaEvaluation record);

    int insertSelective(EvaEvaluation record);

    List<EvaEvaluation> selectByExample(EvaEvaluationExample example);

    EvaEvaluation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EvaEvaluation record, @Param("example") EvaEvaluationExample example);

    int updateByExample(@Param("record") EvaEvaluation record, @Param("example") EvaEvaluationExample example);

    int updateByPrimaryKeySelective(EvaEvaluation record);

    int updateByPrimaryKey(EvaEvaluation record);
}