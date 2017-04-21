package com.ruicai.examination.mapper.examination;

import com.ruicai.examination.po.examination.ExaminationAnswer;
import com.ruicai.examination.po.examination.ExaminationAnswerExample;
import com.ruicai.examination.vo.question.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExaminationAnswerMapper {
    int countByExample(ExaminationAnswerExample example);

    int deleteByExample(ExaminationAnswerExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExaminationAnswer record);

    int insertSelective(ExaminationAnswer record);

    List<ExaminationAnswer> selectByExample(ExaminationAnswerExample example);

    ExaminationAnswer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExaminationAnswer record, @Param("example") ExaminationAnswerExample example);

    int updateByExample(@Param("record") ExaminationAnswer record, @Param("example") ExaminationAnswerExample example);

    int updateByPrimaryKeySelective(ExaminationAnswer record);

    int updateByPrimaryKey(ExaminationAnswer record);


}