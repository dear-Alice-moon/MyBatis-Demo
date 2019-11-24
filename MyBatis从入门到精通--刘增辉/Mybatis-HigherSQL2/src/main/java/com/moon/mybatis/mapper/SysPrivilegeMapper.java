package com.moon.mybatis.mapper;

import java.util.List;

import com.moon.mybatis.pojo.SysPrivilege;

public interface SysPrivilegeMapper {
	
	
	/**
	 * 通过 roleId 查询 List<SysPrivilege> 信息  
	 * 
	 * @param roleId
	 * @return
	 * 
	 * @author moon  2019/04/28  10:21  
	 */
	List<SysPrivilege> selectPrivilegeByRoleId(Long roleId);
	
	
	/**
	 * 通过主键查询 SysPrivilege 信息 
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  
	 */
    SysPrivilege selectByPrimaryKey(Long id);
}