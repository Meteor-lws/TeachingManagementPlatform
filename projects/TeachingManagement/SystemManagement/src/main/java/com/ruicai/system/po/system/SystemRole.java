package com.ruicai.system.po.system;

public class SystemRole {
    /**
     * 角色ID
     */
    protected String id;

    /**
     * 父角色ID
     */
    protected String parentId;

    /**
     * 角色表示符
     */
    protected String roleCode;

    /**
     * 角色名称
     */
    protected String roleName;

    /**
     * 角色描述
     */
    protected String roleDescribe;

    /**
     * 是否继承父角色资源
     */
    protected Short roleInherit;

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

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe == null ? null : roleDescribe.trim();
    }

    public Short getRoleInherit() {
        return roleInherit;
    }

    public void setRoleInherit(Short roleInherit) {
        this.roleInherit = roleInherit;
    }

    @Override
    public String toString() {
        return "SystemRole{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDescribe='" + roleDescribe + '\'' +
                ", roleInherit=" + roleInherit +
                '}';
    }
}