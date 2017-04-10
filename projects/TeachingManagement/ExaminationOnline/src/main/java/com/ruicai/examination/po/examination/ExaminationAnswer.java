package com.ruicai.examination.po.examination;

public class ExaminationAnswer {
    private String id;

    private String studentId;

    private Short answerScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public Short getAnswerScore() {
        return answerScore;
    }

    public void setAnswerScore(Short answerScore) {
        this.answerScore = answerScore;
    }
}