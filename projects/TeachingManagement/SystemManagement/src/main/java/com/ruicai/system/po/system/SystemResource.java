package com.ruicai.system.po.system;

public class SystemResource {
    private String id;

    private String parentId;

    private String resourceType;

    private String resourceTypeView;

    private String resourceName;

    private String resourceDescribe;

    private String resourceValue;

    private String resourceVisible;

    private String resourceEnable;

    public String getResourceDescribe() {
        return resourceDescribe;
    }

    public void setResourceDescribe(String resourceDescribe) {
        this.resourceDescribe = resourceDescribe;
    }

    public String getResourceTypeView() {
        return resourceTypeView;
    }

    public void setResourceTypeView(String resourceTypeView) {
        this.resourceTypeView = resourceTypeView;
    }

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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue == null ? null : resourceValue.trim();
    }

    public String getResourceVisible() {
        return resourceVisible;
    }

    public void setResourceVisible(String resourceVisible) {
        this.resourceVisible = resourceVisible;
    }

    public String getResourceEnable() {
        return resourceEnable;
    }

    public void setResourceEnable(String resourceEnable) {
        this.resourceEnable = resourceEnable;
    }

    @Override
    public String toString() {
        return "SystemResource{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", resourceTypeView='" + resourceTypeView + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", resourceDescribe='" + resourceDescribe + '\'' +
                ", resourceValue='" + resourceValue + '\'' +
                ", resourceVisible='" + resourceVisible + '\'' +
                ", resourceEnable='" + resourceEnable + '\'' +
                '}';
    }
}