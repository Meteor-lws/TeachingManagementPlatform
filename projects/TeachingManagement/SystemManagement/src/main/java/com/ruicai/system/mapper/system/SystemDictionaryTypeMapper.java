package com.ruicai.system.mapper.system;

import com.ruicai.system.po.system.SystemDictionaryType;
import com.ruicai.system.po.system.SystemDictionaryTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemDictionaryTypeMapper {
    int countByExample(SystemDictionaryTypeExample example);

    int deleteByExample(SystemDictionaryTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(SystemDictionaryType record);

    int insertSelective(SystemDictionaryType record);

    List<SystemDictionaryType> selectByExample(SystemDictionaryTypeExample example);

    SystemDictionaryType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SystemDictionaryType record, @Param("example") SystemDictionaryTypeExample example);

    int updateByExample(@Param("record") SystemDictionaryType record, @Param("example") SystemDictionaryTypeExample example);

    int updateByPrimaryKeySelective(SystemDictionaryType record);

    int updateByPrimaryKey(SystemDictionaryType record);
}