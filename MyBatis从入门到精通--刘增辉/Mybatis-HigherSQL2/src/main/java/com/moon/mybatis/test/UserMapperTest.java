package com.moon.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.moon.mybatis.mapper.SysUserMapper;
import com.moon.mybatis.pojo.SysUser;

/**
 * 测试类，集中进行验证Mybatis的高级查询: 
 * 	高级映射、存储过程、
 * 	枚举、JavaBean、JDK8  
 * 
 * 一对一映射  
 * 
 * 备注：在UserMapperTest、UserMapperTest2、UserMapperTest3、RoleMapperTest、PrivilegeMapperTest测试类中，均
 * 只进行到 MyBatis的高级查询中的"高级映射"。    @author  moon  2019/05/01  15:30  
 * 
 * @author moon  2019/03/07  16:57  
 */
public class UserMapperTest extends BaseMapperTest {
	
	
	/**
	 * 一对一映射
	 * 
	 * @author moon  2019/03/08  11:28 
	 */
	@Test
	public void testSelectUserAndRoleById() {
		
		// 获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			// 获取 UserMapper接口
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			
			System.out.println("------------------------ 验证Mybatis逆向生成工具生成的函数 ------------------------");
			SysUser user = userMapper.selectByPrimaryKey(1001L);
			System.out.println("user为：" + user.toString());
			
			
			System.out.println("------------------------ Mybatis, 一对一映射，使用自动映射处理一对一关系. ------------------------");
			// 特别注意，在测试数据中，id=1L的用户有2个角色，不适合这个例子.
			// 在这里，使用只有一个角色的用户 (id=1001L)
			SysUser user2 = userMapper.selectUserAndRoleById(1001L);
			System.out.println("user2为: " + JSON.toJSONString(user2));
			
			
			System.out.println("------------------------ Mybatis, 一对一映射，使用resultMap配置一对一映射关系. ------------------------");
			SysUser user3 = userMapper.selectUserAndRoleById2(1004L);
			System.out.println("user3为：" + user3.toString());
			
			
			System.out.println("------------------------ Mybatis, 一对一映射，使用resultMap配置一对一映射关系，Mybatis支持resultMap映射继承. ------------------------");
			SysUser user4 = userMapper.selectUserAndRoleById3(1001L);
			System.out.println("user4为：" + user4.toString());
			
			
			System.out.println("------------------------ Mybatis, 一对一映射，使用resultMap的association标签配置一对一映射. ------------------------");
			SysUser user5 = userMapper.selectUserAndRoleById4(1001L);
			System.out.println("user5为：" + user5.toString());
			
			
			System.out.println("------------------------ Mybatis, 一对一映射，使用resultMap的association标签配置一对一映射. ------------------------");
			SysUser user6 = userMapper.selectUserAndRoleById5(1001L);
			System.out.println("user6为：" + user6.toString());
			
			
			System.out.println("------------------------ Mybatis, 一对一映射，使用resultMap的association标签配置一对一映射. ------------------------");
			SysUser user7 = userMapper.selectUserAndRoleById6(1001L);
			System.out.println("user7为：" + user7.toString());
			
			
			System.out.println("------------------------ Mybatis, 一对一映射，使用resultMap的association标签配置一对一映射. ------------------------");
			SysUser user8 = userMapper.selectUserAndRoleById7(1001L);
			System.out.println("user8为：" + user8.toString());
			
			
			/**
			 * association标签的fetchType属性值lazy，用于设置延迟加载。
			 * 延迟加载功能尚未得到充分验证！具体现象：启动运行正常，但控制台log日志没有得到预期结果。
			 * 
			 */
			System.out.println("------------------------ Mybatis, 一对一映射，使用resultMap的association标签配置一对一映射. ------------------------");
			SysUser user9 = userMapper.selectUserAndRoleById8(1001L);
			System.out.println("user9为：" + user9.toString());
			System.out.println("调用user.getSysRole()");
			System.out.println("user9.sysRole值为：" + user9.getSysRole());
			
			
			
			// user不为空
			Assert.assertNotNull(user);
			
		} catch (Exception e) {
			
			System.out.println("e的值为: " + e.toString());
			
			// 提交事务
			// sqlSession.commit();
			// 事务回滚
			sqlSession.rollback();
			
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
	
}
