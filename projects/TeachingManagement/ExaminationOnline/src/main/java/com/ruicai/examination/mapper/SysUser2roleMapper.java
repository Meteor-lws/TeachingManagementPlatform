package com.ruicai.examination.mapper;

import com.ruicai.examination.po.SysUser2roleExample;
import com.ruicai.examination.po.SysUser2roleKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUser2roleMapper {
    int countByExample(SysUser2roleExample example);

    int deleteByExample(SysUser2roleExample example);

    int deleteByPrimaryKey(SysUser2roleKey key);

    int insert(SysUser2roleKey record);

    int insertSelective(SysUser2roleKey record);

    List<SysUser2roleKey> selectByExample(SysUser2roleExample example);

    int updateByExampleSelective(@Param("record") SysUser2roleKey record, @Param("example") SysUser2roleExample example);

    int updateByExample(@Param("record") SysUser2roleKey record, @Param("example") SysUser2roleExample example);
}