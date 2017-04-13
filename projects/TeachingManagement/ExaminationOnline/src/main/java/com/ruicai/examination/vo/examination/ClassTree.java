package com.ruicai.examination.vo.examination;

import java.util.List;

/**
 * Created by 朱高 on 2017/4/13.
 */
public class ClassTree {
    private String id;
    private String text;
    private String state;
    private String iconCls;
    private String url;
    private int nid;
    private List<ClassTree> children;

    public List<ClassTree> getChildren() {
        return children;
    }

    public void setChildren(List<ClassTree> children) {
        this.children = children;
    }

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

    public String isState() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    @Override
    public String toString() {
        return "ClassTree{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", url='" + url + '\'' +
                ", nid=" + nid +
                ", children=" + children +
                '}';
    }
}
