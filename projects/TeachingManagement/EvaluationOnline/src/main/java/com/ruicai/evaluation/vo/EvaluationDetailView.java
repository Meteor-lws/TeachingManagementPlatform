package com.ruicai.evaluation.vo;

import com.ruicai.evaluation.po.evaluation.EvaluationDetail;

/**
 * 评价详情视图类
 *
 * Created by lws on 2017/4/24.
 */
public class EvaluationDetailView extends EvaluationDetail {
    private String evaluationTime;
    private String evaluationItem;
    private String satisfaction;

    public String getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(String evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public String getEvaluationItem() {
        return evaluationItem;
    }

    public void setEvaluationItem(String evaluationItem) {
        this.evaluationItem = evaluationItem;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }

    @Override
    public String toString() {
        return "EvaluationDetailView{" +
                "evaluationTime='" + evaluationTime + '\'' +
                ", evaluationItem='" + evaluationItem + '\'' +
                ", satisfaction='" + satisfaction + '\'' +
                "} " + super.toString();
    }
}
