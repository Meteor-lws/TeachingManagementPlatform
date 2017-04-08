package com.ruicai.examination.po;

public class ExamArrangement {
    private String id;

    private String classId;

    private String teacherId;

    private String paperId;

    private String examStage;

    private Object examTime;

    private String examAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public String getExamStage() {
        return examStage;
    }

    public void setExamStage(String examStage) {
        this.examStage = examStage == null ? null : examStage.trim();
    }

    public Object getExamTime() {
        return examTime;
    }

    public void setExamTime(Object examTime) {
        this.examTime = examTime;
    }

    public String getExamAddress() {
        return examAddress;
    }

    public void setExamAddress(String examAddress) {
        this.examAddress = examAddress == null ? null : examAddress.trim();
    }
}