package com.ruicai.examination.po.examination;

public class ExaminationQuestion {
    protected String id;

    /**
     * 考试科目
     * 外键: 指向数据字典表，数据字典的ID
     */
    protected String questionSubject;

    /**
     * 试题类型
     * 外键: 指向数据字典表，数据字典的ID
     */
    protected String questionType;

    /**
     * 试题分数
     */
    protected Short questionScore;

    /**
     * 试题内容
     */
    protected String questionContent;

    /**
     * 试题答案
     */
    protected String questionAnswer;

    /**
     * 选用次数
     */
    protected Integer questionSelections;

    /**
     * 试题使用阶段
     */
    protected String questionStage;

    public String getQuestionStage() {
        return questionStage;
    }

    public void setQuestionStage(String questionStage) {
        this.questionStage = questionStage;
    }

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

    @Override
    public String toString() {
        return "ExaminationQuestion{" +
                "id='" + id + '\'' +
                ", questionSubject='" + questionSubject + '\'' +
                ", questionType='" + questionType + '\'' +
                ", questionScore=" + questionScore +
                ", questionContent='" + questionContent + '\'' +
                ", questionAnswer='" + questionAnswer + '\'' +
                ", questionSelections=" + questionSelections +
                ", questionStage='" + questionStage + '\'' +
                '}';
    }
}