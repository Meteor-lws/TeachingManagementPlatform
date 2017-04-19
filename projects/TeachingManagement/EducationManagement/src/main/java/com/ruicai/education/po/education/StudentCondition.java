package com.ruicai.education.po.education;

import java.sql.Timestamp;

/**
 * Created by wy on 2017/4/19.
 */
public class StudentCondition {

    private String studentName;

    private String classId;

    private Timestamp studentGraduation;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Timestamp getStudentGraduation() {
        return studentGraduation;
    }

    public void setStudentGraduation(Timestamp studentGraduation) {
        this.studentGraduation = studentGraduation;
    }
}
