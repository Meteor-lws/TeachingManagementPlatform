package com.hjj.vo;

/**
 * Created by 朱高 on 2017/3/27.
 */
public class Student {
    private int id;
    private String text;

    public Student() {
    }

    public Student(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
