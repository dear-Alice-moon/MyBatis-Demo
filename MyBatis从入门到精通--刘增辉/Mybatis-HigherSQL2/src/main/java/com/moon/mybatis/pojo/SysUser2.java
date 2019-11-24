package com.moon.mybatis.pojo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SysUser2 {
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
    private List<SysRole> sysRoleList;
    

    /**
     * 重写 toString()函数 
     */
    @Override
	public String toString() {
		return "SysUser2 [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", createTime=" + createTime + ", userInfo=" + userInfo + ", headImg="
				+ Arrays.toString(headImg) + ", sysRoleList=" + sysRoleList + "]";
	}
    
	
	/**
	 * 全参构造函数，包含sysRoleList属性. 
	 * 
	 * @param id
	 * @param userName
	 * @param userPassword
	 * @param userEmail
	 * @param createTime
	 * @param userInfo
	 * @param headImg
	 * @param sysRoleList
	 */
	public SysUser2(Long id, String userName, String userPassword, String userEmail, Date createTime, String userInfo,
			byte[] headImg, List<SysRole> sysRoleList) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.createTime = createTime;
		this.userInfo = userInfo;
		this.headImg = headImg;
		this.sysRoleList = sysRoleList;
	}
	
	
	/**
	 * 全参构造函数，不包含sysRole属性.
	 * 
	 * @param id
	 * @param userName
	 * @param userPassword
	 * @param userEmail
	 * @param createTime
	 * @param userInfo
	 * @param headImg
	 */
	public SysUser2(Long id, String userName, String userPassword, String userEmail, Date createTime, String userInfo,
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
	public SysUser2() {
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

	public List<SysRole> getSysRoleList() {
		return sysRoleList;
	}

	public void setSysRoleList(List<SysRole> sysRoleList) {
		this.sysRoleList = sysRoleList;
	}
	
	
}