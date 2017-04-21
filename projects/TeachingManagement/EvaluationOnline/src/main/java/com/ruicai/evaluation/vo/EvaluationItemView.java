package com.ruicai.evaluation.vo;

import com.ruicai.evaluation.po.evaluation.EvaluationItem;

/**
 * 评价项视图显示类
 *
 * Created by lws on 2017/4/18.
 */
public class EvaluationItemView extends EvaluationItem {
    private String type;
    private String enable;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "EvaluationItemView{" +
                "type='" + type + '\'' +
                ", enable='" + enable + '\'' +
                "} " + super.toString();
    }
}
