package com.hjj.vo;

/**
 * Created by 朱高 on 2017/3/28.
 */
public class Question {
    private int id;
    private String questionContent;
    private String questionType;
    private String questionTime;
    private String proposer;
    private String phase;
    private int usageCount;

    public Question() {
    }

    public Question(int id, String questionContent, String questionType, String questionTime, String proposer, int usageCount, String phase) {
        this.id = id;
        this.questionContent = questionContent;
        this.questionType = questionType;
        this.questionTime = questionTime;
        this.proposer = proposer;
        this.usageCount = usageCount;
        this.phase = phase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(String questionTime) {
        this.questionTime = questionTime;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public int getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(int usageCount) {
        this.usageCount = usageCount;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }
}
