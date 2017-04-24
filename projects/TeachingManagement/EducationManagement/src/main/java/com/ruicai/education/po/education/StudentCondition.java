package com.ruicai.education.po.education;

/**
 * Created by wy on 2017/4/19.
 */
public class StudentCondition {

    private String studentName;

    private String classId;

    private String studentGraduation;


    private Integer rows;

    private Integer page;


    private Integer startNum;

    private Integer endNum;

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getEndNum() {
        return endNum;
    }

    public void setEndNum(Integer endNum) {
        this.endNum = endNum;
    }

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

    public String getStudentGraduation() {
        return studentGraduation;
    }

    public void setStudentGraduation(String studentGraduation) {
        this.studentGraduation = studentGraduation;
    }
}
