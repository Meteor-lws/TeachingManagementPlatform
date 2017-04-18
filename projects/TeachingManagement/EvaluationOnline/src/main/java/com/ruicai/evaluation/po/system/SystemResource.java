package com.ruicai.evaluation.po.system;

public class SystemResource {
    private String id;

    private String parentId;

    private String resourceType;

    private String resourceName;

    private String resourceValue;

    private Short resourceVisible;

    private Short resourceEnable;

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

    public Short getResourceVisible() {
        return resourceVisible;
    }

    public void setResourceVisible(Short resourceVisible) {
        this.resourceVisible = resourceVisible;
    }

    public Short getResourceEnable() {
        return resourceEnable;
    }

    public void setResourceEnable(Short resourceEnable) {
        this.resourceEnable = resourceEnable;
    }
}