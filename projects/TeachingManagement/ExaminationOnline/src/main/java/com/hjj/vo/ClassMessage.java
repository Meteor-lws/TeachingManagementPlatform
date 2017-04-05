package com.hjj.vo;

/**
 * 实体类添加注释
 *
 * Created by 朱高 on 2017/3/21.
 */
public class ClassMessage {
    private String id;
    private String ids;
    private String className;
    private String testPhase;
    private String testTime;
    private String invigilator;
    private String testPlace;
    private String stuName;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTestPhase() {
        return testPhase;
    }

    public void setTestPhase(String testPhase) {
        this.testPhase = testPhase;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getInvigilator() {
        return invigilator;
    }

    public void setInvigilator(String invigilator) {
        this.invigilator = invigilator;
    }

    public String getTestPlace() {
        return testPlace;
    }

    public void setTestPlace(String testPlace) {
        this.testPlace = testPlace;
    }

    @Override
    public String toString() {
        return "ClassMessage{" +
                "id='" + id + '\'' +
                ", ids='" + ids + '\'' +
                ", className='" + className + '\'' +
                ", testPhase='" + testPhase + '\'' +
                ", testTime='" + testTime + '\'' +
                ", invigilator='" + invigilator + '\'' +
                ", testPlace='" + testPlace + '\'' +
                '}';
    }
}
