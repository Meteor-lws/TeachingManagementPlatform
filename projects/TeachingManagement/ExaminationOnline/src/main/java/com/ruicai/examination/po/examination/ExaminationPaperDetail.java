package com.ruicai.examination.po.examination;

public class ExaminationPaperDetail {
    private String id;

    /**
     * 试卷ID
     * 外键：指向试卷ID
     */
    private String paperId;

    /**
     * 试题
     * 外键：指向问题ID
     */
    private String questionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }
}