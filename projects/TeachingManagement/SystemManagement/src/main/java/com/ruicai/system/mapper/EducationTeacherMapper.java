package com.ruicai.system.mapper;

import com.ruicai.system.po.EducationTeacher;
import com.ruicai.system.po.EducationTeacherExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EducationTeacherMapper {
    int countByExample(EducationTeacherExample example);

    int deleteByExample(EducationTeacherExample example);

    int deleteByPrimaryKey(String id);

    int insert(EducationTeacher record);

    int insertSelective(EducationTeacher record);

    List<EducationTeacher> selectByExample(EducationTeacherExample example);

    EducationTeacher selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EducationTeacher record, @Param("example") EducationTeacherExample example);

    int updateByExample(@Param("record") EducationTeacher record, @Param("example") EducationTeacherExample example);

    int updateByPrimaryKeySelective(EducationTeacher record);

    int updateByPrimaryKey(EducationTeacher record);
}