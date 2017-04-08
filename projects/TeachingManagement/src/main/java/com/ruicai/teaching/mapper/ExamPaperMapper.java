package com.ruicai.teaching.mapper;

import com.ruicai.teaching.po.ExamPaper;
import com.ruicai.teaching.po.ExamPaperExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamPaperMapper {
    int countByExample(ExamPaperExample example);

    int deleteByExample(ExamPaperExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExamPaper record);

    int insertSelective(ExamPaper record);

    List<ExamPaper> selectByExample(ExamPaperExample example);

    ExamPaper selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExamPaper record, @Param("example") ExamPaperExample example);

    int updateByExample(@Param("record") ExamPaper record, @Param("example") ExamPaperExample example);

    int updateByPrimaryKeySelective(ExamPaper record);

    int updateByPrimaryKey(ExamPaper record);
}