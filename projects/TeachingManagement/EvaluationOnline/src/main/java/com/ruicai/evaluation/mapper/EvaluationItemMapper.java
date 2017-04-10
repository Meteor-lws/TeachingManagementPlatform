package com.ruicai.evaluation.mapper;

import com.ruicai.evaluation.po.EvaluationItem;
import com.ruicai.evaluation.po.EvaluationItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluationItemMapper {
    int countByExample(EvaluationItemExample example);

    int deleteByExample(EvaluationItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(EvaluationItem record);

    int insertSelective(EvaluationItem record);

    List<EvaluationItem> selectByExample(EvaluationItemExample example);

    EvaluationItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EvaluationItem record, @Param("example") EvaluationItemExample example);

    int updateByExample(@Param("record") EvaluationItem record, @Param("example") EvaluationItemExample example);

    int updateByPrimaryKeySelective(EvaluationItem record);

    int updateByPrimaryKey(EvaluationItem record);
}