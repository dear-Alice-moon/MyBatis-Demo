package com.moon.mybatis.mapper;

import com.moon.mybatis.pojo.SysUser3;

/**
 * 验证脏数据的参数和避免
 * 
 * @author moon  2019/08/31  16:08  
 *
 */
public interface SysUserMapper3 {
	
	
	/**
	 * 通过 用户Id 查询用户及其角色信息 
	 * 
	 * @param id  用户ID
	 * @return
	 */
	SysUser3 selectUserAndRoleById(Long id);
	
}
