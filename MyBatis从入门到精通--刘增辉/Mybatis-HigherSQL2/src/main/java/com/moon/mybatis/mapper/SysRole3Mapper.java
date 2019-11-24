package com.moon.mybatis.mapper;

import com.moon.mybatis.pojo.SysRole3;

public interface SysRole3Mapper {
	
	
	/**
	 * 更新 sysRole3 信息 
	 * 
	 * @param sysRole
	 * @return
	 */
	Integer updateSysRole3ById(SysRole3 sysRole);
	
	
	/**
	 * 通过 id 查询 SysRole3 信息 
	 * 
	 * @param id
	 * @return
	 */
	SysRole3 selectSysRole3ById(Long id);
	
}
