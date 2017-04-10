package com.ruicai.system.dao.system;

import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.po.system.SystemDictionaryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemDictionaryMapper {
    int countByExample(SystemDictionaryExample example);

    int deleteByExample(SystemDictionaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(SystemDictionary record);

    int insertSelective(SystemDictionary record);

    List<SystemDictionary> selectByExample(SystemDictionaryExample example);

    SystemDictionary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SystemDictionary record, @Param("example") SystemDictionaryExample example);

    int updateByExample(@Param("record") SystemDictionary record, @Param("example") SystemDictionaryExample example);

    int updateByPrimaryKeySelective(SystemDictionary record);

    int updateByPrimaryKey(SystemDictionary record);
}