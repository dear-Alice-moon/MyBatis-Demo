package com.moon.mybatis.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.cache.decorators.FifoCache;

import com.moon.mybatis.pojo.SysRole;

/**
 * 通过在mapper.java(interface接口)中配置，开启MyBatis二级缓存。
 * 
 * @author moon  2019/08/18  17:07  
 *
 */
@CacheNamespace(eviction = FifoCache.class, flushInterval = 6000, size = 512, readWrite = true)
public interface SysRoleMapper {
	
	
	/**
	 * 通过主键查询角色信息
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/04/26  14:41  
	 */
	SysRole selectRoleById(Long id);
	
	
	/**
	 * 通过主键查询角色信息，自动生成。  
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/04/26  14:23  
	 */
    SysRole selectByPrimaryKey(Long id);
    
}