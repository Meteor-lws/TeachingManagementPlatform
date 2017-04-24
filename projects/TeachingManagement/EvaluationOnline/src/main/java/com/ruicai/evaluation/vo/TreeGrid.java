package com.ruicai.evaluation.vo;

import java.util.List;

/**
 * TreeGrid实体类
 *
 * Created by lws on 2017/4/24.
 */
public class TreeGrid {
    private String id;
    private String state;
    private List<TreeGrid> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<TreeGrid> getChildren() {
        return children;
    }

    public void setChildren(List<TreeGrid> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeGrid{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", children=" + children +
                '}';
    }
}
