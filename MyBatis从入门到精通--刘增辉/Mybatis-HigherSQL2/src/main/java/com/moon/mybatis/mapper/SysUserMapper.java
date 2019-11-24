package com.moon.mybatis.mapper;

import com.moon.mybatis.pojo.SysUser;

/**
 * 一对一映射  
 * 
 * @author moon    2019/03/25  16:33  
 *
 */
public interface SysUserMapper {
	
	
	/**
	 * 一对一映射，使用resultMap的association标签配置一对一映射，
	 * association标签的select属性值来源于SysRoleMapper.xml文件中id为'selectRoleById'的查询语句，
	 * association标签的fetchType属性值lazy，用于设置延迟加载。 
	 * 
	 * 根据用户ID查询用户信息、用户角色信息.
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/03/19  15:41  
	 */
	SysUser selectUserAndRoleById8(Long id);
	
	
	/**
	 * 一对一映射，使用resultMap的association标签配置一对一映射，association标签的select属性值来源于SysRoleMapper.xml文件中id为'selectRoleById'的查询语句
	 * 根据用户ID查询用户信息、用户角色信息.
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/03/19  11:36  
	 */
	SysUser selectUserAndRoleById7(Long id);
	
	
	/**
	 * 一对一映射，使用resultMap的association标签配置一对一映射，association标签的resultMap属性值来源于SysRoleMapper.xml文件配置信息 。
	 * 根据用户ID查询用户信息、用户角色信息.
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/03/08  18:40 
	 */
	SysUser selectUserAndRoleById6(Long id);
	
	
	/**
	 * 一对一映射，使用resultMap的association标签配置一对一映射，association标签的resultMap属性值来源于当前文件配置的信息.
	 * 根据用户ID查询用户信息、用户角色信息.
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/03/08  18:39 
	 */
	SysUser selectUserAndRoleById5(Long id);
	
	
	/**
	 * 一对一映射，使用resultMap的association标签配置一对一映射，association标签的javaType属性值指向SysRole实体类。
	 * 根据用户ID查询用户信息、用户角色信息.
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/03/08  15:42 
	 */
	SysUser selectUserAndRoleById4(Long id);
	
	
	/**
	 * 一对一映射，Mybatis支持resultMap继承，使用resultMap的支持继承特点进行配置一对一映射.
	 * 根据用户ID查询用户信息、用户角色信息.
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/03/08  11:20 
	 */
	SysUser selectUserAndRoleById3(Long id);
	
	
	/**
	 * 一对一映射，使用resultMap配置一对一映射关系.
	 * 根据用户ID查询用户信息、用户角色信息.
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/03/08  11:20 
	 */
	SysUser selectUserAndRoleById2(Long id);
	
	
    /**
     * 一对一映射，使用自动映射处理一对一关系.
     * 根据用户ID查询用户信息、用户角色信息.
     * 
     * @param id
     * @return
     * 
     * @author moon  2019/03/07  17:22 
     */
    SysUser selectUserAndRoleById(Long id);
	
    
	/**
	 * Mybatis逆向生成工具生成的函数，根据用户ID查询用户信息.
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/03/07  17:22
	 */
    SysUser selectByPrimaryKey(Long id);
    
}