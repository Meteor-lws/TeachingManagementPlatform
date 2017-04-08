package com.ruicai.education.dao;

import com.ruicai.education.entity.EduAttendance;
import com.ruicai.education.entity.EduAttendanceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EduAttendanceMapper {
    int countByExample(EduAttendanceExample example);

    int deleteByExample(EduAttendanceExample example);

    int deleteByPrimaryKey(String id);

    int insert(EduAttendance record);

    int insertSelective(EduAttendance record);

    List<EduAttendance> selectByExample(EduAttendanceExample example);

    EduAttendance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EduAttendance record, @Param("example") EduAttendanceExample example);

    int updateByExample(@Param("record") EduAttendance record, @Param("example") EduAttendanceExample example);

    int updateByPrimaryKeySelective(EduAttendance record);

    int updateByPrimaryKey(EduAttendance record);
}