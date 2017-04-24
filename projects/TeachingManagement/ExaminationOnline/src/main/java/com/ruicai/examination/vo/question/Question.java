package com.ruicai.examination.vo.question;

import com.ruicai.examination.po.examination.ExaminationQuestion;

/**
 *
 * Created by 朱高 on 2017/4/18.
 */
public class Question extends ExaminationQuestion {
    private String questionSubjectName;
    private String questionTypeName;
    private String questionStageName;
    private String questionTypeId;

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(String questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getQuestionStageName() {
        return questionStageName;
    }

    public void setQuestionStageName(String questionStageName) {
        this.questionStageName = questionStageName;
    }

    public String getQuestionSubjectName() {
        return questionSubjectName;
    }

    public void setQuestionSubjectName(String questionSubjectName) {
        this.questionSubjectName = questionSubjectName;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", questionSubject='" + questionSubject + '\'' +
                ", questionSubjectName='" + questionSubjectName + '\'' +
                ", questionTypeName='" + questionTypeName + '\'' +
                ", questionType='" + questionType + '\'' +
                ", questionStageName='" + questionStageName + '\'' +
                ", questionScore=" + questionScore +
                ", questionContent='" + questionContent + '\'' +
                ", questionAnswer='" + questionAnswer + '\'' +
                ", questionSelections=" + questionSelections +
                ", questionStage='" + questionStage + '\'' +
                '}';
    }
}
