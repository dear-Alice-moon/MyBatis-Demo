package com.moon.mybatis.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.moon.mybatis.mapper.SysUserMapper;
import com.moon.mybatis.pojo.SysUser;

/**
 * MyBatis缓存配置/一级缓存  
 * 
 * @author moon  2019/06/29  17:31  
 *
 */
public class UserMapperTest extends BaseMapper {
	
	
	/**
	 * MyBatis一级缓存测试
	 * 一级缓存存在于 sqlSession 的生命周期中   
	 * 
	 * @author moon  2019/06/29  17:32  
	 */
	@Test
	public void testUserMapper() {
		
		// 获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		SysUser user1 = null;
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			
			System.out.println("------------------------ 验证Mybatis逆向生成工具生成的函数 ------------------------");
			user1 = userMapper.selectByPrimaryKey(1001L);
			System.out.println("user1为：" + user1.toString());
			
			// 对当前获取的对象重新赋值  
			user1.setUserName("New name");
			// 再次查询获取id相同的用户  
			SysUser user2 = userMapper.selectByPrimaryKey(1001L);
			System.out.println("user2为：" + user2.toString());
			
			// 虽然没有更新数据库，但是这个用户名和 user1 重新赋值的名字相同 
			Assert.assertEquals("New name", user2.getUserName());
			// 无论如何，user2 和 user 完全就是同一个实例
			Assert.assertEquals(user1, user2);
			
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
			
			// 获取 UserMapper 接口 
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			// 调用 selectByPrimaryKey 方法，查询 id=1 的用户
			SysUser user2 = userMapper.selectByPrimaryKey(1001L);
			System.out.println("第2个try-catch中，user2为： " + user2.toString());
			// 第二个 session 获取的用户名仍然是 admin
			Assert.assertNotEquals("New Name", user2.getUserName());
			
			// 执行删除操作
			userMapper.deleteSysUser(1012L);  // 执行删除操作后， MyBatis一级缓存 sqlSession会清空。  
			
			// 获取 user3
			SysUser user3 = userMapper.selectByPrimaryKey(1001L);
			System.out.println("第2个try-catch中，user3为： " + user3.toString());
			// 这里的 user2 和 user3 是两个不同的实例
			Assert.assertNotEquals(user2, user3);
			
			
		} catch (Exception e) {
			
			System.out.println("错误信息为： " + e.toString());
			e.printStackTrace();
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
						
			// 事务回滚
			sqlSession.rollback();
			
			// 关闭 sqlSession  
			sqlSession.close();
		}
		
		
	}
	
	
	
	/**
	 * MyBatis一级缓存测试
	 * 新增几条测试数据  
	 * 
	 */
	@Test
	public void insertSysUser() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			SysUser user1 = new SysUser(1015L, "姬风", "123456", "12594753@qq.com", new Date(), "测试数据，无实际意义。", new byte[] {1, 2, 3, 4});
			SysUser user2 = new SysUser("夏侯玄", "abd156", "12594753@qq.com", new Date(), "测试数据，无实际意义。", new byte[] {1, 2, 3, 4});
			SysUser user3 = new SysUser("上官静怡", "w156er0", "12594753@qq.com", new Date(), "测试数据，无实际意义。", new byte[] {1, 2, 3, 4});
			
			userMapper.insertSysUser(user1);
			userMapper.insertSysUser(user2);
			userMapper.insertSysUser(user3);
			
			
		} catch (Exception e) {
			
			System.out.println("错误信息为： " + e.toString());
			e.printStackTrace();
			
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
