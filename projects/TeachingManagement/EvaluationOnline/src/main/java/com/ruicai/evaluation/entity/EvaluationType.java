package com.ruicai.evaluation.entity;

/**
 * 评价类型实体类
 *
 * Created by lws on 2017/4/4.
 */
public class EvaluationType {
    private int id;
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EvaluationType{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
