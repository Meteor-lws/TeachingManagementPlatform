package com.ruicai.system.mapper.system;

import com.ruicai.system.po.system.EvaluationDetail;
import com.ruicai.system.po.system.EvaluationDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluationDetailMapper {
    int countByExample(EvaluationDetailExample example);

    int deleteByExample(EvaluationDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(EvaluationDetail record);

    int insertSelective(EvaluationDetail record);

    List<EvaluationDetail> selectByExample(EvaluationDetailExample example);

    EvaluationDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EvaluationDetail record, @Param("example") EvaluationDetailExample example);

    int updateByExample(@Param("record") EvaluationDetail record, @Param("example") EvaluationDetailExample example);

    int updateByPrimaryKeySelective(EvaluationDetail record);

    int updateByPrimaryKey(EvaluationDetail record);
}