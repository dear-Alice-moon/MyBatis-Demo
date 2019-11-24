package com.moon.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.moon.mybatis.pojo.SysUser2;

public interface SysUserMapper3 {
	
	
	/**
	 * 第四个存储过程  
	 * 
	 * 使用存储过程，根据用户id删除用户和用户的角色信息
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/05/01  20:24  
	 */
	Integer deleteUserById(Long id);
	
	
	/**
	 * 第三个存储过程  
	 * 
	 * 使用存储过程，保存用户信息和角色关联信息 
	 * 
	 * @param user
	 * @param roleIds
	 * @return
	 * 
	 * @author moon  2019/05/01  20:20  
	 */
	Integer insertUserAndRoles(@Param("user")SysUser2 user, @Param("roleIds") String roleIds);
	
	
	/**
	 * 第二个存储过程
	 * 
	 * 使用存储过程分页查询  
	 * 
	 * @param userName
	 * @param pageNum
	 * @param pageSize
	 * @param total 
	 * @return
	 * 
	 * @author moon  2019/05/01  17:24  
	 */
	List<SysUser2> selectUserPage(Map<String, Object> params);
	
	
	/**
	 * 第一个存储过程
	 * 
	 * 使用存储过程查询用户信息
	 * 
	 * @param sysUser2
	 * 
	 * @author moon  2019/05/01  16:22  
	 */
	void selectUserById(SysUser2 sysUser2);
	
}
