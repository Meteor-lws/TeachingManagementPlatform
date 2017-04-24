package com.ruicai.examination.service;

import com.ruicai.examination.po.examination.ExaminationQuestion;
import com.ruicai.examination.vo.question.Question;
import com.ruicai.examination.vo.question.QuestionDatagrid;

public interface ProblemManagementService {

    QuestionDatagrid selectQuestion(int page, int rows, Question question);

    QuestionDatagrid selectQuestion(int page, int rows);

    int insert(ExaminationQuestion examinationQuestion);

    void updateQuestion(ExaminationQuestion question);
}
