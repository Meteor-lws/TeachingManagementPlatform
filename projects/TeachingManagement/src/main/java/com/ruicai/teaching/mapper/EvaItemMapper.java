package com.ruicai.teaching.mapper;

import com.ruicai.teaching.po.EvaItem;
import com.ruicai.teaching.po.EvaItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaItemMapper {
    int countByExample(EvaItemExample example);

    int deleteByExample(EvaItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(EvaItem record);

    int insertSelective(EvaItem record);

    List<EvaItem> selectByExample(EvaItemExample example);

    EvaItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EvaItem record, @Param("example") EvaItemExample example);

    int updateByExample(@Param("record") EvaItem record, @Param("example") EvaItemExample example);

    int updateByPrimaryKeySelective(EvaItem record);

    int updateByPrimaryKey(EvaItem record);
}