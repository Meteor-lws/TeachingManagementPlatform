package com.ruicai.teaching.dao;

import com.ruicai.teaching.entity.EvaEvaluationDetail;
import com.ruicai.teaching.entity.EvaEvaluationDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaEvaluationDetailMapper {
    int countByExample(EvaEvaluationDetailExample example);

    int deleteByExample(EvaEvaluationDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(EvaEvaluationDetail record);

    int insertSelective(EvaEvaluationDetail record);

    List<EvaEvaluationDetail> selectByExample(EvaEvaluationDetailExample example);

    EvaEvaluationDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EvaEvaluationDetail record, @Param("example") EvaEvaluationDetailExample example);

    int updateByExample(@Param("record") EvaEvaluationDetail record, @Param("example") EvaEvaluationDetailExample example);

    int updateByPrimaryKeySelective(EvaEvaluationDetail record);

    int updateByPrimaryKey(EvaEvaluationDetail record);
}