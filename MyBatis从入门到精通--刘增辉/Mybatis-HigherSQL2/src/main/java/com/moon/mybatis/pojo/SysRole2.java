package com.moon.mybatis.pojo;

import java.util.Date;
import java.util.List;

public class SysRole2 {
	
    /**
     * 角色ID
     * 
     * id
     */
    private Long id;

    /**
     * 角色名
     * 
     * role_name
     */
    private String roleName;

    /**
     * 有效标志
     * 
     * enabled
     */
    private Integer enabled;

    /**
     * 创建人
     * 
     * create_by
     */
    // private Long createBy;

    /**
     * 创建时间
     * 
     * create_time
     */
    // private Date createTime;
    
    /**
     * 角色包含的权限列表 
     */
    private List<SysPrivilege> sysPrivilegeList;
	
	/**
	 * 创建信息 
	 */
	private CreateInfo createInfo;
	
	
	
	/**
	 * 重写 toString() 函数 
	 */
	@Override
	public String toString() {
		return "SysRole2 [id=" + id + ", roleName=" + roleName + ", enabled=" + enabled + ", sysPrivilegeList="
				+ sysPrivilegeList + ", createInfo=" + createInfo + "]";
	}
	
	/**
	 * 全参构造函数 
	 * 
	 * @param id
	 * @param roleName
	 * @param enabled
	 * @param sysPrivilegeList
	 * @param createInfo
	 */
	public SysRole2(Long id, String roleName, Integer enabled, List<SysPrivilege> sysPrivilegeList,
			CreateInfo createInfo) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.enabled = enabled;
		this.sysPrivilegeList = sysPrivilegeList;
		this.createInfo = createInfo;
	}
	
	/**
	 * 无参构造函数 
	 */
	public SysRole2() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public List<SysPrivilege> getSysPrivilegeList() {
		return sysPrivilegeList;
	}

	public void setSysPrivilegeList(List<SysPrivilege> sysPrivilegeList) {
		this.sysPrivilegeList = sysPrivilegeList;
	}

	public CreateInfo getCreateInfo() {
		return createInfo;
	}

	public void setCreateInfo(CreateInfo createInfo) {
		this.createInfo = createInfo;
	}
	
}
