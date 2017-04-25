package com.ruicai.system.mapper.examination;

import com.ruicai.system.po.examination.ExaminationPaper;
import com.ruicai.system.po.examination.ExaminationPaperExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationPaperMapper {
    int countByExample(ExaminationPaperExample example);

    int deleteByExample(ExaminationPaperExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExaminationPaper record);

    int insertSelective(ExaminationPaper record);

    List<ExaminationPaper> selectByExample(ExaminationPaperExample example);

    ExaminationPaper selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExaminationPaper record, @Param("example") ExaminationPaperExample example);

    int updateByExample(@Param("record") ExaminationPaper record, @Param("example") ExaminationPaperExample example);

    int updateByPrimaryKeySelective(ExaminationPaper record);

    int updateByPrimaryKey(ExaminationPaper record);
}