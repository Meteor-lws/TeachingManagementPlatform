package com.ruicai.examination.mapper;

import com.ruicai.examination.po.ExamPaperDetail;
import com.ruicai.examination.po.ExamPaperDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamPaperDetailMapper {
    int countByExample(ExamPaperDetailExample example);

    int deleteByExample(ExamPaperDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExamPaperDetail record);

    int insertSelective(ExamPaperDetail record);

    List<ExamPaperDetail> selectByExample(ExamPaperDetailExample example);

    ExamPaperDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExamPaperDetail record, @Param("example") ExamPaperDetailExample example);

    int updateByExample(@Param("record") ExamPaperDetail record, @Param("example") ExamPaperDetailExample example);

    int updateByPrimaryKeySelective(ExamPaperDetail record);

    int updateByPrimaryKey(ExamPaperDetail record);
}