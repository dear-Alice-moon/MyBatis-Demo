package com.moon.mybatis.pojo;

/**
 * 用户角色关联表
 * @author moon
 *
 */
public class SysUserRole {
	
	/**
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 角色ID
	 */
	private Long roleId;
	
	
	/**
	 * 重写toString()函数
	 */
	@Override
	public String toString() {
		return "SysUserRole [userId=" + userId + ", roleId=" + roleId + "]";
	}
	
	/**
	 * 全参构造函数
	 * @param userId
	 * @param roleId
	 */
	public SysUserRole(Long userId, Long roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}
	
	/**
	 * 无参构造函数
	 */
	public SysUserRole() {
		super();
	}
	
	
	
	
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
