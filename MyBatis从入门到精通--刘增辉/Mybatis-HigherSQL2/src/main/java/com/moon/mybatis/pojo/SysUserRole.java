package com.moon.mybatis.pojo;

public class SysUserRole {
	
    /**
     * 用户ID
     * 
     * user_id
     */
    private Long userId;

    /**
     * 角色ID
     * 
     * role_id
     */
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}