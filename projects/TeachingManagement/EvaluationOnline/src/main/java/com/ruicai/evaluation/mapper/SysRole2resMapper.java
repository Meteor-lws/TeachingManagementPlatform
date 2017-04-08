package com.ruicai.evaluation.mapper;

import com.ruicai.evaluation.po.SysRole2resExample;
import com.ruicai.evaluation.po.SysRole2resKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRole2resMapper {
    int countByExample(SysRole2resExample example);

    int deleteByExample(SysRole2resExample example);

    int deleteByPrimaryKey(SysRole2resKey key);

    int insert(SysRole2resKey record);

    int insertSelective(SysRole2resKey record);

    List<SysRole2resKey> selectByExample(SysRole2resExample example);

    int updateByExampleSelective(@Param("record") SysRole2resKey record, @Param("example") SysRole2resExample example);

    int updateByExample(@Param("record") SysRole2resKey record, @Param("example") SysRole2resExample example);
}