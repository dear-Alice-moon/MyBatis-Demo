package com.moon.mybatis.pojo;

public class SysRolePrivilege {
    /**
     * 角色ID
     * 
     * role_id
     */
    private Long roleId;

    /**
     * 权限ID
     * 
     * privilege_id
     */
    private Long privilegeId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }
}