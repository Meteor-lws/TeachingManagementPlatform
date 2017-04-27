package com.ruicai.system.po.system;

import java.util.Arrays;

public class RoleToResourceKey {
    private String roleId;

    private String resId;

    private String[] ids;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }

    @Override
    public String toString() {
        return "RoleToResourceKey{" +
                "roleId='" + roleId + '\'' +
                ", resId='" + resId + '\'' +
                ", ids=" + Arrays.toString(ids) +
                '}';
    }
}