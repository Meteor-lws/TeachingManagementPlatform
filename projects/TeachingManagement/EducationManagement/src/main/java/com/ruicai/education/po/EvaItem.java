package com.ruicai.education.po;

public class EvaItem {
    private String id;

    private String itemType;

    private String itemContent;

    private Short itemEnable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent == null ? null : itemContent.trim();
    }

    public Short getItemEnable() {
        return itemEnable;
    }

    public void setItemEnable(Short itemEnable) {
        this.itemEnable = itemEnable;
    }
}