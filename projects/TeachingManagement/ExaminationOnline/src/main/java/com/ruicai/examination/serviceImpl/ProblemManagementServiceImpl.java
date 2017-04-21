package com.ruicai.examination.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruicai.examination.mapper.examination.ExaminationQuestionMapper;
import com.ruicai.examination.service.ProblemManagementService;
import com.ruicai.examination.vo.question.Question;
import com.ruicai.examination.vo.question.QuestionDatagrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 朱高 on 2017/4/18.
 */
@Service
public class ProblemManagementServiceImpl implements ProblemManagementService {

    private final ExaminationQuestionMapper questionMapper;

    @Autowired
    public ProblemManagementServiceImpl(ExaminationQuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public QuestionDatagrid selectQuestion(int page, int rows, Question question) {
        QuestionDatagrid questionDatagrid = new QuestionDatagrid();
        PageHelper.startPage(page, rows);
        List<Question> result = questionMapper.selectQuestion(question);
        PageInfo<Question> pageInfo = new PageInfo<>(result);
        System.err.println(pageInfo);
        questionDatagrid.setRows(result);
        questionDatagrid.setTotal(pageInfo.getTotal());
        return questionDatagrid;
    }

    @Override
    public QuestionDatagrid selectQuestion(int page, int rows) {
        return selectQuestion(page, rows, null);
    }
}
