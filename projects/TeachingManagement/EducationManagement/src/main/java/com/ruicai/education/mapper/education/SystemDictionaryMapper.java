package com.ruicai.education.mapper.education;

import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.po.education.SystemDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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

    List<SystemDictionary> selectDicByName(String desc);

    List<SystemDictionary> selectDictionary();

    SystemDictionary selectDicByValue(String val);
}