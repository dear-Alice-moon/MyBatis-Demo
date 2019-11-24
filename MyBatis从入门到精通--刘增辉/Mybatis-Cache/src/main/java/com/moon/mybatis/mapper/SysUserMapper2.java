package com.moon.mybatis.mapper;

import com.moon.mybatis.pojo.SysUser;

/**
 * 通过在mapper.xml中配置，开启MyBatis二级缓存。
 * 
 * @author moon  2019/08/18  17:16  
 *
 */
public interface SysUserMapper2 {
	
	
	/**
	 * 根据主键删除 SysUser 信息 
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/06/29  17:04  
	 */
	Integer deleteSysUser(Long id);
	
	
	/**
	 * 更新 SysUser 信息
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/06/29  17:02  
	 */
	Integer updateSysUser(SysUser sysUser);
	
	
	/**
	 * 更新 SysUser 信息
	 * 该更新语句主要用于测试 Mybatis框架 更新功能，其SQL语句有缺陷！
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/06/29  17:02  
	 */
	Integer updateSysUser2(SysUser sysUser);
	
	
	/**
	 * 新增 SysUser 信息  
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/06/29  16:58  
	 */
	Integer insertSysUser(SysUser sysUser);  
	
	
	/**
	 * 通过主键查询 SysUser 信息 
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/06/29  16:43  
	 */
    SysUser selectByPrimaryKey(Long id);
    
}