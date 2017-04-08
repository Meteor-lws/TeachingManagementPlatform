package com.ruicai.system.po;

public class SysRes {
    private String id;

    private String parentId;

    private String resType;

    private String resName;

    private String resValue;

    private Short resVisible;

    private Short resEnable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType == null ? null : resType.trim();
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    public String getResValue() {
        return resValue;
    }

    public void setResValue(String resValue) {
        this.resValue = resValue == null ? null : resValue.trim();
    }

    public Short getResVisible() {
        return resVisible;
    }

    public void setResVisible(Short resVisible) {
        this.resVisible = resVisible;
    }

    public Short getResEnable() {
        return resEnable;
    }

    public void setResEnable(Short resEnable) {
        this.resEnable = resEnable;
    }
}