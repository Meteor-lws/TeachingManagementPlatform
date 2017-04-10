package com.ruicai.evaluation.mapper;

import com.ruicai.evaluation.po.RoleToResourceExample;
import com.ruicai.evaluation.po.RoleToResourceKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleToResourceMapper {
    int countByExample(RoleToResourceExample example);

    int deleteByExample(RoleToResourceExample example);

    int deleteByPrimaryKey(RoleToResourceKey key);

    int insert(RoleToResourceKey record);

    int insertSelective(RoleToResourceKey record);

    List<RoleToResourceKey> selectByExample(RoleToResourceExample example);

    int updateByExampleSelective(@Param("record") RoleToResourceKey record, @Param("example") RoleToResourceExample example);

    int updateByExample(@Param("record") RoleToResourceKey record, @Param("example") RoleToResourceExample example);
}