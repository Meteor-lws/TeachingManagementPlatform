package com.ruicai.examination.mapper.education;

import com.ruicai.examination.po.education.EducationClass;
import com.ruicai.examination.po.education.EducationClassExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationClassMapper {
    int countByExample(EducationClassExample example);

    int deleteByExample(EducationClassExample example);

    int deleteByPrimaryKey(String id);

    int insert(EducationClass record);

    int insertSelective(EducationClass record);

    List<EducationClass> selectByExample(EducationClassExample example);

    EducationClass selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EducationClass record, @Param("example") EducationClassExample example);

    int updateByExample(@Param("record") EducationClass record, @Param("example") EducationClassExample example);

    int updateByPrimaryKeySelective(EducationClass record);

    int updateByPrimaryKey(EducationClass record);
}