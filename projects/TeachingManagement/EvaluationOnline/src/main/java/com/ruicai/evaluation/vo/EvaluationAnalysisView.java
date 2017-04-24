package com.ruicai.evaluation.vo;

import com.ruicai.evaluation.po.education.EducationTeacher;

import java.util.List;

/**
 * 评价分析视图类
 *
 * Created by lws on 2017/4/24.
 */
public class EvaluationAnalysisView extends EducationTeacher {
    private String state;
    private String userName;
    private String className;
    private Short evaluationScore;
    private double averageScore;
    private List<EvaluationView> children;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Short getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(Short evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public List<EvaluationView> getChildren() {
        return children;
    }

    public void setChildren(List<EvaluationView> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "EvaluationAnalysisView{" +
                "state='" + state + '\'' +
                ", userName='" + userName + '\'' +
                ", className='" + className + '\'' +
                ", evaluationScore=" + evaluationScore +
                ", averageScore=" + averageScore +
                ", children=" + children +
                "} " + super.toString();
    }
}
