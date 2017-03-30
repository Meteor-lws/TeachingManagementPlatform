package com.ruicai.evaluation.dto;

import com.ruicai.evaluation.entity.Evaluation;

/**
 * 评价项修改传输类
 * <p>
 * Created by lws on 2017/3/27.
 */
public class EvaluationEditor {
    private int index;
    private Evaluation evaluation;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public String toString() {
        return "EvaluationEditor{" +
                "index=" + index +
                ", evaluation=" + evaluation +
                '}';
    }
}
