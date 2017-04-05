package com.ruicai.evaluation.entity;

/**
 * 评价项实体类
 *
 * Created by lws on 2017/4/4.
 */
public class EvaluationItem {
    private int id;
    private int type;
    private boolean enable;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EvaluationItem{" +
                "id=" + id +
                ", type=" + type +
                ", enable=" + enable +
                ", content='" + content + '\'' +
                '}';
    }
}
