package com.moon.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.moon.mybatis.mapper.SysUserMapper;
import com.moon.mybatis.pojo.SysRole;
import com.moon.mybatis.pojo.SysRole2;
import com.moon.mybatis.pojo.SysRoleExtend;
import com.moon.mybatis.pojo.SysUser;


/**
 * 测试类，集中进行验证Mybatis的查询功能。
 * 
 * @author moon  2019/01/31  15:03         
 *
 */
public class UserMapperTest extends BaseMapperTest {
	
	
	
	/**
	 * 根据用户id、User对象信息 删除指定信息
	 * 
	 * @author moon  2019/02/03  23:26                
	 */
	@Test
	public void testDeleteById() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			// 从数据库查询1个user对象，根据 id=1查询。
			SysUser user1 = userMapper.selectUserById(1L);
			// 现在还能查询出 user 对象
			Assert.assertNotNull(user1);
			// 调用方法删除
			Assert.assertEquals(new Integer(1), userMapper.deleteById(1L));
			// 再次查询，这时应该没有值，为null.
			Assert.assertNull(userMapper.selectUserById(1L));
			System.out.println("-------------------- 根据id删除指定对象顺利执行 ----------------------");
			
			
			// 使用SysUser参数再进行一次测试，根据id=1001查询
			SysUser user2 = userMapper.selectUserById(1001L);
			// 现在还能查询出user对象
			Assert.assertNotNull(user2);
			// 调用方法删除，注意这里使用参数user2
			Assert.assertEquals(new Integer(1), userMapper.deleteById(user2));
			// 再次查询，这时应该没有值，为null.
			Assert.assertNull(userMapper.selectUserById(1001L));
			// 使用SysUser参数再进行一次测试
			System.out.println("-------------------- 根据User对象删除指定对象顺利执行 ----------------------");
			
			
		} finally {
			// 为了不影响其他测试，这里选择回滚。
			// 由于默认的 sqlSessionFactory.openSession()是不自动提交的，
			// 因此不手动执行 commit 也不会提交到数据库.
			sqlSession.rollback();
			// 不要忘记关闭sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * 根据用户id更新 User对象信息
	 * 
	 * @author moon  2019/02/03  11:41 
	 */
	@Test
	public void testUpdateById() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			// 从数据库查询1个 user 对象
			SysUser user = userMapper.selectUserById(1L);
			System.out.println("修改前user信息为：" + user.toString());
			
			// 当前 userName为 admin
			Assert.assertEquals("admin", user.getUserName());
			// 修改用户名
			user.setUserName("admin_test");
			// 修改邮箱
			user.setUserEmail("test@mybatis.rk");
			// 更新数据，特别注意，这里的返回值 result 是执行的SQL影响的行数.
			Integer result = userMapper.updateById(user);
			System.out.println("更新的行数值为： " + result);
			
			
			System.out.println("---------------- 测试 assertEquals(...)函数 ----------------");
			// 只更新1条数据
			Assert.assertEquals(1, Integer.parseInt(result.toString()));  // 为测试 assertEquals(...)函数，暂时注释该行代码。
			// Assert.assertEquals(2, Integer.parseInt(result.toString()));
			System.out.println("---------------- 02--测试 assertEquals(...)函数 ----------------");
			
			// 根据当前id查询修改后的数据
			user = userMapper.selectUserById(1L);
			System.out.println("修改后的user值为： " + user.toString());
			
			// 修改后的名字是 admin_test
			Assert.assertEquals("admin_test", user.getUserName());
			
		} finally {
			// 为了不影响其他测试，这里选择回滚。
			// 由于默认 sqlSessionFactory.openSession()是不自动提交的.
			// 因此不手动执行 commit 也不会提交到数据库
			sqlSession.rollback();
			// sqlSession.commit();
			// 不要忘记关闭  sqlSession 
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * 多个接口参数的用法，使用 @Param 注解--JavaBean类型参数。
	 * 
	 * 根据用户id和角色的enabled状态获取用户的角色.
	 * 
	 * 
	 * @author moon  2019/02/12  11:17 
	 */
	@Test
	public void testSelectRolesByUserAndRole() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			// 实例化 SysUser、 SysRole 
			SysUser user = new SysUser(1L);
			SysRole role = new SysRole(1);
			List<SysRole> roleList = userMapper.selectRolesByUserAndRole(user, role);
			System.out.println("roleList值为：" + roleList.toString());
			
			// 结果不为空 
			Assert.assertNotNull(roleList);
			// 结果数量大于0
			Assert.assertTrue(roleList.size() > 0);
			
		} finally {
			// 不要忘记关闭 sqlSession 
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * 多个接口参数的用法，使用 @Param 注解--基本数据类型参数。
	 * 
	 * 根据用户id和角色enabled状态获取用户的角色.
	 * 
	 * @author moon  2019/02/12  10:10      
	 */
	@Test
	public void testSelectRolesByUserIdAndRoleEnabled() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			// 调用 selectRolesByUserIdAndRoleEnabled() 函数查询用户的角色
			List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
			
			System.out.println("roleList值为：" + roleList.toString());
			
			// 结果不为空
			Assert.assertNotNull(roleList);
			// 角色数量大于0个
			Assert.assertTrue(roleList.size() > 0);
			
		} finally {
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
	
	
	
	/**
	 * 根据用户id获取角色信息
	 * 
	 * @author moon  2019/01/24  16:19  
	 */
	@Test
	public void testSelectRoleByUserId3() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			// 调用 selectRolesByUserId3 方法查询用户的角色
			List<SysRole2> roleList = userMapper.selectRolesByUserId3(1L);
			
			// 结果为空
			Assert.assertNotNull(roleList);
			// 结果个数大于0
			Assert.assertTrue(roleList.size() > 0);
			
		} finally {
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * 根据用户id获取角色信息
	 * 
	 * @author moon  2019/01/24  15:26        
	 */
	@Test
	public void testSelectRoleByUserId2() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			// 调用 selectRolesByUserId2方法查询用户的角色
			List<SysRoleExtend> roleList = userMapper.selectRolesByUserId2(1L);
			
			// 结果为空
			Assert.assertNotNull(roleList);
			// 角色数量大于0个
			Assert.assertTrue(roleList.size() > 0);
			
		} finally {
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * 根据用户id获取角色信息
	 * 
	 */
	@Test
	public void testSelectRolesByUserId() {
		
		// 获取 SqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			// 获取 SysUserMapper 接口
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			// 调用 selectRolesByUserId()函数，查询 userId=1L 的 Role信息。
			List<SysRole> roleList = sysUserMapper.selectRolesByUserId(1L);
			
			System.out.println("---------------------------------");
			System.out.println("roleList为：" + roleList.toString());
			System.out.println("---------------------------------");
			
			// 结果不能为空
			Assert.assertNotNull(roleList);
			// 用户数量大于0
			Assert.assertTrue(roleList.size() > 0);
			
		} finally {
			sqlSession.close();
		} 
		
	}
	
	
	/**
	 * 通过 id 查询用户       2019/01/19  18:23        
	 * 
	 */
	@Test
	public void testSelectById() {
		
		// 获取sqlSession
		SqlSession sqlSession = getSqlSession();  // 继承获取 BaseMapperTest.java 类中的函数.
		
		try {
			// 获取SysUserMapper接口
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			// 调用 selectById方法，查询id=1的用户            
			SysUser user = userMapper.selectUserById(1L);
			
			System.out.println("---------------------------------");
			System.out.println("User为：" + user.toString());
			System.out.println("---------------------------------");
			
			// user不为空
			Assert.assertNotNull(user);
			// userName = "admin"
			Assert.assertEquals("admin", user.getUserName());
			
		} finally {
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * 查询全部用户       2019/01/20  12:15       
	 * 
	 */
	@Test
	public void testSelectAll() {
		
		// 获取sqlSession
		SqlSession sqlSession = getSqlSession();  // 继承获取 BaseMapperTest.java 类中的函数.
		
		try {
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			// 调用 selectAll 方法查询所有用户
			List<SysUser> userList = userMapper.selectAll();
			
			System.out.println("---------------------------------");
			System.out.println("userList为：" + userList.toString());
			System.out.println("---------------------------------");
			
			// 结果不为空
			Assert.assertNotNull(userList);
			// 用户数量大于0个
			Assert.assertTrue(userList.size() > 0);
			
		} finally {
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}  // public void testSelectAll()
	
	
}
