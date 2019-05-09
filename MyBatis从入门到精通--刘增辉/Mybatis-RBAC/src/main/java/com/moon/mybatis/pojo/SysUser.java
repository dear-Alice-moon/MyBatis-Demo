package com.moon.mybatis.pojo;

import java.util.Arrays;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户表
 * @author moon
 *
 */
public class SysUser {
	
	/**
	 * 用户ID
	 */
	private Long id;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 密码
	 */
	private String userPassword;
	
	/**
	 * 邮箱
	 */
	private String userEmail;
	
	/**
	 * 简介
	 */
	private String userInfo;
	
	/**
	 * 头像
	 */
	private byte[] headImg;
	
	/**
	 * 创建时间
	 */
	@JSONField(format ="yyyy-MM-dd HH:mm:ss")
	private Date createTime;      // 共7个字段      @moon  2019/01/26  10:28                        
	
	
	
	
	/**
	 * 重写toString()函数
	 */
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userInfo=" + userInfo + ", headImg=" + Arrays.toString(headImg) + ", createTime="
				+ createTime + "]";
	}
	
	
	/**
	 * 有参构造函数，仅含主键id
	 * 
	 * @param id
	 * 
	 * @author moon  2019/02/12  15:51
	 */
	public SysUser(Long id) {
		super();
		this.id = id;
	}

	
	/**
	 * 全参构造函数
	 * @param id
	 * @param userName
	 * @param userPassword
	 * @param userEmail
	 * @param userInfo
	 * @param headImg
	 * @param createTime
	 */
	public SysUser(Long id, String userName, String userPassword, String userEmail, String userInfo, byte[] headImg,
			Date createTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userInfo = userInfo;
		this.headImg = headImg;
		this.createTime = createTime;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
