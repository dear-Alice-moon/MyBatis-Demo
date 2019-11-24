package com.moon.mybatis.mapper;

import java.util.List;

import com.moon.mybatis.pojo.SysRole;
import com.moon.mybatis.pojo.SysRole2;

public interface SysRoleMapper {
	
	
	/**
	 * MyBatis鉴别器映射，通过userId查询 SysRole 信息. 
	 * 
	 * @param roleId
	 * @return
	 * 
	 * @author moon  2019/04/28  16:19
	 */
	List<SysRole> selectRoleByUserIdChoose(Long userId);
	
	
	/**
	 * 更新 SysRole 信息. 
	 * 
	 * @param sysRole
	 * @return
	 * 
	 * @author moon  2019/04/28  16:28  
	 */
	Integer updateSysRoleByRoleId(SysRole sysRole);
	
	
	/**
	 * collection集合标签的嵌套查询.
	 * 
	 * @param userId
	 * @return
	 * 
	 * @author moon  2019/04/26  21:19  
	 */
	List<SysRole> selectRoleByUserId(Long userId);
	
	
	/**
	 * 一对多映射，一个角色对应多个权限.
	 * 编辑器Dug模式下，仔细体会'association标签' 与  'collection标签' 的这两种类型配置. 
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/04/26  16:20  
	 */
	SysRole2 selectAllRoleAndPrivileges2(Long id);
	
	
	/**
	 * 一对多映射，查询一个角色对应多个权限. 
	 * 
	 * @return
	 * 
	 * @author moon  2019/04/26  14:43  
	 */
	List<SysRole> selectAllRoleAndPrivileges();
	
	
	/**
	 * 通过主键查询角色信息
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/04/26  14:41  
	 */
	SysRole selectRoleById(Long id);
	
	
	/**
	 * 通过主键查询角色信息，自动生成。  
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/04/26  14:23  
	 */
    SysRole selectByPrimaryKey(Long id);
    
}