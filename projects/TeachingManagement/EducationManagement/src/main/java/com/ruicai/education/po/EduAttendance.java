package com.ruicai.education.po;

import java.util.Date;

public class EduAttendance {
    private String id;

    private String studentId;

    private String attStatus;

    private Date attTime;

    private String attRemark;

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

    public String getAttStatus() {
        return attStatus;
    }

    public void setAttStatus(String attStatus) {
        this.attStatus = attStatus == null ? null : attStatus.trim();
    }

    public Date getAttTime() {
        return attTime;
    }

    public void setAttTime(Date attTime) {
        this.attTime = attTime;
    }

    public String getAttRemark() {
        return attRemark;
    }

    public void setAttRemark(String attRemark) {
        this.attRemark = attRemark == null ? null : attRemark.trim();
    }
}