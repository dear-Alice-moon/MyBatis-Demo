package com.moon.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.moon.mybatis.pojo.SysUser;

public interface SysUserMapper {
	
	
	/**
	 * Mybatis框架，多数据库支持.    
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/17  21:16   
	 */
	List<SysUser> selectSysUserByUser4(SysUser sysUser);
	
	
	/**
	 * bind标签，使用OGNL表达式根据userName模糊查询SysUser信息. 
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/17  19:49   
	 */
	List<SysUser> selectSysUserByUser3(SysUser sysUser);
	
	
	/**
	 * foreach标签，Map<K, V>参数，更新用户信息.
	 * 
	 * @param userMap
	 * @return
	 * 
	 * @author moon  2019/02/16  21:07  
	 */
	Integer updateSysUserByUserMap(Map<String, Object> userMap);
	
	
	/**
	 * foreach标签，Map<K, V>参数，批量插入用户信息.
	 * 
	 * @param userMap
	 * @return
	 * 
	 * @author moon  2019/02/16  17:37  
	 */
	Integer insertSysUserMap4(@Param(value = "userMaps") Map<String, Object> userMap);
	
	
	/**
	 * foreach标签，Map<K, V>参数，批量插入用户信息.
	 * 
	 * @param userMap
	 * @return
	 * 
	 * @author moon  2019/02/16  17:37  
	 */
	Integer insertSysUserMap3(@Param(value = "userMaps") Map<String, Object> userMap);
	
	
	/**
	 * foreach标签，Map<K, V>参数，批量插入用户信息.
	 * 
	 * @param userMap
	 * @return
	 * 
	 * @author moon  2019/02/16  17:37  
	 */
	Integer insertSysUserMap2(@Param(value = "userMaps") Map<String, Object> userMap);
	
	
	/**
	 * foreach标签，Map<K, V>参数，批量插入用户信息.
	 * 
	 * @param userMap
	 * @return
	 * 
	 * @author moon  2019/02/16  17:37  
	 */
	Integer insertSysUserMap(@Param(value = "userMaps") Map<String, Object> userMap);
	
	
	/**
	 * foreach标签，List<T>参数，批量插入用户信息
	 * 
	 * @param userList
	 * @return
	 * 
	 * @author moon  2019/02/16  17:35  
	 */
	Integer insertSysUserList(List<SysUser> userList);
	
	
	/**
	 * foreach标签， foreach标签实现in集合(或数组)动态查询SysUser信息.
	 * 根据用户id集合查询
	 * 
	 * @param idMap
	 * @param userNameMap
	 * @return
	 * 
	 * @author moon  2019/02/16  16:07      
	 */
	List<SysUser> selectSysUserByIdMapAndUsernameMap(@Param(value="idMaps") Map<String, Object> idMap, @Param(value = "userNameMaps") Map<String, Object> userNameMap);
	
	
	/**
	 * foreach标签， foreach标签实现in集合(或数组)动态查询SysUser信息.
	 * 根据用户id集合查询
	 * 
	 * @param idMap
	 * @return
	 * 
	 * @author moon  2019/02/16  16:02      
	 */
	List<SysUser> selectSysUserByIdMap(@Param(value = "idMaps") Map<String, Object> idMap);
	// List<SysUser> selectSysUserByIdMap(Map<String, Object> idMap);  // 没有通过 @Param注解指定参数名，则在xml配置中，collection中默认填写什么，我暂时未知!  @moon  2019/02/16  17:52 
	
	
	/**
	 * foreach标签， foreach标签实现in集合(或数组)动态查询SysUser信息.
	 * 根据用户id集合查询
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @author moon  2019/02/16  16:01      
	 */
	List<SysUser> selectSysUserByIdArray(Long[] idArray);
	
	
	/**
	 * foreach标签， foreach标签实现in集合(或数组)动态查询SysUser信息.
	 * 根据用户id集合查询
	 * 
	 * @param idList
	 * @param userNameList
	 * @return
	 * 
	 * @author moon  2019/02/16  16:05      
	 */
	List<SysUser> selectSysUserByIdListAndUsernameList(@Param(value="idLists") List<Long> idList, @Param(value = "userNameLists") List<String> userNameList);
	
	
	/**
	 * foreach标签， foreach标签实现in集合(或数组)动态查询SysUser信息.
	 * 根据用户id集合查询
	 * 
	 * @param idList
	 * @return
	 * 
	 * @author moon  2019/02/16  15:39      
	 */
	List<SysUser> selectSysUserByIdList(List<Long> idList);
	
	
	/**
	 * choose|when|otherwise标签, 动态查询 SysUser信息.  
	 * 根据用户Id或用户名查询
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/16  11:32  
	 */
	SysUser selectSysUserByIdOrUserName(SysUser sysUser);
	
	
	/**
	 * if标签, 动态插入SysUser信息.   
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/15  16:53  
	 */
	Integer insertSysUser(SysUser sysUser);
	
	
	/**
	 * set|if标签, 根据主键动态更新.  
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/15  14:45  
	 */
	Integer updateSysUser2ByIdSelective(SysUser sysUser);
	
	
	/**
	 * set|if标签, 根据主键动态更新.  
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/16  16:10  
	 */
	Integer updateSysUserByIdSelective2(SysUser sysUser);
	
	
	/**
	 * if标签, 根据主键动态更新.  
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/15  14:45  
	 */
	Integer updateSysUserByIdSelective(SysUser sysUser);
	
	
	/**
	 * if标签, 根据userName模糊匹配、userEmail全匹配动态查询 SysUser 信息.
	 * 使用where标签
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/15  14:28           
	 */
	List<SysUser> selectSysUserByUser2(SysUser sysUser);
	
	
	/**
	 * if标签, 根据userName模糊匹配、 userEmail全匹配动态查询 SysUser 信息.
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @author moon  2019/02/15  10:52  
	 */
	List<SysUser> selectSysUserByUser(SysUser sysUser);
	
	
	/**
	 * 通过 id 查询用户                   
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/02/15  15:52 
	 */
	SysUser selectSysUserById(Long id);
	
}
