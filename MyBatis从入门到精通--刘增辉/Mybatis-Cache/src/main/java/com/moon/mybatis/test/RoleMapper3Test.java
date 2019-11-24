package com.moon.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.moon.mybatis.mapper.SysRoleMapper3;
import com.moon.mybatis.pojo.SysRole3;

public class RoleMapper3Test extends BaseMapper {
	
	
	/**
	 * 使用ehcache-cache验证MyBatis二级缓存
	 * 
	 * @author moon  2019/08/24  17:22  
	 */
	@Test
	public void testEhcache() {
		
		// 获取sqlSession
		SqlSession sqlSession = getSqlSession();
		SysRole3 role = null;
		
		try {
			
			// 获取SysRoleMapper3接口
			SysRoleMapper3 roleMapper = sqlSession.getMapper(SysRoleMapper3.class);
			
			// 调用 selectById 方法，查询 id=3 的角色
			role = roleMapper.selectRoleById(3L);
			System.out.println("查询获取第一次role值为: " + role.toString());
			// 对当前获取的对象重新赋值 
			role.setRoleName("New name");
			
			// 再次查询获取 id=3 的角色
			SysRole3 role2 = roleMapper.selectRoleById(3L);
			System.out.println("查询获取第二次role值为： " + role2.toString());
			
			// 虽然没有更新数据库，但是这个用户名和role重新赋值的名字相同
			Assert.assertEquals("New name", role2.getRoleName());
			// 无论如何，role2和role完全就是同一个实例
			Assert.assertEquals(role, role2);
			
			
		} catch (Exception e) {
			
			System.out.println("错误信息为: " + e.toString());
			e.printStackTrace();
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			
			// 事务回滚
			sqlSession.rollback();
			
			// 关闭sqlSession
			sqlSession.close();
		}
		
		
		
		
		System.out.println("------------------------ 开启新的 sqlSession ------------------------");
		// 开始另一个新的 session 
		sqlSession = getSqlSession();
		
		
		try {
			
			// 获取 RoleMapper 接口
			SysRoleMapper3 roleMapper = sqlSession.getMapper(SysRoleMapper3.class);
			// 调用 selectById 方法，查询获取 id=3 的用户
			SysRole3 role22 = roleMapper.selectRoleById(3L);
			System.out.println("新的sqlSession中，查询获取第一次role值为: " + role22.toString());
			
			// 第二个 sqlSession 获取的用户名是 New name
			Assert.assertEquals("New name", role22.getRoleName());
			// 这里的 role22 和前一个 session 查询的结果是两个不同的实例
			Assert.assertNotEquals(role, role22);
			
			// 获取 role3
			SysRole3 role3 = roleMapper.selectRoleById(3L);
			System.out.println("新的sqlSession中，查询获取第二次role值为：" + role3.toString());
			Assert.assertNotEquals(role22, role3);
			
		} catch (Exception e) {
			
			System.out.println("错误信息为: " + e.toString());
			e.printStackTrace();
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			
			// 事务回滚
			sqlSession.rollback();
			
			// 关闭sqlSession
			sqlSession.close();
		}
		
		
	}  // public void testEhcache() 
	
	
}
