package com.ruicai.education.po.education;

import com.ruicai.education.util.MyDateFormate;

import java.sql.Timestamp;

public class EducationClass {
    private String id;

    private String headTeacherId;

    private String mainTeacherId;

    private String assistantId;

    private String assistantView;

    private String classType;

    private String classTypeView;
    private String className;
    private Timestamp classStartDate;
    private Timestamp classEndDate;
    private String mainTeacher;
    private String headTeacher;
    private String classStartDateView;
    private String classEndDateView;

    public String getClassTypeView() {
        return classTypeView;
    }

    public void setClassTypeView(String classTypeView) {
        this.classTypeView = classTypeView;
    }

    public String getClassStartDateView() {
        return classStartDateView;
    }


    public String getClassEndDateView() {
        return classEndDateView;
    }


    public String getMainTeacher() {
        return mainTeacher;
    }

    public void setMainTeacher(String mainTeacher) {
        this.mainTeacher = mainTeacher;
    }

    public String getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(String headTeacher) {
        this.headTeacher = headTeacher;
    }

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

    public Timestamp getClassStartDate() {

        return classStartDate;
    }

    public void setClassStartDate(Timestamp classStartDate) {
        this.classStartDate = classStartDate;
        this.classStartDateView = MyDateFormate.timeStampToString(classStartDate);
    }

    public Timestamp getClassEndDate() {
        return classEndDate;
    }

    public void setClassEndDate(Timestamp classEndDate) {
        this.classEndDate = classEndDate;
        this.classEndDateView = MyDateFormate.timeStampToString(classEndDate);
    }
}