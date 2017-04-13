package com.ruicai.education.mapper.education;

import com.ruicai.education.po.education.EducationWork;
import com.ruicai.education.po.education.EducationWorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EducationWorkMapper {
    int countByExample(EducationWorkExample example);

    int deleteByExample(EducationWorkExample example);

    int deleteByPrimaryKey(String id);

    int insert(EducationWork record);

    int insertSelective(EducationWork record);

    List<EducationWork> selectByExample(EducationWorkExample example);

    EducationWork selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EducationWork record, @Param("example") EducationWorkExample example);

    int updateByExample(@Param("record") EducationWork record, @Param("example") EducationWorkExample example);

    int updateByPrimaryKeySelective(EducationWork record);

    int updateByPrimaryKey(EducationWork record);
}