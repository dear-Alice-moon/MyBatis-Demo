package com.moon.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 验证脏数据的参数和避免
 * 
 * @author moon  2019/08/31  16:08  
 *
 */
public class SysRole5 implements Serializable {
	
	private static final long serialVersionUID = 6320941908222932112L;
	
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
     * 重写 toString() 函数 
     */
	@Override
	public String toString() {
		return "SysRole5 [id=" + id + ", roleName=" + roleName + ", enabled=" + enabled + ", createBy=" + createBy
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
	 */
	public SysRole5(Long id, String roleName, Integer enabled, Long createBy, Date createTime) {
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
	public SysRole5() {
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
