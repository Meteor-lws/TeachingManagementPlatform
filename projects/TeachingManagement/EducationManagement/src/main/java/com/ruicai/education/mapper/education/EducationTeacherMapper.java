package com.ruicai.education.mapper.education;

import com.ruicai.education.po.education.EducationTeacher;

import java.util.List;

import com.ruicai.education.po.education.TeacherCondition;
import org.apache.ibatis.annotations.Param;

public interface EducationTeacherMapper {

    int deleteByPrimaryKey(String id);

    int insert(EducationTeacher record);

    int insertSelective(EducationTeacher record);


    EducationTeacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EducationTeacher record);

    int updateByPrimaryKey(EducationTeacher record);

    int selectTeaByConditionCount(TeacherCondition condition);

    List<EducationTeacher> selectTeaByCondition(TeacherCondition condition);

}