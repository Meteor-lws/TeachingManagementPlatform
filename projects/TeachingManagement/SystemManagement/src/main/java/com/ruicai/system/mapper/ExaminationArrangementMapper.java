package com.ruicai.system.mapper;

import com.ruicai.system.po.ExaminationArrangement;
import com.ruicai.system.po.ExaminationArrangementExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationArrangementMapper {
    int countByExample(ExaminationArrangementExample example);

    int deleteByExample(ExaminationArrangementExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExaminationArrangement record);

    int insertSelective(ExaminationArrangement record);

    List<ExaminationArrangement> selectByExample(ExaminationArrangementExample example);

    ExaminationArrangement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExaminationArrangement record, @Param("example") ExaminationArrangementExample example);

    int updateByExample(@Param("record") ExaminationArrangement record, @Param("example") ExaminationArrangementExample example);

    int updateByPrimaryKeySelective(ExaminationArrangement record);

    int updateByPrimaryKey(ExaminationArrangement record);
}