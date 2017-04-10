package com.ruicai.evaluation.po;

public class EvaluationDetail {
    private String id;

    private String itemId;

    private String evaluationId;

    private Short evaluationScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId == null ? null : evaluationId.trim();
    }

    public Short getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(Short evaluationScore) {
        this.evaluationScore = evaluationScore;
    }
}