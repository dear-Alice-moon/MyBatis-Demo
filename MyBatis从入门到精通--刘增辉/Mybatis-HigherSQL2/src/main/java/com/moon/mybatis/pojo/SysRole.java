package com.moon.mybatis.pojo;

import java.util.Date;
import java.util.List;

public class SysRole {
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
     * 重写 toString() 函数 
     */
    @Override
	public String toString() {
		return "SysRole [id=" + id + ", roleName=" + roleName + ", enabled=" + enabled + ", createBy=" + createBy
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
    public SysRole(Long id, String roleName, Integer enabled, Long createBy, Date createTime,
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
     * 全参构造函数，不包含 List<SysPrivilege>  
     * 
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
        this.roleName = roleName == null ? null : roleName.trim();
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

	public List<SysPrivilege> getSysPrivilegeList() {
		return sysPrivilegeList;
	}

	public void setSysPrivilegeList(List<SysPrivilege> sysPrivilegeList) {
		this.sysPrivilegeList = sysPrivilegeList;
	}
    
}