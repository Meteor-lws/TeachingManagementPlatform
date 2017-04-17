package com.ruicai.education.mapper.education;

import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.TeacherCondition;

import java.util.List;
import java.util.Map;

public interface EducationTeacherMapper {

    int deleteByPrimaryKey(String id);

    int insert(EducationTeacher record);

    int insertSelective(EducationTeacher record);


    EducationTeacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EducationTeacher record);

    int updateByPrimaryKey(EducationTeacher record);

    int selectTeaByConditionCount(TeacherCondition condition);

    List<EducationTeacher> selectTeaByCondition(TeacherCondition condition);

    List<EducationTeacher> selectAll();

    void grantRole(Map<String, String> s);
}