package com.ruicai.examination.vo.examination;

/**
 * Created by 朱高 on 2017/4/11.
 */
public class Management {
    private String id;
    private String ids;
    private String classId;
    private String className;
    private String examinationStage;
    private String testPhase;
    private String testTime;
    private String teacherId;
    private String invigilator;
    private String testPlace;
    private String paperId;
    private String stuName;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getExaminationStage() {
        return examinationStage;
    }

    public void setExaminationStage(String examinationStage) {
        this.examinationStage = examinationStage;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Management{" +
                "id='" + id + '\'' +
                ", ids='" + ids + '\'' +
                ", classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", examinationStage='" + examinationStage + '\'' +
                ", testPhase='" + testPhase + '\'' +
                ", testTime='" + testTime + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", invigilator='" + invigilator + '\'' +
                ", testPlace='" + testPlace + '\'' +
                ", paperId='" + paperId + '\'' +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
