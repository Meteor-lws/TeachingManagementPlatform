package com.ruicai.system.vo;

import com.ruicai.system.po.system.SystemResource;

/**
 * Created by 朱高 on 2017/4/26.
 */
public class RoleShow extends SystemResource {

    private String resVisibleName;

    private String resEnableName;

    public String getResVisibleName() {
        return resVisibleName;
    }

    public void setResVisibleName(String resVisibleName) {
        this.resVisibleName = resVisibleName;
    }

    public String getResEnableName() {
        return resEnableName;
    }

    public void setResEnableName(String resEnableName) {
        this.resEnableName = resEnableName;
    }

    @Override
    public String toString() {
        return "RoleShow{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", resourceTypeView='" + resourceTypeView + '\'' +
                ", resVisibleName='" + resVisibleName + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", resEnableName='" + resEnableName + '\'' +
                ", resourceDescribe='" + resourceDescribe + '\'' +
                ", resourceValue='" + resourceValue + '\'' +
                ", resourceVisible='" + resourceVisible + '\'' +
                ", resourceEnable='" + resourceEnable + '\'' +
                '}';
    }
}
