package com.moon.mybatis.mapper;

import java.util.List;

import com.moon.mybatis.pojo.SysUser2;

/**
 * 一对多映射 
 * 
 * @author moon    2019/03/25  16:35  
 *
 */
public interface SysUserMapper2 {
	
	
	/**
	 * 一对多映射，collection集合标签嵌套查询.
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/04/26  21:49  
	 */
	SysUser2 selectAllUserAndRolesSelect(Long id);
	
	
	/**
	 * 一对多映射，多层嵌套，一个用户获取多个角色，一个角色获取多个权限.
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/04/26  9:50  
	 */
	SysUser2 selectAllUserAndRoles4(Long id);
	
	
	/**
	 * 一对多映射，验证<resultMap>标签的子标签<id>的作用
	 * 获取所有的用户以及对应的所有角色信息
	 * 
	 * @return
	 * 
	 * @author moon  2019/04/21  16:39   
	 */
	List<SysUser2> selectAllUserAndRoles3();
	
	
	/**
	 * 一对多映射
	 * 根据用户ID获取用户及对应的所有角色信息
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/03/25  20:18 
	 */
	List<SysUser2> selectAllUserAndRoles2(Long id);
	
	
	/**
	 * 一对多映射
	 * 获取所有的用户以及对应的所有角色信息
	 * 
	 * @return
	 * 
	 * @author moon  2019/03/25  20:15  
	 */
	List<SysUser2> selectAllUserAndRoles();
	
}
