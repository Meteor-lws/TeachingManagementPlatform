package com.ruicai.evaluation.po;

public class ExaminationAnswerDetail {
    private String id;

    private String answerId;

    private String paperDetailId;

    private String answerContent;

    private Short answerDetailScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId == null ? null : answerId.trim();
    }

    public String getPaperDetailId() {
        return paperDetailId;
    }

    public void setPaperDetailId(String paperDetailId) {
        this.paperDetailId = paperDetailId == null ? null : paperDetailId.trim();
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent == null ? null : answerContent.trim();
    }

    public Short getAnswerDetailScore() {
        return answerDetailScore;
    }

    public void setAnswerDetailScore(Short answerDetailScore) {
        this.answerDetailScore = answerDetailScore;
    }
}