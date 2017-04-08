package com.ruicai.examination.mapper;

import com.ruicai.examination.po.EduTeacher;
import com.ruicai.examination.po.EduTeacherExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EduTeacherMapper {
    int countByExample(EduTeacherExample example);

    int deleteByExample(EduTeacherExample example);

    int deleteByPrimaryKey(String id);

    int insert(EduTeacher record);

    int insertSelective(EduTeacher record);

    List<EduTeacher> selectByExample(EduTeacherExample example);

    EduTeacher selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EduTeacher record, @Param("example") EduTeacherExample example);

    int updateByExample(@Param("record") EduTeacher record, @Param("example") EduTeacherExample example);

    int updateByPrimaryKeySelective(EduTeacher record);

    int updateByPrimaryKey(EduTeacher record);
}