package com.ruicai.system.mapper.system;

import com.github.pagehelper.Page;
import com.ruicai.system.po.system.ResourceCondition;
import com.ruicai.system.po.system.SystemResource;
import com.ruicai.system.po.system.SystemResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemResourceMapper {
    int countByExample(SystemResourceExample example);

    int deleteByExample(SystemResourceExample example);

    int deleteByPrimaryKey(String id);

    int insert(SystemResource record);

    int insertSelective(SystemResource record);

    List<SystemResource> selectByExample(SystemResourceExample example);

    SystemResource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SystemResource record, @Param("example") SystemResourceExample example);

    int updateByExample(@Param("record") SystemResource record, @Param("example") SystemResourceExample example);

    int updateByPrimaryKeySelective(SystemResource record);

    int updateByPrimaryKey(SystemResource record);

    List<SystemResource> selectPreByCondition(ResourceCondition condition);

    int selectPreByConditionCount(ResourceCondition condition);
}