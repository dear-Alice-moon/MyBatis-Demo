package com.moon.mybatis.pojo;

import java.util.Date;

/**
 * 角色表
 * @author moon
 *
 */
public class SysRole {
	
	/**
	 * 角色ID
	 */
	private Long id;
	
	/**
	 * 角色名
	 */
	private String roleName;
	
	/**
	 * 有效标志
	 */
	private Integer enabled;
	
	/**
	 * 创建人
	 */
	private Long createBy;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	
	
	/**
	 * 重写toString()函数
	 */
	@Override
	public String toString() {
		return "SysRole [id=" + id + ", roleName=" + roleName + ", enabled=" + enabled + ", createBy=" + createBy
				+ ", createTime=" + createTime + "]";
	}
	
	
	/**
	 * 有参构造函数，仅含enabled参数.
	 * 
	 * @param enabled
	 * 
	 * @author moon  2019/02/12  15:54    
	 */
	public SysRole(Integer enabled) {
		super();
		this.enabled = enabled;
	}


	/**
	 * 全参构造函数
	 * @param id
	 * @param roleName
	 * @param enabled
	 * @param createBy
	 * @param createTime
	 */
	public SysRole(Long id, String roleName, Integer enabled, Long createBy, Date createTime) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.enabled = enabled;
		this.createBy = createBy;
		this.createTime = createTime;
	}
	
	
	/**
	 * 无参构造函数
	 */
	public SysRole() {
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
	
}
