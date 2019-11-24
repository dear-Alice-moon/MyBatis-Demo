package com.moon.mybatis.mapper;

import org.apache.ibatis.annotations.CacheNamespaceRef;

import com.moon.mybatis.pojo.SysRole5;

/**
 * 验证脏数据的参数和避免
 * 
 * 通过在mapper.java(interface接口)、mapper.xml中配置，开启MyBatis二级缓存。
 * 
 * @author moon  2019/08/31  16:08  
 *
 */
@CacheNamespaceRef(SysRoleMapper5.class)
public interface SysRoleMapper5 {
	
	
	/**
	 * 通过主键更新角色信息 
	 * 
	 * @param sysRole
	 * @return
	 * 
	 * @author moon  2019/09/07  19:19
	 */
	Integer updateRoleById(SysRole5 sysRole);
	
	
	/**
	 * 通过主键查询角色信息
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/09/07 18:41  
	 */
	SysRole5 selectRoleById(Long id);
	
}
