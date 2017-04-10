package com.ruicai.system.dao.examination;

import com.ruicai.system.po.examination.ExaminationQuestion;
import com.ruicai.system.po.examination.ExaminationQuestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationQuestionMapper {
    int countByExample(ExaminationQuestionExample example);

    int deleteByExample(ExaminationQuestionExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExaminationQuestion record);

    int insertSelective(ExaminationQuestion record);

    List<ExaminationQuestion> selectByExample(ExaminationQuestionExample example);

    ExaminationQuestion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExaminationQuestion record, @Param("example") ExaminationQuestionExample example);

    int updateByExample(@Param("record") ExaminationQuestion record, @Param("example") ExaminationQuestionExample example);

    int updateByPrimaryKeySelective(ExaminationQuestion record);

    int updateByPrimaryKey(ExaminationQuestion record);
}