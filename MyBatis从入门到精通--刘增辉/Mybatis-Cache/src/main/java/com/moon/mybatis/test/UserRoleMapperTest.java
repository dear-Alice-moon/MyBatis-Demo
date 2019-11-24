package com.moon.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.moon.mybatis.mapper.SysRoleMapper5;
import com.moon.mybatis.mapper.SysUserMapper3;
import com.moon.mybatis.pojo.SysRole5;
import com.moon.mybatis.pojo.SysUser3;

/**
 * 验证脏数据的参数和避免
 * 
 * @author moon  2019/08/31  16:08  
 *
 */
public class UserRoleMapperTest extends BaseMapper {
	
	
	// SysRoleMapper5、 SysUserMapper3
	
	/**
	 * 配置二级缓存，验证脏数据的参数及避免.
	 * 
	 * @author moon  2019/09/07  19:24 
	 */
	@Test
	public void testDirtyData() {
		
		// 获取sqlSession
		SqlSession sqlSession = getSqlSession();
		System.out.println("----------------------------- 开启第1个sqlSession -----------------------------");
		
		try {
			
			SysUserMapper3 userMapper = sqlSession.getMapper(SysUserMapper3.class);
			SysUser3 user = userMapper.selectUserAndRoleById(1009L);
			
			Assert.assertEquals("测试用户", user.getRole().getRoleName());
			System.out.println("角色名为： " + user.getRole().getRoleName());
			System.out.println("user为: " + user.toString());
			
		} catch (Exception e) {
			
			System.out.println("错误信息为： " + e.toString());
			e.printStackTrace();
			
		} finally {
			
			// 提交事务
			sqlSession.commit();
			
			// 事务回滚
			// sqlSession.rollback();
			
			// 关闭sqlSession 
			sqlSession.close();
			
		}
		
		// 开始另一个新的 sqlSession
		sqlSession = getSqlSession();
		System.out.println("----------------------------- 开启第2个sqlSession -----------------------------");
		
		try {
			
			SysRoleMapper5 roleMapper = sqlSession.getMapper(SysRoleMapper5.class);
			SysRole5 role = roleMapper.selectRoleById(3L);
			
			role.setRoleName("脏数据测试");
			roleMapper.updateRoleById(role);  // 更新修改后的数据
			System.out.println("role为： " + role.toString());
			
		} catch (Exception e) {
			
			System.out.println("错误信息为： " + e.toString());
			e.printStackTrace();
			
		} finally {
			
			// 提交事务
			sqlSession.commit();  // 需要提交事务
			
			// 事务回滚
			// sqlSession.rollback();
			
			// 关闭sqlSession
			sqlSession.close();
			
		}
		
		
		// 开启另一个新的 sqlSession
		sqlSession = getSqlSession();
		System.out.println("----------------------------- 开启第3个sqlSession -----------------------------");
		
		try {
			
			SysUserMapper3 userMapper2 = sqlSession.getMapper(SysUserMapper3.class);
			SysRoleMapper5 roleMapper2 = sqlSession.getMapper(SysRoleMapper5.class);
			
			SysUser3 user2 = userMapper2.selectUserAndRoleById(1009L);
			SysRole5 role2 = roleMapper2.selectRoleById(3L);
			
			// Assert.assertEquals("测试用户", user2.getRole().getRoleName());
			Assert.assertEquals("脏数据测试", role2.getRoleName());
			System.out.println("角色名为: " + user2.getRole().getRoleName());
			System.out.println("查询操作后， user2为： " + user2.toString());
			System.out.println("查询操作后， role2为： " + role2.toString());
			
			// 还原数据
			role2.setRoleName("测试用户");
			roleMapper2.updateRoleById(role2);
			System.out.println("更新操作后，role2为： " + role2.toString());
			
		} catch (Exception e) {
			
			System.out.println("错误信息为： " + e.toString());
			e.printStackTrace();
			
		} finally {
			
			// 提交事务
			sqlSession.commit();  // 需要提交事务
			
			// 事务回滚
			// sqlSession.rollback();
			
			// 关闭sqlSession
			sqlSession.commit();
		}
		
	}
	
}
