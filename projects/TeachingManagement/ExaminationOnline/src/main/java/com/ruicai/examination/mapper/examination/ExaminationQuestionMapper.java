package com.ruicai.examination.mapper.examination;

import com.ruicai.examination.po.examination.ExaminationQuestion;
import com.ruicai.examination.po.examination.ExaminationQuestionExample;
import com.ruicai.examination.vo.question.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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

    List<Question> selectQuestion(Question question);
}