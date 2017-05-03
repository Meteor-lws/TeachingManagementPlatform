package com.ruicai.system.vo;

import com.ruicai.system.po.system.SystemResource;

/**
 * Created by 朱高 on 2017/4/26.
 */
public class RoleShow extends SystemResource {

    private String resVisibleName;

    private String resEnableName;

    private String roleCode;

    private String roleDescribe;

    private String roleInherit;

    public String getRoleInherit() {
        return roleInherit;
    }

    public void setRoleInherit(String roleInherit) {
        this.roleInherit = roleInherit;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

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
                "resVisibleName='" + resVisibleName + '\'' +
                ", resEnableName='" + resEnableName + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", roleDescribe='" + roleDescribe + '\'' +
                ", roleInherit='" + roleInherit + '\'' +
                "} " + super.toString();
    }
}
