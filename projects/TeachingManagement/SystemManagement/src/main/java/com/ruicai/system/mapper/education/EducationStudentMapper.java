package com.ruicai.system.mapper.education;

import com.ruicai.system.po.education.EducationStudent;
import com.ruicai.system.po.education.EducationStudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EducationStudentMapper {
    int countByExample(EducationStudentExample example);

    int deleteByExample(EducationStudentExample example);

    int deleteByPrimaryKey(String id);

    int insert(EducationStudent record);

    int insertSelective(EducationStudent record);

    List<EducationStudent> selectByExample(EducationStudentExample example);

    EducationStudent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EducationStudent record, @Param("example") EducationStudentExample example);

    int updateByExample(@Param("record") EducationStudent record, @Param("example") EducationStudentExample example);

    int updateByPrimaryKeySelective(EducationStudent record);

    int updateByPrimaryKey(EducationStudent record);
}