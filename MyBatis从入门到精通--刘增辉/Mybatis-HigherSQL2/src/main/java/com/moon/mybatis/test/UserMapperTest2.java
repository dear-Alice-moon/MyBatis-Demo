package com.moon.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.moon.mybatis.mapper.SysUserMapper2;
import com.moon.mybatis.pojo.SysRole;
import com.moon.mybatis.pojo.SysUser2;

/**
 * 测试类，集中进行验证Mybatis的高级查询: 
 * 	高级映射、存储过程、
 * 	枚举、JavaBean、JDK8  
 * 
 * 一对多映射  
 * 
 * @author moon  2019/03/25  16:36    
 */
public class UserMapperTest2 extends BaseMapperTest {
	
	
	/**
	 * 一对多映射
	 * 
	 * @author moon  2019/03/25  16:40  
	 */
	@Test
	public void testSelectUserAndRoleById() {
		
		// 获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			// 获取 UserMapper 接口
			SysUserMapper2 sysUserMapper = sqlSession.getMapper(SysUserMapper2.class);
			
			
			System.out.println("------------------------ Mybatis, 一对多映射，使用collection标签处理一对多关系. ------------------------");
			List<SysUser2> sysUserList = sysUserMapper.selectAllUserAndRoles();
			System.out.println("sysUserList为： " + JSON.toJSONString(sysUserList));
			
			System.out.println("用户数： " + sysUserList.size());
			for (SysUser2 sysUser2 : sysUserList) {
				System.out.println("用户名： " + sysUser2.getUserName());
				for (SysRole sysRole : sysUser2.getSysRoleList()) {
					System.out.println("角色名为： " + sysRole.getRoleName());
				}
			}
			
			
			System.out.println("------------------------ Mybatis, 一对多映射，使用collection标签及其resultMpa属性处理一对多关系. ------------------------");
			List<SysUser2> sysUserList2 = sysUserMapper.selectAllUserAndRoles2(1L);
			System.out.println("sysUserList2为： " + JSON.toJSONString(sysUserList2));
			
			
			System.out.println("------------------------ Mybatis, 一对多映射，使用collection标签、resultMpa标签及其子标签id 处理一对多关系. ------------------------");
			List<SysUser2> sysUserList3 = sysUserMapper.selectAllUserAndRoles3();
			System.out.println("sysUserList3为： " + JSON.toJSONString(sysUserList3));
			
			
			System.out.println("------------------------ Mybatis, 一对多映射，一个用户有多个角色，一个角色有多个权限. ------------------------");
			SysUser2 sysUser4 = sysUserMapper.selectAllUserAndRoles4(1L);
			System.out.println("sysUser4为： " + JSON.toJSONString(sysUser4));
			
			
			System.out.println("------------------------ Mybatis, 一对多映射，collection集合标签嵌套查询. ------------------------");
			SysUser2 sysUser5 = sysUserMapper.selectAllUserAndRolesSelect(1L);
			System.out.println("sysUser5为：" + JSON.toJSONString(sysUser5));
			
			
		} catch (Exception e) {
			
			System.out.println("错误信息为： " + e.toString());
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			
			// 对事务进行回滚
			sqlSession.rollback();
			
			// 不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
}
