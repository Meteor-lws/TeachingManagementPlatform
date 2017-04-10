package com.ruicai.examination.mapper.education;

import com.ruicai.examination.po.education.EducationAttendance;
import com.ruicai.examination.po.education.EducationAttendanceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EducationAttendanceMapper {
    int countByExample(EducationAttendanceExample example);

    int deleteByExample(EducationAttendanceExample example);

    int deleteByPrimaryKey(String id);

    int insert(EducationAttendance record);

    int insertSelective(EducationAttendance record);

    List<EducationAttendance> selectByExample(EducationAttendanceExample example);

    EducationAttendance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EducationAttendance record, @Param("example") EducationAttendanceExample example);

    int updateByExample(@Param("record") EducationAttendance record, @Param("example") EducationAttendanceExample example);

    int updateByPrimaryKeySelective(EducationAttendance record);

    int updateByPrimaryKey(EducationAttendance record);
}