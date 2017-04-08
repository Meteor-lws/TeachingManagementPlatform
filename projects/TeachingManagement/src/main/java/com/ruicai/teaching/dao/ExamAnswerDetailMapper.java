package com.ruicai.teaching.dao;

import com.ruicai.teaching.entity.ExamAnswerDetail;
import com.ruicai.teaching.entity.ExamAnswerDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamAnswerDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_answer_detail
     *
     * @mbggenerated
     */
    int countByExample(ExamAnswerDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_answer_detail
     *
     * @mbggenerated
     */
    int deleteByExample(ExamAnswerDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_answer_detail
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_answer_detail
     *
     * @mbggenerated
     */
    int insert(ExamAnswerDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_answer_detail
     *
     * @mbggenerated
     */
    int insertSelective(ExamAnswerDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_answer_detail
     *
     * @mbggenerated
     */
    List<ExamAnswerDetail> selectByExample(ExamAnswerDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_answer_detail
     *
     * @mbggenerated
     */
    ExamAnswerDetail selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_answer_detail
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ExamAnswerDetail record, @Param("example") ExamAnswerDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_answer_detail
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ExamAnswerDetail record, @Param("example") ExamAnswerDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_answer_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ExamAnswerDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_answer_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ExamAnswerDetail record);
}