package com.ruicai.education.mapper.education;

import com.ruicai.education.po.education.SystemDictionaryType;
import com.ruicai.education.po.education.SystemDictionaryTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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