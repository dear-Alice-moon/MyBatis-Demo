package com.moon.mybatis.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.moon.mybatis.mapper.SysRoleMapper;
import com.moon.mybatis.mapper.SysRoleMapper2;
import com.moon.mybatis.pojo.SysRole;

/**
 * 测试类，集中进行验证Mybatis的查询功能.
 * 
 * @author moon  2019/02/13  19:57  
 */
public class RoleMapperTest extends BaseMapperTest {
	
	
	/**
	 * 针对 SysRoleMapper2.java 文件进行测试.
	 * 主要测试注解删除功能
	 * 
	 * @author moon  2019/02/14  16:24  
	 */
	@Test
	public void testDeleteSysRole() {
		
		// 创建 SqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			// 通过映射获取 SysRoleMapper2类
			SysRoleMapper2 roleMapper = sqlSession.getMapper(SysRoleMapper2.class);
			
			// 通过 Id 删除 SysRole
			Integer roleNum = roleMapper.deleteRoleById(1003L);
			System.out.println("roleNum值为： " + roleNum);
			Assert.assertEquals(1, Integer.parseInt(roleNum.toString()));
			Assert.assertEquals(new Integer(1), roleNum);
			System.out.println("----------------------------------------------");
			
			// 通过Id 查询 SysRole
			SysRole sysRole = roleMapper.selectById(1003L);
			System.out.println("sysRole值为: " + sysRole);
			Assert.assertNull(sysRole);
			
		} finally {
			
			// 对事务进行回滚
			sqlSession.rollback();
			// 提交事务
			// sqlSession.commit();
			
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * 针对 SysRoleMapper2.java 文件进行测试.
	 * 主要测试注解更新功能
	 * 
	 * @author moon  2019/02/14  15:39  
	 */
	@Test
	public void testUpdateSysRole() {
		
		// 创建 SqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			// 通过映射获取 SysRoleMapper2类
			SysRoleMapper2 roleMapper = sqlSession.getMapper(SysRoleMapper2.class);
			SysRole sysRole = new SysRole(1001L, "用户01", 1101, 1101L, new Date());
			SysRole sysRole2 = new SysRole(1003L, "用户03", 1103, 1103L, new Date());
			
			Integer roleNum = roleMapper.updateRoleById(sysRole);
			Integer roleNum2 = roleMapper.updateRoleById2(sysRole2);
			SysRole sysRole3 = roleMapper.selectById(1001L);
			SysRole sysRole4 = roleMapper.selectById(1003L);
			
			System.out.println("roleNum值为: " + roleNum);
			System.out.println("sysRole3值为：" + sysRole3.toString());
			System.out.println("-----------------------------------------");
			System.out.println("roleNum2值为: " + roleNum2);
			System.out.println("sysRole4值为：" + sysRole4.toString());
			
		} finally {
			
			// 对事务进行回滚
			sqlSession.rollback();
			// 对事务进行提交
			// sqlSession.commit();
			
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * 针对 SysRoleMapper2.java 文件进行测试.
	 * 主要测试注解新增功能 
	 * 
	 * @author moon  2019/02/14  15:09  
	 */
	@Test
	public void testInsertSysRole() {
		
		// 创建 SqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysRoleMapper2 roleMapper = sqlSession.getMapper(SysRoleMapper2.class);
			
			// 创建 SysRole 实体类
			SysRole sysRole = new SysRole(1001L,"普通管理员01", 111, 111L, new Date());
			// SysRole sysRole2 = new SysRole("普通管理员02", 112, 112L, new Date());
			SysRole sysRole3 = new SysRole(1003L, "普通管理员03", 113, 113L, new Date());
			// SysRole sysRole3 = new SysRole("普通管理员03", 113, 113L, new Date());
			SysRole sysRole4 = new SysRole("普通管理员04", 114, 114L, new Date());
			
			
			Integer roleNum1 = roleMapper.insertRole(sysRole);
			// Integer roleNum2 = roleMapper.insertRole2(sysRole2);
			Integer roleNum3 = roleMapper.insertRole3(sysRole3);
			Integer roleNum4 = roleMapper.insertRole4(sysRole4);
			
			System.out.println("roleNum1值为：" + roleNum1);
			System.out.println("sysRole中的id值为：" + sysRole.getId());
			System.out.println("----------------------------------------");
			
			// System.out.println("roleNum2值为：" + roleNum2);
			// System.out.println("sysRole2中的id值为：" + sysRole2.getId());
			System.out.println("----------------------------------------");
			
			System.out.println("roleNum3值为：" + roleNum3);
			System.out.println("sysRole3中的id值为：" + sysRole3.getId());
			System.out.println("----------------------------------------");
			
			System.out.println("roleNum4值为：" + roleNum4);
			System.out.println("sysRole4中的id值为：" + sysRole4.getId());
			
			
			
		} finally {
			
			// 将事务进行回滚.  
			sqlSession.rollback();
			// 将事务进行提交.
			// sqlSession.commit();
			
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
	
	/**
	 * 针对 SysRoleMapper.java 文件进行测试.
	 * 
	 * @author moon  2019/02/14  11:23 
	 */
	@Test
	public void testSelectById2() {
		
		// 获取sqlSession 
		SqlSession sqlSession = getSqlSession();
		
		try {
			SysRoleMapper roleMapper = sqlSession.getMapper(SysRoleMapper.class);
			
			SysRole sysRole = roleMapper.selectById(1L);
			System.out.println("sysRole值为：" + sysRole.toString());
			
			Assert.assertNotNull(sysRole);
			Assert.assertEquals("管理员", sysRole.getRoleName());
			System.out.println("---------------- sysRole, 验证成功，我感到也很快乐. ----------------");
			
			SysRole sysRole2 = roleMapper.selectById2(1L);
			System.out.println("sysRole2值为：" + sysRole2.toString());
			System.out.println("---------------- sysRole2, 验证成功，我感到也很快乐. ----------------");
			
			SysRole sysRole3 = roleMapper.selectById3(1L);
			System.out.println("sysRole3值为：" + sysRole3.toString());
			System.out.println("---------------- sysRole3, 验证成功，我感到也很快乐. ----------------");
			
			SysRole sysRole4 = roleMapper.selectById4(1L);
			System.out.println("sysRole4值为：" + sysRole4.toString());
			System.out.println("---------------- sysRole4, 验证成功，我感到也很快乐. ----------------");
			
			SysRole sysRole5 = roleMapper.selectById5(1L);
			System.out.println("sysRole5值为：" + sysRole5.toString());
			System.out.println("---------------- sysRole5, 验证成功，我感到也很快乐. ----------------");
			
			SysRole sysRole6 = roleMapper.selectById6(1L);
			System.out.println("sysRole6值为：" + sysRole6.toString());
			System.out.println("---------------- sysRole6, 验证成功，我感到也很快乐. ----------------");
			
			SysRole sysRole7 = roleMapper.selectById7(1L);
			System.out.println("sysRole7值为：" + sysRole7.toString());
			System.out.println("---------------- sysRole7, 验证成功，我感到也很快乐. ----------------");
			
			
			SysRole sysRole8 = roleMapper.selectById8(1L);
			System.out.println("sysRole8值为：" + sysRole8.toString());
			System.out.println("---------------- sysRole8, 验证成功，我感到也很快乐. ----------------");
			
			
			List<SysRole> roleList = roleMapper.selectAll();
			System.out.println("roleList值为：" + roleList.toString());
			System.out.println("---------------- roleList, 验证成功，我感到也很快乐. ----------------");
			// 结果不为空
			Assert.assertNotNull(roleList);
			// 角色数量大于0个
			Assert.assertTrue(roleList.size() > 0);
			// 验证下画线字段是否映射成功
			Assert.assertNotNull(roleList.get(0).getRoleName());
			
			
		} finally {
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
	
	@Test
	public void testSelectById() {
		// 获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			// 获取 RoleMapper接口
			SysRoleMapper roleMapper = sqlSession.getMapper(SysRoleMapper.class);
			// 调用 selectById方法，查询id=1的角色
			SysRole sysRole = roleMapper.selectById(1L);
			// role不为空
			Assert.assertNotNull(sysRole);
			// roleName=管理员
			Assert.assertEquals("管理员", sysRole.getRoleName());
			
			
		} finally {
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
}
