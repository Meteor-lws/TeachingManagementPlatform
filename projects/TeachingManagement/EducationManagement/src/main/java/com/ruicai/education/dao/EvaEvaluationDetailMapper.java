package com.ruicai.education.dao;

import com.ruicai.education.entity.EvaEvaluationDetail;
import com.ruicai.education.entity.EvaEvaluationDetailExample;
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