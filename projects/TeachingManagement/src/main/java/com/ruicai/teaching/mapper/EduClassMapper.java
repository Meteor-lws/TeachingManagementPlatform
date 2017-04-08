package com.ruicai.teaching.mapper;

import com.ruicai.teaching.po.EduClass;
import com.ruicai.teaching.po.EduClassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EduClassMapper {
    int countByExample(EduClassExample example);

    int deleteByExample(EduClassExample example);

    int deleteByPrimaryKey(String id);

    int insert(EduClass record);

    int insertSelective(EduClass record);

    List<EduClass> selectByExample(EduClassExample example);

    EduClass selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EduClass record, @Param("example") EduClassExample example);

    int updateByExample(@Param("record") EduClass record, @Param("example") EduClassExample example);

    int updateByPrimaryKeySelective(EduClass record);

    int updateByPrimaryKey(EduClass record);
}