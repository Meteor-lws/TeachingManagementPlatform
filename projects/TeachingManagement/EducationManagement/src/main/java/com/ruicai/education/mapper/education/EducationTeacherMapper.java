package com.ruicai.education.mapper.education;

import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.TeacherCondition;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
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

    /**
     * 查询教师根据教师类型 讲师 ，班主任， 助教
     *
     * @return
     */
    List<EducationTeacher> selectAllTeacherByType(String type);
}