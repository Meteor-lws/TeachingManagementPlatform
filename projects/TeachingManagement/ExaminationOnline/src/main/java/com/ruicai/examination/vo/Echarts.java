package com.ruicai.examination.vo;

import java.util.List;

/**
 * Created by 朱高 on 2017/3/23.
 */
public class Echarts {
    private List categories;
    private List<List> data;
    private List legend;
    private String name;
    private int value;

    public Echarts(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Echarts() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    /*private Map<String, List<Integer>> map;

    public Map<String, List<Integer>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<Integer>> map) {
        this.map = map;
    }*/

    public List getLegend() {
        return legend;
    }

    public void setLegend(List legend) {
        this.legend = legend;
    }

    public List getCategories() {
        return categories;
    }

    public void setCategories(List categories) {
        this.categories = categories;
    }

    public List<List> getData() {
        return data;
    }

    public void setData(List<List> data) {
        this.data = data;
    }
}
