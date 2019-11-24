package com.moon.mybatis.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.moon.mybatis.mapper.SysUserMapper;
import com.moon.mybatis.pojo.SysUser;


/**
 * 测试类，集中进行验证Mybatis的动态SQL功能。
 * 
 * @author moon  2019/02/15  10:39         
 *
 */
public class UserMapperTest extends BaseMapperTest {
	
	
	/**
	 * Mybatis框架，多数据库支持. 
	 * 
	 * @author moon  2019/02/17  21:23  
	 */
	@Test
	public void testSelectSysUser2() {
		
		// 创建sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			
			SysUser sysUser = new SysUser();
			sysUser.setUserName("tes");
			sysUser.setUserEmail("test@mybatis.tk");
			
			List<SysUser> sysUserList = userMapper.selectSysUserByUser4(sysUser);
			
			System.out.println("sysUserList数量为：" + sysUserList.size());
			System.out.println("sysUserList值为：" + sysUserList.toString());
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			// 对事务进行回滚
			sqlSession.rollback();
			
			// 关闭sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * bind标签，使用OGNL表达式根据userName模糊查询SysUser信息. 
	 * 
	 * @author moon  2019/02/17  20:08  
	 */
	@Test
	public void testSelectSysUser() {
		
		// 创建sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			
			SysUser sysUser = new SysUser();
			sysUser.setUserName("tes");
			
			List<SysUser> sysUserList = userMapper.selectSysUserByUser3(sysUser);
			
			System.out.println("sysUserList数量为：" + sysUserList.size());
			System.out.println("sysUserList值为：" + sysUserList.toString());
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			// 对事务进行回滚
			sqlSession.rollback();
			
			// 关闭sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * foreach标签，Map<K, V>参数， 更新用户信息.
	 * 
	 * @author moon  2019/02/16  21:11 
	 */
	@Test
	public void testUpdateUserByUserMap() {
		
		// 创建sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			Map<String, Object> userMap = new HashMap<String, Object>();
			// userMap.put("idd", 1006L);  // 这种写法报错，通过该测试可知 foreach标签+Map<K,V>参数 更新信息时，有缺陷!  @moon  2019/02/16  21:27    
			userMap.put("id", 1006L);    
			userMap.put("user_email", "test123@mybatis.tk");
			userMap.put("user_password", "12345678");
			// 更新 SysUser信息.
			Integer result = userMapper.updateSysUserByUserMap(userMap);
			System.out.println("result值为： " + result);
			Assert.assertEquals(new Integer(1), result);
			
			// 查询更新后的SysUser信息
			SysUser sysUser = userMapper.selectSysUserById(1006L);
			System.out.println("sysUser值为： " + sysUser.toString());
			Assert.assertEquals("12345678", sysUser.getUserPassword());
			
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			// 对事务进行回滚
			sqlSession.rollback();
			
			// 关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * foreach标签，List<T>集合参数，实现批量插入用户信息.   
	 * foreach标签，Map<K, V>集合 参数，实现插入用户信息.   
	 * 
	 * @author moon  2019/02/16  18:29  
	 */
	@Test
	public void testInsertSysUserByUser() {
		
		// 创建sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			
			System.out.println("------------------------------------ foreach标签，单参数List<T>集合批量插入用户信息测试 ------------------------------------");
			// 创建一个List<SysUser> 对象 
			List<SysUser> userList = new ArrayList<SysUser>();
			for (int i = 0; i < 3; i++) {
				SysUser sysUser = new SysUser();
				sysUser.setUserName("test" + i);
				sysUser.setUserPassword("123456");
				sysUser.setUserEmail("test@mybatis.tk");
				userList.add(sysUser);
				
			}
			
			// 将新建的对象批量插入数据库中
			// 特别注意，这里的返回值 result 是执行SQL影响的行数
			Integer result = userMapper.insertSysUserList(userList);
			System.out.println("userList值为： " + userList.toString());
			Assert.assertEquals(new Integer(3), result);
			
			
			System.out.println("------------------------------------ foreach标签，单参数Map<K, V>集合批量插入用户信息测试 ------------------------------------");
			Map<String, Object> userMap = new HashMap<String, Object>();
			userMap.put("user_name", "王安石");
			userMap.put("user_password", "123456");
			userMap.put("user_email", "Wangym@mybatis.tk");
			userMap.put("user_info", "Map<K, V>参数，插入数据测试.");
			userMap.put("head_img", new byte[] {0, 1, 2, 3});
			Integer result2 = userMapper.insertSysUserMap(userMap);
			
			Assert.assertEquals(new Integer(1), result2);
			
			SysUser sysUser2 = new SysUser();
			sysUser2.setUserName("王安石");
			System.out.println("验证是否插入了数据：" + userMapper.selectSysUserByIdOrUserName(sysUser2));
			
			/*
			System.out.println("------------------------------- Map参数，另一种INSERT传值方式--insertSysUserMap2(...)函数. -------------------------------");
			Map<String, Object> userMap2 = new HashMap<String, Object>();
			userMap2.put("user_name", "王小二");
			userMap2.put("user_password", "123456");
			userMap2.put("user_email", "Wangxe@mybatis.tk");
			userMap2.put("user_info", "Map<K, V>参数，插入数据测试.");
			userMap2.put("head_img", new byte[] {0, 1, 2, 3});
			Integer result3 = userMapper.insertSysUserMap2(userMap2);
			
			Assert.assertEquals(new Integer(1), result3);
			
			SysUser sysUser3 = new SysUser();
			sysUser3.setUserName("王小二");
			System.out.println("验证是否插入了数据：" + userMapper.selectSysUserByIdOrUserName(sysUser3));
			
			
			System.out.println("------------------------------- Map参数，另一种INSERT传值方式--insertSysUserMap3(...)函数. -------------------------------");
			Map<String, Object> userMap3 = new HashMap<String, Object>();
			userMap3.put("user_name", "李斯");
			userMap3.put("user_password", "123456");
			userMap3.put("user_email", "Lisi@mybatis.tk");
			userMap3.put("user_info", "Map<K, V>参数，插入数据测试.");
			userMap3.put("head_img", new byte[] {0, 1, 2, 3});
			Integer result4 = userMapper.insertSysUserMap3(userMap3);
			
			Assert.assertEquals(new Integer(1), result4);
			
			SysUser sysUser4 = new SysUser();
			sysUser4.setUserName("李斯");
			System.out.println("验证是否插入了数据：" + userMapper.selectSysUserByIdOrUserName(sysUser4));
			
			
			System.out.println("------------------------------- Map参数，另一种INSERT传值方式--insertSysUserMap4(...)函数. -------------------------------");
			Map<String, Object> userMap4 = new HashMap<String, Object>();
			userMap4.put("user_name", "李时珍");
			userMap4.put("user_password", "123456");
			userMap4.put("user_email", "Lisi@mybatis.tk");
			userMap4.put("user_info", "Map<K, V>参数，插入数据测试.");
			userMap4.put("head_img", new byte[] {0, 1, 2, 3});
			Integer result5 = userMapper.insertSysUserMap4(userMap4);
			
			Assert.assertEquals(new Integer(1), result5);
			
			SysUser sysUser5 = new SysUser();
			sysUser5.setUserName("李时珍");
			System.out.println("验证是否插入了数据：" + userMapper.selectSysUserByIdOrUserName(sysUser5));
			*/
			
		} finally {
			
			// 提交事务
			sqlSession.commit();
			
			// 对事务进行回滚
			// sqlSession.rollback();
			
			// 关闭sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * foreach标签，List<T>集合、 Map<K,V>集合、Array[]数组 参数，测试动态SQL查询功能.
	 * 
	 * @author moon  2019/02/16  16:35  
	 */
	@Test
	public void testSelectSysUserByParams() {
		
		// 创建sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			
			
			System.out.println("--------------------------- foreach标签，单参数List<T>集合测试 ---------------------------");
			// 创建List<T> idList集合
			List<Long> idList = new ArrayList<Long>();
			List<Long> idList2 = new ArrayList<Long>();
			idList.add(1L);
			idList.add(1001L);
			idList.add(1004L);
			List<SysUser> sysUserList = userMapper.selectSysUserByIdList(idList);
			List<SysUser> sysUserList22 = userMapper.selectSysUserByIdList(idList2);  // 验证MyBatis如何处理List<T>空集合入参
			System.out.println("sysUserList值为： " + sysUserList.toString());
			System.out.println("sysUserList22值为： " + sysUserList22.toString());  // 验证MyBatis如何处理List<T>空集合入参
			
			
			// 创建List<T> userNameList集合
			List<String> userNameList = new ArrayList<String>();
			userNameList.add("李四");
			
			System.out.println("--------------------------- foreach标签，多参数List<T>集合测试 ---------------------------");
			List<SysUser> sysUserList2 = userMapper.selectSysUserByIdListAndUsernameList(idList, userNameList);
			System.out.println("sysUserList2数量为： " + sysUserList2.size());
			System.out.println("sysUserList2值为： " + sysUserList2.toString());
			
			
			
			System.out.println("--------------------------- foreach标签，单参数Array[]数组测试 ---------------------------");
			// 创建 Array[] idArray数组
			Long[] idArray = {1L, 1001L, 1006L};
			List<SysUser> sysUserList3 = userMapper.selectSysUserByIdArray(idArray);
			System.out.println("sysUserList3值为： " + sysUserList3.toString());
			
			
			
			System.out.println("--------------------------- foreach标签，单参数Map<K, V>集合测试 ---------------------------");
			// 创建 Map<K, V> idMap集合
			Map<String, Object> idMap = new HashMap<String, Object>();
			idMap.put("id1", 1L);
			idMap.put("id2", 1005L);
			List<SysUser> sysUserMap = userMapper.selectSysUserByIdMap(idMap);
			System.out.println("sysUserMap值为： " + sysUserMap.toString());
			
			
			// 创建 Map<K, V> userNameMap集合 
			Map<String, Object> userNameMap = new HashMap<String, Object>();
			System.out.println("--------------------------- foreach标签，多参数Map<K, V>集合测试 ---------------------------");
			userNameMap.put("userName1", "test");
			userNameMap.put("userName2", "李四");
			userNameMap.put("userName3", "test01");
			List<SysUser> sysUserMap2 = userMapper.selectSysUserByIdMapAndUsernameMap(idMap, userNameMap);
			System.out.println("sysUserMap2值为： " + sysUserMap2.toString());
			System.out.println("sysUserMap2的数量为： " + sysUserMap2.size());
			
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			// 回滚事务
			sqlSession.rollback();
			
			// 关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * choose|when|otherwise标签，测试动态SQL查询功能.
	 * 
	 * @author moon  2019/02/16  11:52 
	 */
	@Test
	public void testSelectSysUserByUser2() {
		
		// 获取sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			
			SysUser sysUser = new SysUser();
			// sysUser.setId(1005L);
			sysUser.setUserName("李四");
			
			SysUser sysUser2 = userMapper.selectSysUserByIdOrUserName(sysUser);
			System.out.println("sysUser2为：" + sysUser2.toString());
			
			Assert.assertNotNull(sysUser2);
			// Assert.assertEquals("张三", sysUser2.getUserName());  // 预测结果：报错.
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			// 对事务进行回滚
			sqlSession.rollback();
			
			// 关闭 sqlSession 
			sqlSession.close();
		}
		
		
	}
	
	
	/**
	 * if标签，测试动态SQL新增功能.
	 * 
	 * @author moon  2019/02/15  16:59     
	 */
	@Test
	public void testInsertSysUser() {
		
		// 获取sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			SysUser sysUser = new SysUser("张三", "123456", "Zhangsan@mybatis.tk", "普通用户", new byte[] {1,2,3}, new Date());
			SysUser sysUser2 = new SysUser("李四", "123456", "普通用户", new byte[] {1,2,3}, new Date());
			
			Integer num = userMapper.insertSysUser(sysUser);
			Integer num2 = userMapper.insertSysUser(sysUser2);
			
			Assert.assertEquals(new Integer(1), num);
			Assert.assertEquals(new Integer(1), num2);
			
			System.out.println("sysUser的id值为： " + sysUser.getId());
			System.out.println("sysUser2的id值为： " + sysUser2.getId());
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			// 这里为了不影响其他测试，选择回滚.
			sqlSession.rollback();
			
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * if标签，测试动态SQL更新功能. 
	 * 
	 * @author moon  2019/02/15  15:43  
	 */
	@Test
	public void testUpdateSysUser() {
		
		// 获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			
			SysUser sysUser1 = userMapper.selectSysUserById(1001L);
			System.out.println("sysUser1值为： " + sysUser1.toString());
			System.out.println("----------------------------------------------");
			
			// 创建一个user对象
			SysUser sysUser = new SysUser(1001L, "张三", "123123", "test123@mybatis.tk", "普通用户",  new byte[] {1, 2 ,3}, new Date());
			Integer num = userMapper.updateSysUserByIdSelective(sysUser);
			System.out.println("num值为： " + num);
			Assert.assertEquals(new Integer(1), num);
			System.out.println("----------------------------------------------");
			
			// 查询 id=1001 的信息
			SysUser sysUser2 = userMapper.selectSysUserById(1001L);
			System.out.println("sysUser2值为： " + sysUser2.toString());
			
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			// 为了不影响其他测试，这里选择回滚事务.  
			sqlSession.rollback();
			
			// 不要忘记关闭sqlSession
			sqlSession.close();
		}
		
	}  // public void testUpdateSysUser()         
	
	
	/**
	 * if标签，测试动态SQL查询功能.
	 * 
	 * @author moon  2019/02/15  11:10        
	 */
	@Test
	public void testSelectSysUserByUser() {
		
		// 获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			// 通过映射获取 SysUserMapper 接口
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			
			// 只查询用户名时
			SysUser sysUser = new SysUser();
			sysUser.setUserName("ad");
			System.out.println("sysUser值为： " + sysUser.toString());
			
			List<SysUser> sysUserList = userMapper.selectSysUserByUser(sysUser);
			System.out.println("sysUserList值为： " + sysUserList.toString());
			Assert.assertTrue(sysUserList.size() > 0);
			System.out.println("----------------------------------------------");
			
			
			// 只查询用户邮箱时
			SysUser sysUser2 = new SysUser();
			sysUser2.setUserEmail("test@mybatis.tk");
			System.out.println("sysUser2值为： " + sysUser2.toString());
			
			sysUserList = userMapper.selectSysUserByUser(sysUser2);
			System.out.println("sysUserList值为： " + sysUserList.toString());
			Assert.assertTrue(sysUserList.size() > 0);
			System.out.println("----------------------------------------------");
			
			
			// 当同时查询用户名和邮箱时
			sysUser = new SysUser();
			sysUser.setUserName("te");
			sysUser.setUserEmail("test@mybatis.tk");
			System.out.println("sysUser值为： " + sysUser.toString());
			
			sysUserList = userMapper.selectSysUserByUser(sysUser);
			System.out.println("sysUserList值为： " + sysUserList.toString());
			Assert.assertTrue(sysUserList.size() > 0);
			System.out.println("----------------------------------------------");
			
			System.out.println("验证 selectSysUserByUser2(...)函数 ");
			sysUser = new SysUser();
			sysUser.setUserName("te");
			sysUserList = userMapper.selectSysUserByUser2(sysUser);
			System.out.println("sysUserList值为： " + sysUserList.toString());
			
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			
			// 对事务进行回滚
			sqlSession.rollback();
			
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
}
