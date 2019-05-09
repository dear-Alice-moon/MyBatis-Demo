package com.moon.mybatis.mapper;

import com.moon.mybatis.pojo.SysUser;

public interface SysUserMapper2 {
	
	
	/**
	 * 新增用户--函数4，Oracle数据库通过新增数据时，获取主键id值。
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/02  22:01      
	 */
	Integer insertSysUser4(SysUser sysUser);
	
	
	/**
	 * 新增用户--函数3，Mysql数据库通过新增数据时，获取返回的自增ID值。
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/02  21:57  
	 */
	Integer insertSysUser3(SysUser sysUser);
	
	
	/**
	 * 新增用户--函数2
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/01/28  15:13   
	 */
	Integer insertSysUser2(SysUser sysUser);
	
	
	/**
	 * 新增用户
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/01/26  10:18       
	 */
	Integer insertSysUser(SysUser sysUser);
	
}
