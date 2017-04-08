package com.ruicai.evaluation.po;

public class ExamQuestion {
    private String id;

    private String questionSubject;

    private String questionType;

    private Short questionScore;

    private String questionContent;

    private String questionAnswer;

    private Integer questionSelections;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getQuestionSubject() {
        return questionSubject;
    }

    public void setQuestionSubject(String questionSubject) {
        this.questionSubject = questionSubject == null ? null : questionSubject.trim();
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    public Short getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(Short questionScore) {
        this.questionScore = questionScore;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer == null ? null : questionAnswer.trim();
    }

    public Integer getQuestionSelections() {
        return questionSelections;
    }

    public void setQuestionSelections(Integer questionSelections) {
        this.questionSelections = questionSelections;
    }
}