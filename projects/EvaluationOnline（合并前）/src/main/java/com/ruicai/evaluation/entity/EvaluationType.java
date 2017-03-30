package com.ruicai.evaluation.entity;

/**
 * 评价类型实体类
 * <p>
 * Created by lws on 2017/3/27.
 */
public class EvaluationType {
    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "EvaluationType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
