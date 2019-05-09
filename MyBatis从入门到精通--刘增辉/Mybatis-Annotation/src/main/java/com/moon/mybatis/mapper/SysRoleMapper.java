package com.moon.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.moon.mybatis.pojo.SysRole;

/**
 * 基于注解开发, 主要测试'查询'功能.
 * 
 * @author moon  2019/02/13  16:58      
 */
public interface SysRoleMapper {
	
	
	/**
	 * selectAll()函数，通过使用resultMap方式来实现JavaBean属性与表字段映射.
	 * selectById7(...)函数、selectById8(...)函数，通过@Results注解来实现JavaBean属性与表字段映射.
	 * 
	 * @author moon  2019/02/13  19:18 
	 */
	
	
	@ResultMap("roleResultMap")
	@Select("SELECT id, role_name, enabled, create_by, create_time FROM sys_role")
	List<SysRole> selectAll();
	
	
	@Results(id="roleResultMap", value = {
		@Result(property="id", column="id", id=true),
		@Result(property="roleName", column="role_name"),
		@Result(property="enabled", column="enabled"),
		@Result(property="createBy", column="create_by"),
		@Result(property="createTime", column="create_time")
	})
	@Select({"SELECT id, role_name, enabled, create_by, create_time FROM sys_role WHERE id=#{id}"})
	SysRole selectById8(Long id);
	
	
	@Results({
		@Result(property="id", column="id", id=true),
		@Result(property="roleName", column="role_name"),
		@Result(property="enabled", column="enabled"),
		@Result(property="createBy", column="create_by"),
		@Result(property="createTime", column="create_time")
	})
	@Select({"SELECT id, role_name, enabled, create_by, create_time FROM sys_role WHERE id=#{id}"})
	SysRole selectById7(Long id);
	
	
	/**
	 * selectById5(...)、selectById6(...)函数，通过在 mybatis-config.xml文件中配置 mapUnderscoreToCamelCase参数，
	 * 进行表字段和Java属性字段映射的问题。
	 * 
	 * @return
	 * 
	 * @author moon  2019/02/13  17:30  
	 */
	
	
	@Select({"SELECT id, role_name, enabled, create_by, create_time FROM sys_role WHERE id=#{id}"})
	SysRole selectById6(Long id);
	
	
	@Select({"SELECT * FROM sys_role WHERE id=#{id}"})
	SysRole selectById5(Long id);
	
	
	/**
	 * selectById(Long id)、selectById2(Long id)、selectById3(Long id)、selectById4(Long id)，这4个函数说明...
	 * 这4个函数只是为了展示注解的用法。其中selectById(...)、selectById2(...)这2个函数可以进行相互比较。       
	 * 其中selectById3(...)、selectById4(...)这2个函数可以进行相互比较。
	 * 
	 * @return
	 * 
	 * @author moon  2019/02/13  17:26  
	 */
	
	
	@Select({"SELECT id, "
			+ "role_name roleName,"
			+ "enabled,"
			+ "create_by createBy,"
			+ "create_time createTime",
			"FROM sys_role", 
			"WHERE id=#{id}"})
	SysRole selectById(Long id);
	
	
	@Select({"SELECT id, role_name roleName, enabled, create_by createBy, create_time createTime",
			"FROM sys_role", 
			"WHERE id=#{id}"})
	SysRole selectById2(Long id);
	
	
	@Select({"SELECT id, role_name roleName, enabled, create_by createBy, create_time createTime "
			+ "FROM sys_role "
			+ "WHERE id=#{id}"})
	SysRole selectById3(Long id);
	
	
	@Select({"SELECT id, role_name roleName, enabled, create_by createBy, create_time createTime FROM sys_role WHERE id=#{id}"})
	SysRole selectById4(Long id);
	
}
