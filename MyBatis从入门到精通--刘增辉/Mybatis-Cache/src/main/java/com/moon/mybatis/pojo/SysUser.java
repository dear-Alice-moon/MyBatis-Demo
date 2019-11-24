package com.moon.mybatis.pojo;

import java.util.Arrays;
import java.util.Date;

/**
 * 用户表
 * 
 * 该mapper.java(interface接口)，用于测试验证MyBatis的一级缓存。
 * 
 * @author moon  2019/08/18  17:13  
 *
 */
public class SysUser {
	
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
     * 构造函数，不包含主键id属性。
     * 
     * @param userName
     * @param userPassword
     * @param userEmail
     * @param createTime
     * @param userInfo
     * @param headImg
     */
    public SysUser(String userName, String userPassword, String userEmail, Date createTime, String userInfo,
			byte[] headImg) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.createTime = createTime;
		this.userInfo = userInfo;
		this.headImg = headImg;
	}
    
    
	/**
     * 重写 toString() 
     */
    @Override
	public String toString() {
		return "SysUser [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", createTime=" + createTime + ", userInfo=" + userInfo + ", headImg="
				+ Arrays.toString(headImg) + "]";
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
     */
	public SysUser(Long id, String userName, String userPassword, String userEmail, Date createTime, String userInfo,
			byte[] headImg) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.createTime = createTime;
		this.userInfo = userInfo;
		this.headImg = headImg;
	}
	
	/**
	 * 无参构造函数  
	 */
	public SysUser() {
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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
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
        this.userInfo = userInfo == null ? null : userInfo.trim();
    }

    public byte[] getHeadImg() {
        return headImg;
    }

    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }
}