package com.moon.mybatis.mapper;

import java.util.List;

import com.moon.mybatis.pojo.SysUser;

public interface SysUserMapper {
	
	
	/**
	 * 查询全部用户       2019/01/20  12:15       
	 * 
	 * @return
	 */
	List<SysUser> selectAll();
	
}
