package com.moon.mybatis.pojo;

public class SysRolePrivilege {
	
	private Long roleId;
	
	private Long privilegeId;
	
	
	/**
	 * 重写toString()函数
	 */
	@Override
	public String toString() {
		return "SysRolePrivilege [roleId=" + roleId + ", privilegeId=" + privilegeId + "]";
	}
	
	/**
	 * 全参构造函数
	 * @param roleId
	 * @param privilegeId
	 */
	public SysRolePrivilege(Long roleId, Long privilegeId) {
		super();
		this.roleId = roleId;
		this.privilegeId = privilegeId;
	}
	
	/**
	 * 无参构造函数                              
	 */
	public SysRolePrivilege() {
		super();
	}
	
	
	
	
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
