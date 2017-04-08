package com.ruicai.examination.po;

import java.util.Date;

public class EduWork {
    private String id;

    private String teacherId;

    private String workType;

    private String workUrl;

    private Date workUploadTime;

    private String workRemark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getWorkUrl() {
        return workUrl;
    }

    public void setWorkUrl(String workUrl) {
        this.workUrl = workUrl == null ? null : workUrl.trim();
    }

    public Date getWorkUploadTime() {
        return workUploadTime;
    }

    public void setWorkUploadTime(Date workUploadTime) {
        this.workUploadTime = workUploadTime;
    }

    public String getWorkRemark() {
        return workRemark;
    }

    public void setWorkRemark(String workRemark) {
        this.workRemark = workRemark == null ? null : workRemark.trim();
    }
}