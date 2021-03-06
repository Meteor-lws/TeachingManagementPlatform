package com.ruicai.system.mapper.education;

import com.ruicai.system.po.education.EducationClass;
import com.ruicai.system.po.education.EducationClassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EducationClassMapper {
    int countByExample(EducationClassExample example);

    int deleteByExample(EducationClassExample example);

    int deleteByPrimaryKey(String id);

    int insert(EducationClass record);

    int insertSelective(EducationClass record);

    List<EducationClass> selectByExample(EducationClassExample example);

    EducationClass selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EducationClass record, @Param("example") EducationClassExample example);

    int updateByExample(@Param("record") EducationClass record, @Param("example") EducationClassExample example);

    int updateByPrimaryKeySelective(EducationClass record);

    int updateByPrimaryKey(EducationClass record);
}