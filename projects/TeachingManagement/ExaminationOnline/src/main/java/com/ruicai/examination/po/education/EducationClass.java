package com.ruicai.examination.po.education;

import java.util.Date;

public class EducationClass {
    private String id;

    private String headTeacherId;

    private String mainTeacherId;

    private String assistantId;

    private String classType;

    private String className;

    private Date classStartDate;

    private Date classEndDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHeadTeacherId() {
        return headTeacherId;
    }

    public void setHeadTeacherId(String headTeacherId) {
        this.headTeacherId = headTeacherId == null ? null : headTeacherId.trim();
    }

    public String getMainTeacherId() {
        return mainTeacherId;
    }

    public void setMainTeacherId(String mainTeacherId) {
        this.mainTeacherId = mainTeacherId == null ? null : mainTeacherId.trim();
    }

    public String getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(String assistantId) {
        this.assistantId = assistantId == null ? null : assistantId.trim();
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType == null ? null : classType.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Date getClassStartDate() {
        return classStartDate;
    }

    public void setClassStartDate(Date classStartDate) {
        this.classStartDate = classStartDate;
    }

    public Date getClassEndDate() {
        return classEndDate;
    }

    public void setClassEndDate(Date classEndDate) {
        this.classEndDate = classEndDate;
    }

    @Override
    public String toString() {
        return "EducationClass{" +
                "id='" + id + '\'' +
                ", headTeacherId='" + headTeacherId + '\'' +
                ", mainTeacherId='" + mainTeacherId + '\'' +
                ", assistantId='" + assistantId + '\'' +
                ", classType='" + classType + '\'' +
                ", className='" + className + '\'' +
                ", classStartDate=" + classStartDate +
                ", classEndDate=" + classEndDate +
                '}';
    }
}