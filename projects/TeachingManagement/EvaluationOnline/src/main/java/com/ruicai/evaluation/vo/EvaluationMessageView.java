package com.ruicai.evaluation.vo;

import com.ruicai.evaluation.po.evaluation.EvaluationMessage;

/**
 * 留言视图显示类
 *
 * Created by lws on 2017/4/21.
 */
public class EvaluationMessageView extends EvaluationMessage {
    private String to;
    private String from;
    private String status;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EvaluationMessageView{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", status='" + status + '\'' +
                "} " + super.toString();
    }
}
