package com.ruicai.evaluation.entity;

/**
 * 评价项实体类
 * <p>
 * Created by lws on 2017/3/27.
 */
public class Evaluation {
    private int id;
    private String enable;
    private String type;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", enable='" + enable + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
