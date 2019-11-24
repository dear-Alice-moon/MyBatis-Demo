package com.moon.mybatis.pojo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * 验证脏数据的参数和避免
 * 
 * 开启二级缓存，实体类需要实现 java.io.Serializable 
 * 
 * @author moon  2019/08/31  16:08  
 *
 */
public class SysUser3 implements Serializable {
	
	private static final long serialVersionUID = 6320941908222932112L;
	
	/**
     * 用户ID
     * 
     * id
     */
    private Long id;

    /**
     * 用户名
     * 
     * user_name
     */
    private String userName;

    /**
     * 密码
     * 
     * user_password
     */
    private String userPassword;

    /**
     * 邮箱
     * 
     * user_email
     */
    private String userEmail;

    /**
     * 创建时间
     * 
     * create_time
     */
    private Date createTime;

    /**
     * 简介
     * 
     * user_info
     */
    private String userInfo;

    /**
     * 头像
     * 
     * head_img
     */
    private byte[] headImg;
    
    /**
     * 用户角色
     */
    private SysRole5 role;
    
    
    
    
    /**
     * 重写 toString() 函数 
     */
    @Override
	public String toString() {
		return "SysUser3 [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", createTime=" + createTime + ", userInfo=" + userInfo + ", headImg="
				+ Arrays.toString(headImg) + ", role=" + role + "]";
	}
	
	
	/**
	 * 全参构造函数  
	 * 
	 * @param id
	 * @param userName
	 * @param userPassword
	 * @param userEmail
	 * @param createTime
	 * @param userInfo
	 * @param headImg
	 * @param role
	 */
	public SysUser3(Long id, String userName, String userPassword, String userEmail, Date createTime, String userInfo,
			byte[] headImg, SysRole5 role) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.createTime = createTime;
		this.userInfo = userInfo;
		this.headImg = headImg;
		this.role = role;
	}
	
	
	/**
	 * 无参构造函数 
	 */
	public SysUser3() {
		super();
		
	}
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public byte[] getHeadImg() {
		return headImg;
	}

	public void setHeadImg(byte[] headImg) {
		this.headImg = headImg;
	}
	
	public SysRole5 getRole() {
		return role;
	}
	
	public void setRole(SysRole5 role) {
		this.role = role;
	}
	
}
