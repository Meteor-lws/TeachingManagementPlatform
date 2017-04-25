package com.ruicai.system.mapper.examination;

import com.ruicai.system.po.examination.ExaminationAnswerDetail;
import com.ruicai.system.po.examination.ExaminationAnswerDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationAnswerDetailMapper {
    int countByExample(ExaminationAnswerDetailExample example);

    int deleteByExample(ExaminationAnswerDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExaminationAnswerDetail record);

    int insertSelective(ExaminationAnswerDetail record);

    List<ExaminationAnswerDetail> selectByExample(ExaminationAnswerDetailExample example);

    ExaminationAnswerDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExaminationAnswerDetail record, @Param("example") ExaminationAnswerDetailExample example);

    int updateByExample(@Param("record") ExaminationAnswerDetail record, @Param("example") ExaminationAnswerDetailExample example);

    int updateByPrimaryKeySelective(ExaminationAnswerDetail record);

    int updateByPrimaryKey(ExaminationAnswerDetail record);
}