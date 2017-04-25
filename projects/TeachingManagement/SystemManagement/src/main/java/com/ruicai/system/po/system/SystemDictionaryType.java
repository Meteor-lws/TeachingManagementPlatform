package com.ruicai.system.po.system;

public class SystemDictionaryType {
    private String id;

    private String parentId;

    private String dictionaryTypeName;

    private String dictionaryTypeDescribe;

    private Short dictionaryTypeSortNumber;

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

    public String getDictionaryTypeName() {
        return dictionaryTypeName;
    }

    public void setDictionaryTypeName(String dictionaryTypeName) {
        this.dictionaryTypeName = dictionaryTypeName == null ? null : dictionaryTypeName.trim();
    }

    public String getDictionaryTypeDescribe() {
        return dictionaryTypeDescribe;
    }

    public void setDictionaryTypeDescribe(String dictionaryTypeDescribe) {
        this.dictionaryTypeDescribe = dictionaryTypeDescribe == null ? null : dictionaryTypeDescribe.trim();
    }

    public Short getDictionaryTypeSortNumber() {
        return dictionaryTypeSortNumber;
    }

    public void setDictionaryTypeSortNumber(Short dictionaryTypeSortNumber) {
        this.dictionaryTypeSortNumber = dictionaryTypeSortNumber;
    }
}