package com.moon.mybatis.pojo;

import java.util.Date;

/**
 * 创建信息
 * 
 * @author moon
 *
 */
public class CreateInfo {
	
	/**
	 * 创建人 
	 */
	private String createBy;
	
	/**
	 * 创建时间 
	 */
	private Date createTime;
	
	
	
	/**
	 * 重写 toString()函数 
	 */
	@Override
	public String toString() {
		return "CreateInfo [createBy=" + createBy + ", createTime=" + createTime + "]";
	}
	
	/**
	 * 全参构造函数 
	 * 
	 * @param createBy
	 * @param createTime
	 */
	public CreateInfo(String createBy, Date createTime) {
		super();
		this.createBy = createBy;
		this.createTime = createTime;
	}
	
	/**
	 * 无参构造函数 
	 */
	public CreateInfo() {
		super();
	}
	
	
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
