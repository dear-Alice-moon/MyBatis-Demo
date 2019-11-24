package com.moon.mybatis.mapper;

import org.apache.ibatis.annotations.CacheNamespaceRef;

import com.moon.mybatis.pojo.SysRole4;

/**
 * 使用mybatis-redis，开启MyBatis二级缓存。
 * 
 * @author moon  2019/08/18  17:09
 *
 */
@CacheNamespaceRef(SysRoleMapper4.class)
public interface SysRoleMapper4 {
	
	
	/**
	 * 通过主键查询角色信息
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/04/26  14:41  
	 */
	SysRole4 selectRoleById(Long id);
	
	
	/**
	 * 通过主键查询角色信息，自动生成。  
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/04/26  14:23  
	 */
    SysRole4 selectByPrimaryKey(Long id);
    
}