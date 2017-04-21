package com.ruicai.evaluation.po.evaluation;

public class EvaluationItem {
    protected String id;

    protected String itemType;

    protected String itemContent;

    protected Short itemEnable;

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

    @Override
    public String toString() {
        return "EvaluationItem{" +
                "id='" + id + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemContent='" + itemContent + '\'' +
                ", itemEnable=" + itemEnable +
                '}';
    }
}