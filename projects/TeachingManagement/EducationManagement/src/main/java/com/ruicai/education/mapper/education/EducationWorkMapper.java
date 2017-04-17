package com.ruicai.education.mapper.education;

import com.ruicai.education.po.education.EducationWork;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EducationWorkMapper {

    int deleteByPrimaryKey(String id);

    int insert(EducationWork record);

    int insertSelective(EducationWork record);

    EducationWork selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EducationWork record);

    int updateByPrimaryKey(EducationWork record);
}