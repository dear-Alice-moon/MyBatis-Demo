package com.moon.mybatis.pojo;

import java.util.Date;
import java.util.List;

import com.moon.mybatis.enums.Enabled;

public class SysRole3 {

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
	private Enabled enabled;  // 在这里，修改了 'enabled' 变量的数据类型。      

	/**
	 * 创建人
	 * 
	 * create_by
	 */
	private Long createBy;

	/**
	 * 创建时间
	 * 
	 * create_time
	 */
	private Date createTime;

	/**
	 * 角色包含的权限列表
	 */
	private List<SysPrivilege> sysPrivilegeList;
	
	
	/**
	 * 全参构造函数  
	 */
	@Override
	public String toString() {
		return "SysRole3 [id=" + id + ", roleName=" + roleName + ", enabled=" + enabled + ", createBy=" + createBy
				+ ", createTime=" + createTime + ", sysPrivilegeList=" + sysPrivilegeList + "]";
	}
	
	/**
	 * 全参构造函数  
	 * 
	 * @param id
	 * @param roleName
	 * @param enabled
	 * @param createBy
	 * @param createTime
	 * @param sysPrivilegeList
	 */
	public SysRole3(Long id, String roleName, Enabled enabled, Long createBy, Date createTime,
			List<SysPrivilege> sysPrivilegeList) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.enabled = enabled;
		this.createBy = createBy;
		this.createTime = createTime;
		this.sysPrivilegeList = sysPrivilegeList;
	}
	
	/**
	 * 无参构造函数  
	 */
	public SysRole3() {
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

	public Enabled getEnabled() {
		return enabled;
	}

	public void setEnabled(Enabled enabled) {
		this.enabled = enabled;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<SysPrivilege> getSysPrivilegeList() {
		return sysPrivilegeList;
	}

	public void setSysPrivilegeList(List<SysPrivilege> sysPrivilegeList) {
		this.sysPrivilegeList = sysPrivilegeList;
	}
	
}
