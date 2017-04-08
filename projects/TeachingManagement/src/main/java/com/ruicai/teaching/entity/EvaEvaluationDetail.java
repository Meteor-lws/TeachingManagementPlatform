package com.ruicai.teaching.entity;

public class EvaEvaluationDetail {
    private String id;

    private String evaluationId;

    private String itemId;

    private Short detailScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId == null ? null : evaluationId.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public Short getDetailScore() {
        return detailScore;
    }

    public void setDetailScore(Short detailScore) {
        this.detailScore = detailScore;
    }
}