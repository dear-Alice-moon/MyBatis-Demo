package com.moon.mybatis.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.moon.mybatis.mapper.SysUserMapper2;
import com.moon.mybatis.pojo.SysUser;

public class UserMapperTest2 extends BaseMapperTest {
	
	
	
	/**
	 * 新增用户--函数4，Oracle数据库中，通过 selectKey标签获取新增对象信息时获取主键值。
	 * 
	 * 备注：该函数是用来测试Oracle数据库的情况，由于 mybatis-config.xml文件中仅配置Mysql数据库链接信息，
	 * 该函数目前不可进行测试。
	 * 
	 * @author moon  2019/02/02  22:03
	 */
	@Test
	public void testSysUserInsert4() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper2 userMapper = sqlSession.getMapper(SysUserMapper2.class); 
			
			// 创建一个user对象
			SysUser user = new SysUser();
			user.setUserName("test02");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			user.setHeadImg(new byte[] {1, 2, 3, 4});
			user.setCreateTime(new Date());
			
			Integer result = userMapper.insertSysUser4(user);
			// 只插入1条数据
			Assert.assertEquals(1, Integer.parseInt(result.toString()));
			// 因为id回写，所以id不为null
			Assert.assertNotNull(user.getId());
			
			System.out.println("插入的数据中，id值(主键值)为：" + user.getId());
			
		} catch (Exception e) {
			
			sqlSession.rollback();  // 事务回滚   @moon  2019/02/02  22:17
			// sqlSession.commit();  // 添加该行代码，提交事务，数据库中会插入数据。否则，数据库中将不会新增数据。   @moon  2019/02/02  22:19                
			// 不要忘记关闭 sqlSession
			sqlSession.close(); 
		}
		
	}
	
	
	/**
	 * 新增用户--函数3，Mysql数据库中，通过 selectKey标签获取新增对象信息时获取主键值。
	 * 
	 * @author moon  2019/02/02  22:03
	 */
	@Test
	public void testSysUserInsert3() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper2 userMapper = sqlSession.getMapper(SysUserMapper2.class); 
			
			// 创建一个user对象
			SysUser user = new SysUser();
			user.setUserName("test02");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			user.setHeadImg(new byte[] {1, 2, 3, 4});
			user.setCreateTime(new Date());
			
			Integer result = userMapper.insertSysUser3(user);
			// 只插入1条数据
			Assert.assertEquals(1, Integer.parseInt(result.toString()));
			// 因为id回写，所以id不为null
			Assert.assertNotNull(user.getId());
			
			System.out.println("插入的数据中，id值(主键值)为：" + user.getId());
			
		} catch (Exception e) {
			
			sqlSession.rollback();  // 事务回滚   @moon  2019/02/02  22:17
			// sqlSession.commit();  // 添加该行代码，提交事务，数据库中会插入数据。否则，数据库中将不会新增数据。   @moon  2019/02/02  22:19                
			// 不要忘记关闭 sqlSession
			sqlSession.close(); 
		}
		
	}
	
	
	
	/**
	 * 新增数据--函数2
	 * 
	 * @author moon  2019/01/28  15:23     
	 */
	@Test
	public void testSysUserInsert2() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper2 userMapper = sqlSession.getMapper(SysUserMapper2.class);
			
			// 创建一个user对象
			SysUser user = new SysUser();
			user.setUserName("test01");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			user.setHeadImg(new byte[] {1, 2, 3, 4});
			user.setCreateTime(new Date());
			
			Integer result = userMapper.insertSysUser2(user);
			// 只插入1条数据
			Assert.assertEquals(1, Integer.parseInt(result.toString()));
			// 因为id回写，所以id不为null
			Assert.assertNotNull(user.getId());
			
			System.out.println("插入的数据中，id值(主键值)为: " + user.getId());
			
		} finally {
			
			sqlSession.rollback();  // 事务回滚    @moon  2019/01/28  15:41       
			// 不要忘记关闭 sqlSession
			// sqlSession.commit();  // 添加该行代码，提交事务，数据库中会插入数据。否则，数据库不会新增数据。    @moon  2019/01/28  15:40       
			sqlSession.close();
		}
		
		
	}
	
	
	/**
	 * 新增数据
	 * 
	 * @author moon  2019/01/26  10:45
	 */
	@Test
	public void testSysUserInsert() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			SysUserMapper2 userMapper = sqlSession.getMapper(SysUserMapper2.class);
			
			// 创建一个user对象
			SysUser sysUser = new SysUser();
			sysUser.setUserName("张三");
			sysUser.setUserPassword("123456");
			sysUser.setUserEmail("zhangsan@mybatis.tk");
			sysUser.setUserInfo("test Info");
			// 正常情况下应该读入一张图片存到 byte数组中
			sysUser.setHeadImg(new byte[]{1, 2, 3});
			sysUser.setCreateTime(new Date());
			
			// 将新建的对象插入数据库中，特别注意的是这里的返回值 result 是执行的 SQL影响的行数
			Integer result = userMapper.insertSysUser(sysUser);
			System.out.println("result值为：" + result);
			
			// 只插入了1条数据
			Assert.assertEquals(1, Integer.parseInt(result.toString()));
			// id为null， 没有给id赋值， 并且没有配置回写id的值
			Assert.assertNull(sysUser.getId());
			
		} finally {
			
			// 为了不影响其他测试，这里选择回滚
			// 由于默认的 sqlSessionFactory.openSession() 是不自动提交的
			// 因此不手动执行 commit 也不会提交到数据库。
			sqlSession.rollback();
			// 不要忘记关闭sqlSession 
			sqlSession.close();
			
		}
		
	}
	
	
}
