package com.ruicai.evaluation.mapper;

import com.ruicai.evaluation.po.SystemResource;
import com.ruicai.evaluation.po.SystemResourceExample;
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
}