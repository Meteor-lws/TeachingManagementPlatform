package com.ruicai.examination.po.examination;

public class ExaminationAnswerDetail {
    private String id;

    /**
     * 答题卡ID
     * 外键：指向Answer_ID
     */
    private String answerId;

    /**
     * 试卷详情ID
     * 外键：指向Paper_Detail_Id
     */
    private String paperDetailId;

    /**
     * 作答内容
     */
    private String answerContent;

    /**
     * 作答得分
     */
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