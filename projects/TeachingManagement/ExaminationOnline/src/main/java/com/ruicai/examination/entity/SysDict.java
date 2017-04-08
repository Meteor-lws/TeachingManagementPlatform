package com.ruicai.examination.entity;

public class SysDict {
    private String id;

    private String parentId;

    private String dictName;

    private String dictValue;

    private String dictDescribe;

    private Integer dictSortNumber;

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

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    public String getDictDescribe() {
        return dictDescribe;
    }

    public void setDictDescribe(String dictDescribe) {
        this.dictDescribe = dictDescribe == null ? null : dictDescribe.trim();
    }

    public Integer getDictSortNumber() {
        return dictSortNumber;
    }

    public void setDictSortNumber(Integer dictSortNumber) {
        this.dictSortNumber = dictSortNumber;
    }
}