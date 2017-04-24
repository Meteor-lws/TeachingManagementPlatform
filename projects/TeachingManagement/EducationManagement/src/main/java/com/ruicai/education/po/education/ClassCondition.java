package com.ruicai.education.po.education;

/**
 * Created by wy on 2017/4/24.
 */
public class ClassCondition {
    private String classStartDate;

    private String classEndDate;

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

    public String getClassStartDate() {
        return classStartDate;
    }

    public void setClassStartDate(String classStartDate) {
        this.classStartDate = classStartDate;
    }

    public String getClassEndDate() {
        return classEndDate;
    }

    public void setClassEndDate(String classEndDate) {
        this.classEndDate = classEndDate;
    }
}
