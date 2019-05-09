package com.moon.mybatis.pojo;

import java.util.Date;

public class SysRole2 {
	
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
	 * 用户信息
	 * 
	 * 新添加的信息                
	 */
	private SysUser user;
	
	
	
	
	
	
	
	
	
	/**
	 * 重写 toString() 函数      
	 */
	@Override
	public String toString() {
		return "SysRole2 [id=" + id + ", roleName=" + roleName + ", enabled=" + enabled + ", createBy=" + createBy
				+ ", createTime=" + createTime + "]";
	}
	
	


	/**
	 * 全参构造函数
	 * 
	 * @param id
	 * @param roleName
	 * @param enabled
	 * @param createBy
	 * @param createTime
	 * @param user
	 */
	public SysRole2(Long id, String roleName, Integer enabled, Long createBy, Date createTime, SysUser user) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.enabled = enabled;
		this.createBy = createBy;
		this.createTime = createTime;
		this.user = user;
	}
	
	
	/**
	 * 不包含新增的 SysUser 字段
	 * 
	 * @param id
	 * @param roleName
	 * @param enabled
	 * @param createBy
	 * @param createTime
	 */
	public SysRole2(Long id, String roleName, Integer enabled, Long createBy, Date createTime) {
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

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}
	
	
}
