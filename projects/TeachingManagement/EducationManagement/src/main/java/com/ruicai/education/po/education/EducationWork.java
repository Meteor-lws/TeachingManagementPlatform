package com.ruicai.education.po.education;

import com.ruicai.education.util.MyDateFormate;

import java.sql.Timestamp;

public class EducationWork {
    private String id;

    private String teacherId;

    private String workType;

    private String workUrl;

    private Timestamp workUploadTime;

    private String teacherView;

    private String workRemark;

    private String workUploadTimeView;

    public String getWorkUploadTimeView() {
        return workUploadTimeView;
    }


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

    public Timestamp getWorkUploadTime() {
        return workUploadTime;
    }

    public void setWorkUploadTime(Timestamp workUploadTime) {
        this.workUploadTime = workUploadTime;
        this.workUploadTimeView = MyDateFormate.timeStampToString(workUploadTime);
    }

    public String getWorkRemark() {
        return workRemark;
    }

    public void setWorkRemark(String workRemark) {
        this.workRemark = workRemark == null ? null : workRemark.trim();
    }

    public String getTeacherView() {
        return teacherView;
    }

    public void setTeacherView(String teacherView) {
        this.teacherView = teacherView;
    }
}