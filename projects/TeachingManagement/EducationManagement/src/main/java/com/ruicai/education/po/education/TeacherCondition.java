package com.ruicai.education.po.education;

/**
 * Created by wy on 2017/4/13.
 */
public class TeacherCondition {
    private String id;

    private String teacherName;

    private String teacherType;


    private Integer rows;

    private char[] page;


    private Integer startNum = 0;

    private Integer endNum = 20;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public char[] getPage() {
        return page;
    }

    public void setPage(char[] page) {
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
}
