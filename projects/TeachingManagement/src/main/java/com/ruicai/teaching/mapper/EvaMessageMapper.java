package com.ruicai.teaching.mapper;

import com.ruicai.teaching.po.EvaMessage;
import com.ruicai.teaching.po.EvaMessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaMessageMapper {
    int countByExample(EvaMessageExample example);

    int deleteByExample(EvaMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(EvaMessage record);

    int insertSelective(EvaMessage record);

    List<EvaMessage> selectByExample(EvaMessageExample example);

    EvaMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EvaMessage record, @Param("example") EvaMessageExample example);

    int updateByExample(@Param("record") EvaMessage record, @Param("example") EvaMessageExample example);

    int updateByPrimaryKeySelective(EvaMessage record);

    int updateByPrimaryKey(EvaMessage record);
}