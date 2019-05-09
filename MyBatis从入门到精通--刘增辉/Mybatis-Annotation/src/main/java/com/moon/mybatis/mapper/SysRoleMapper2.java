package com.moon.mybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.moon.mybatis.pojo.SysRole;

/**
 * 基于注解开发, 主要测试'新增'功能.
 * 注解开发仅用于学习，不推荐在实际项目中运用.       
 * 
 * @author moon  2019/02/14  10:43      
 */
public interface SysRoleMapper2 {
	
	
	/**
	 * 验证注解删除功能  
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/02/14  16:14  
	 */
	@Delete({"DELETE FROM sys_role WHERE id = #{id}"})
	Integer deleteRoleById(Long id);
	
	
	/**
	 * 验证注解更新功能
	 * 
	 * @param sysRole
	 * @return
	 * 
	 * @author moon  2019/02/14  15:18  
	 */
	@Update({"UPDATE sys_role SET role_name = #{roleName}, enabled = #{enabled}, create_by = #{createBy}, create_time = #{createTime, jdbcType=TIMESTAMP}", 
			 "WHERE id = #{id}"
			})
	Integer updateRoleById2(SysRole sysRole);
	
	
	/**
	 * 验证注解更新功能
	 * 
	 * @param sysRole
	 * @return
	 * 
	 * @author moon  2019/02/14  15:18  
	 */
	@Update({"UPDATE sys_role", 
			 "SET role_name = #{roleName},", 
			 "enabled = #{enabled},", 
			 "create_by = #{createBy},",
			 "create_time = #{createTime, jdbcType=TIMESTAMP}", 
			 "WHERE id = #{id}"
			})
	Integer updateRoleById(SysRole sysRole);
	
	
	/**
	 * 返回非自增主键 
	 * 这里或许有些问题，当Mysql数据库中，主键不自增，则Eclipse控制台报错!   @author moon  2019/02/14  15:16   
	 * 
	 * @param sysRole
	 * @return
	 * 
	 * @author moon  2019/02/14  11:19 
	 */
	@Insert({"INSERT INTO sys_role(role_name, enabled, create_by, create_time)", 
			 "VALUES(#{roleName}, #{enabled}, #{createBy},", 
			 "#{createTime, jdbcType = TIMESTAMP})"})
	@SelectKey(statement = "SELECT LAST_INSERT_ID()",
			   keyProperty ="id",
			   resultType = Long.class,
			   before = false)
	Integer insertRole4(SysRole sysRole);  // 这里，sql语句中无id字段，返回'非自增字段ID'值为：1004L 
	
	
	/**
	 * 返回非自增主键 
	 * 
	 * @param sysRole
	 * @return
	 * 
	 * @author moon  2019/02/14  11:19 
	 */
	@Insert({"INSERT INTO sys_role(id, role_name, enabled, create_by, create_time)", 
			 "VALUES(#{id}, #{roleName}, #{enabled}, #{createBy},", 
			 "#{createTime, jdbcType = TIMESTAMP})"})
	@SelectKey(statement = "SELECT LAST_INSERT_ID()",
			   keyProperty ="id",
			   resultType = Long.class,
			   before = false)
	Integer insertRole3(SysRole sysRole);  // 这里，sql语句中是否要添加id字段，返回'非自增字段ID'值为：0, 传递的SysRole中的id值为：1003L . 
	
	
	/**
	 * 返回自增主键 
	 * 
	 * @param sysRole
	 * @return
	 * 
	 * @author moon  2019/02/14  11:04
	 */
	@Insert({"INSERT INTO sys_role(role_name, enabled, create_by, create_time)",
			"VALUES(#{roleName}, #{enabled}, #{createBy},",
			"#{createTime, jdbcType=TIMESTAMP})"})
	@Options(useGeneratedKeys=true, keyProperty="id")
	Integer insertRole2(SysRole sysRole);
	
	
	/**
	 * 不需要返回主键
	 * 
	 * @param sysRole
	 * @return
	 * 
	 * @author moon  2019/02/14  10:35  
	 */
	@Insert({"INSERT INTO sys_role(id, role_name, enabled, create_by, create_time)",
			"VALUES(#{id}, #{roleName}, #{enabled}, #{createBy}, ",
			"#{createTime, jdbcType=TIMESTAMP})"})
	Integer insertRole(SysRole sysRole);
	
	
	@Select({"SELECT id, role_name roleName, enabled, create_by createBy, create_time createTime",
		"FROM sys_role", 
		"WHERE id=#{id}"})
	SysRole selectById(Long id);
	
}
