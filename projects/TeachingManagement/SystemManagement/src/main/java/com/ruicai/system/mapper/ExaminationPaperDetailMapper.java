package com.ruicai.system.mapper;

import com.ruicai.system.po.ExaminationPaperDetail;
import com.ruicai.system.po.ExaminationPaperDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationPaperDetailMapper {
    int countByExample(ExaminationPaperDetailExample example);

    int deleteByExample(ExaminationPaperDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExaminationPaperDetail record);

    int insertSelective(ExaminationPaperDetail record);

    List<ExaminationPaperDetail> selectByExample(ExaminationPaperDetailExample example);

    ExaminationPaperDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExaminationPaperDetail record, @Param("example") ExaminationPaperDetailExample example);

    int updateByExample(@Param("record") ExaminationPaperDetail record, @Param("example") ExaminationPaperDetailExample example);

    int updateByPrimaryKeySelective(ExaminationPaperDetail record);

    int updateByPrimaryKey(ExaminationPaperDetail record);
}