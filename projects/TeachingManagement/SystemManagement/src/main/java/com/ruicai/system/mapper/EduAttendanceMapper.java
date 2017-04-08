package com.ruicai.system.mapper;

import com.ruicai.system.po.EduAttendance;
import com.ruicai.system.po.EduAttendanceExample;
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