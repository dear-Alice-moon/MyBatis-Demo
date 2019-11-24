package com.moon.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.moon.mybatis.mapper.SysRoleMapper;
import com.moon.mybatis.pojo.SysPrivilege;
import com.moon.mybatis.pojo.SysRole;
import com.moon.mybatis.pojo.SysRole2;

/**
 * 测试类，一对多映射。
 * 
 * @author moon 
 *
 */
public class RoleMapperTest extends BaseMapperTest {
	
	
	/**
	 * 一对多映射
	 * 
	 * @author moon  2019/04/26  14:46  
	 */
	@Test
	public void testSelectRoleAndPrivilege() {
		
		// 获取 sqlSession 
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			// 获取 RoleMapper 接口
			SysRoleMapper roleMapper = sqlSession.getMapper(SysRoleMapper.class);
			
			
			System.out.println("------------------------ Mybatis, 一对一映射. ------------------------");
			SysRole sysRole = roleMapper.selectByPrimaryKey(1L);
			System.out.println("sysRole为：" + JSON.toJSONString(sysRole));
			
			
			System.out.println("------------------------ Mybatis, 一对一映射. ------------------------");
			SysRole sysRole2 = roleMapper.selectRoleById(2L);
			System.out.println("sysRole2为：" + JSON.toJSONString(sysRole2));
			
			
			System.out.println("------------------------ Mybatis, 一对多映射，一个角色多个权限. ------------------------");
			List<SysRole> sysRoleList = roleMapper.selectAllRoleAndPrivileges();
			System.out.println("sysRoleList为： " + JSON.toJSONString(sysRoleList));
			
			
			System.out.println("------------------------ Mybatis, 一对多映射，一个角色多个权限. ------------------------");
			SysRole2 sysRole3 = roleMapper.selectAllRoleAndPrivileges2(2L);
			System.out.println("sysRole3为： " + JSON.toJSONString(sysRole3));
			
			
			// System.out.println("------------------------ Mybatis, 一对多映射，collection集合标签嵌套查询. ------------------------");
			// List<SysRole> sysRoleList2 = roleMapper.selectRoleByUserId(1L);
			// System.out.println("sysRoleList2为： " + JSON.toJSONString(sysRoleList2));
			
			
			System.out.println("------------------------ Mybatis, 鉴别器一对多映射. ------------------------");
			// 由于数据库enabled都是1，给其中一个角色的enabled赋值为0
			SysRole sysRole4 = roleMapper.selectByPrimaryKey(2L);
			sysRole4.setEnabled(0);
			// 更新操作
			roleMapper.updateSysRoleByRoleId(sysRole4);
			// 获取用户1的角色 
			List<SysRole> sysRoleList2 = roleMapper.selectRoleByUserIdChoose(1L);
			
			for (SysRole r: sysRoleList2) {
				
				System.out.println("角色名: " + r.getRoleName());
				if (r.getId().equals(1L)) {
					// 第一个角色存在权限信息
					Assert.assertNotNull(r.getSysPrivilegeList());
				} else if (r.getId().equals(2L)) {
					// 第二个角色的权限为 null
					Assert.assertNull(r.getSysPrivilegeList());
					continue;  // 从该位置，跳出当前循环，继续下一次的循环.  
				}
				
				for (SysPrivilege sysPrivilege : r.getSysPrivilegeList()) {
					System.out.println("权限名为： " + sysPrivilege.getPrivilegeName());
				}
				
				System.out.println("sysRole信息为：" + JSON.toJSONString(r));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("错误信息为： " + e.toString());
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			
			// 事务回滚
			sqlSession.rollback();
			
			// 关闭 sqlSession
			sqlSession.close();
		}
		
	}  
	
	
}
