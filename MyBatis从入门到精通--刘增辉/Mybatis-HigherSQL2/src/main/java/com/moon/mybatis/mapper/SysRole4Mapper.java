package com.moon.mybatis.mapper;

import com.moon.mybatis.pojo.SysRole4;

public interface SysRole4Mapper {
	
	/**
	 * 更新 sysRole4 信息 
	 * 
	 * @param sysRole
	 * @return
	 */
	Integer updateSysRole4ById(SysRole4 sysRole);
	
	
	/**
	 * 通过 id 查询 SysRole4 信息 
	 * 
	 * @param id
	 * @return
	 */
	SysRole4 selectSysRole4ById(Long id);
	
}
