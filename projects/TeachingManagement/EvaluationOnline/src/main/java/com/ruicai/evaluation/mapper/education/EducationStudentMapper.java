package com.ruicai.evaluation.mapper.education;

import com.ruicai.evaluation.po.education.EducationStudent;
import com.ruicai.evaluation.po.education.EducationStudentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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