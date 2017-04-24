package com.ruicai.evaluation.vo;

import com.ruicai.evaluation.po.evaluation.Evaluation;

/**
 * 评价视图类
 *
 * Created by lws on 2017/4/24.
 */
public class EvaluationView extends Evaluation {
    private String state;
    private String userName;
    private String className;
    private double averageScore;

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

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "EvaluationView{" +
                "state='" + state + '\'' +
                ", userName='" + userName + '\'' +
                ", className='" + className + '\'' +
                ", averageScore=" + averageScore +
                "} " + super.toString();
    }
}
