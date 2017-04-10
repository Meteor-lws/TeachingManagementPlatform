package com.ruicai.examination.po.system;

public class SystemDictionary {
    private String id;

    private String parentId;

    private String dictionaryName;

    private String dictionaryValue;

    private String dictionaryDescribe;

    private Short dictionarySortNumber;

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

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName == null ? null : dictionaryName.trim();
    }

    public String getDictionaryValue() {
        return dictionaryValue;
    }

    public void setDictionaryValue(String dictionaryValue) {
        this.dictionaryValue = dictionaryValue == null ? null : dictionaryValue.trim();
    }

    public String getDictionaryDescribe() {
        return dictionaryDescribe;
    }

    public void setDictionaryDescribe(String dictionaryDescribe) {
        this.dictionaryDescribe = dictionaryDescribe == null ? null : dictionaryDescribe.trim();
    }

    public Short getDictionarySortNumber() {
        return dictionarySortNumber;
    }

    public void setDictionarySortNumber(Short dictionarySortNumber) {
        this.dictionarySortNumber = dictionarySortNumber;
    }
}