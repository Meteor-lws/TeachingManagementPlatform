package com.ruicai.system.dao;

import com.ruicai.system.entity.SysRes;
import com.ruicai.system.entity.SysResExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysResMapper {
    int countByExample(SysResExample example);

    int deleteByExample(SysResExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRes record);

    int insertSelective(SysRes record);

    List<SysRes> selectByExample(SysResExample example);

    SysRes selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRes record, @Param("example") SysResExample example);

    int updateByExample(@Param("record") SysRes record, @Param("example") SysResExample example);

    int updateByPrimaryKeySelective(SysRes record);

    int updateByPrimaryKey(SysRes record);
}