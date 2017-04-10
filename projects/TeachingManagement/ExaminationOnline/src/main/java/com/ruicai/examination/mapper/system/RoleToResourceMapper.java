package com.ruicai.examination.mapper.system;

import com.ruicai.examination.po.system.RoleToResourceExample;
import com.ruicai.examination.po.system.RoleToResourceKey;
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