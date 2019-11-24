package com.moon.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表
 * 
 * 使用mybatis-redis，开启MyBatis二级缓存。
 * 
 * 若要使用mybatis-redis实现 MyBatis的二级缓存，MyBatis需要使用Serializable序列化缓存。
 * 该缓存类要求所有被序列化的对象必须实现Serializable(java.io.Serializable)接口。
 * 
 * @author moon  2019/08/18  17:09
 *
 */
public class SysRole4 implements Serializable {
	
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
		return "SysRole [id=" + id + ", roleName=" + roleName + ", enabled=" + enabled + ", createBy=" + createBy
				+ ", createTime=" + createTime + "]";
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
	public SysRole4(Long id, String roleName, Integer enabled, Long createBy, Date createTime) {
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
	public SysRole4() {
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
    
    
}