package com.ruicai.system.vo;

import java.util.List;

/**
 * EasyUI中Tree的实体类
 *
 * Created by lws on 2017/4/9.
 */
public class Tree {
    private String id;
    private String text;
    private String state;
    private String iconCls;
    private boolean checked;
    private List<Tree> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", checked=" + checked +
                ", children=" + children +
                '}';
    }
}
