package com.moon.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.mybatis.pojo.SysRole;
import com.moon.mybatis.pojo.SysRole2;
import com.moon.mybatis.pojo.SysRoleExtend;
import com.moon.mybatis.pojo.SysUser;

public interface SysUserMapper {
	
	
	/**
	 * 多个接口参数的用法，使用 @Param 注解--JavaBean类型参数。
	 * 
	 * 根据用户id和角色的enabled状态获取用户的角色.
	 * 
	 * @param user
	 * @param role
	 * @return
	 * 
	 * @author moon  2019/02/12  11:17  
	 */
	List<SysRole> selectRolesByUserAndRole(@Param("user")SysUser user, @Param(value = "role") SysRole role);
	
	
	/**
	 * 多个接口参数的用法，使用 @Param 注解--基本数据类型参数。
	 * 
	 * 若不使用Map<K, V>传递多参数时，需要使用 @Param 注解修饰多参数 
	 * 
	 * 根据用户id和角色的enabled状态获取用户的角色。
	 * 
	 * @param userId
	 * @param enabled
	 * @return
	 * 
	 * @author moon  2019/02/12  10:10       
	 */
	List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param(value = "userId") Long userId, @Param(value = "enabled") Integer enabled);
	
	
	/**
	 * 传递JavaBean参数进行删除操作
	 * 
	 * 传递 sysUser 对象，进行删除操作。 该函数与  deleteById(Long id) 函数可同用 xml中id="deleteById" 的sql语句。
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/03  23:03
	 */
	Integer deleteById(SysUser sysUser);
	
	
	/**
	 * 传递单个参数进行删除操作            
	 * 
	 * 通过主键删除
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/02/03  22:54             
	 */
	Integer deleteById(Long id);
	
	
	/**
	 * 根据主键更新
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/03  10:46   
	 */
	Integer updateById(SysUser sysUser);
	
	
	/**
	 * 根据用户id查询获取角色信息，含新增的SysUser信息
	 * 
	 * @param userId
	 * @return
	 * 
	 * @author moon  2019/01/24  15:31 
	 */
	List<SysRole2> selectRolesByUserId3(Long userId);
	
	
	/**
	 * 根据用户id查询获取角色信息，含新增的SysUser信息
	 * 
	 * @param userId
	 * @return
	 * 
	 * @author moon   2019/01/24  15:29  
	 */
	List<SysRoleExtend> selectRolesByUserId2(Long userId);
	
	
	/**
	 * 根据用户id获取角色信息
	 * 
	 * @param userId
	 * @return
	 */
	List<SysRole> selectRolesByUserId(Long userId);
	
	
	/**
	 * 通过 id 查询用户       2019/01/19  18:23             
	 * @param id
	 * @return
	 */
	SysUser selectUserById(Long id);
	
	
	/**
	 * 查询全部用户       2019/01/20  12:15       
	 * 
	 * @return
	 */
	List<SysUser> selectAll();
	
	
	/**
	 * 查询全部用户       2019/01/20  12:39       
	 * 
	 * @return
	 */
	List<SysUser> selectAll2();
	
	
	/**
	 * 查询全部用户       2019/01/20  12:39       
	 * 
	 * @return
	 */
	List<SysUser> selectAll3();
	
	
}
