package com.ruicai.examination.mapper.education;

import com.ruicai.examination.po.education.EducationTeacher;
import com.ruicai.examination.po.education.EducationTeacherExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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