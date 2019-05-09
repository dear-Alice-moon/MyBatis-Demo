package com.moon.mybatis.mapper;

import org.apache.ibatis.annotations.SelectProvider;

import com.moon.mybatis.core.SysPrivilegeProvider;
import com.moon.mybatis.pojo.SysPrivilege;

/**
 * 基于注解开发，主要测试 'Provider' 注解功能     
 * 注解开发仅用于学习，不推荐在实际项目中运用.       
 * 
 * @author moon  2019/02/14  16:48  
 *
 */
public interface SysPrivilegeMapper {
	
	
	/**
	 * 通过使用 Provider注解进行查询功能.           
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/02/14  18:50  
	 */
	@SelectProvider(type = SysPrivilegeProvider.class, method = "selectPrivilegeById2")
	SysPrivilege selectSysPrivilegeById2(Long id);
	
	
	/**
	 * 通过使用 Provider注解进行查询功能.           
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/02/14  17:29  
	 */
	@SelectProvider(type = SysPrivilegeProvider.class, method = "selectPrivilegeById")
	SysPrivilege selectSysPrivilegeById(Long id);
	
}
