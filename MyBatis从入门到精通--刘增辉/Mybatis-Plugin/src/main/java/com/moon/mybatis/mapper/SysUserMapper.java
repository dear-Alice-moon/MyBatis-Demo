package com.moon.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.moon.mybatis.pojo.SysUser;

public interface SysUserMapper {
	
	
	/**
	 * 查询所有的 SysUser 信息
	 * 
	 * @return
	 * 
	 * @author moon  2019/10/20  23:22
	 */
	List<SysUser> selectAllUser();
	
	
	/**
	 * 通过主键查询用户信息，测试自写的小驼峰命名插件。
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/09/14  17:22
	 */
	Map<String, Object> selectByKeyId(Long id);
	
	
	/**
	 * 通过主键查询用户信息， 自动生成。
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/09/07  21:17
	 */
    SysUser selectByPrimaryKey(Long id);
    
}