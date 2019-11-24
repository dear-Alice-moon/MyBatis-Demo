package com.moon.mybatis.mapper;

import org.apache.ibatis.annotations.CacheNamespaceRef;

import com.moon.mybatis.pojo.SysRole3;

/**
 * 使用ehcache-cache，开启MyBatis二级缓存。
 * 
 * @author moon  2019/08/18  17:09
 *
 */
@CacheNamespaceRef(SysRoleMapper3.class)
public interface SysRoleMapper3 {
	
	
	/**
	 * 通过主键查询角色信息
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/04/26  14:41  
	 */
	SysRole3 selectRoleById(Long id);
	
	
	/**
	 * 通过主键查询角色信息，自动生成。  
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/04/26  14:23  
	 */
    SysRole3 selectByPrimaryKey(Long id);
    
}