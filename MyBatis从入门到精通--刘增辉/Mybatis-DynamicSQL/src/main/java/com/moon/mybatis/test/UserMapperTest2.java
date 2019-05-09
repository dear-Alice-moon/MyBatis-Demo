package com.moon.mybatis.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.moon.mybatis.mapper.SysUserMapper2;
import com.moon.mybatis.pojo.SysUser;

/**
 * 测试类，集中进行验证Mybatis在Mysql/Oracle数据库下自增返回主键功能。
 * 
 * @author moon  2019/02/15  10:39         
 *
 */
public class UserMapperTest2 extends BaseMapperTest {
	
	
	/**
	 * 验证Mysql/Oracle数据库返回自增主键信息。
	 * 
	 * @author moon  2019/04/04  11:26  
	 */
	@Test
	public void testInsertSysUser() {
		
		// 获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper2 userMapper = sqlSession.getMapper(SysUserMapper2.class);
			
			SysUser sysUser = new SysUser(1011L,"张三年01", "123456", "Zhangsan@mybatis.tk", "普通用户", new byte[] {1,2,3}, new Date());
			SysUser sysUser2 = new SysUser(1012L,"李斯02", "123456", "Zhangsan@mybatis.tk", "普通用户", new byte[] {1,2,3}, new Date());
			SysUser sysUser3 = new SysUser("王二蛋03", "123456", "Zhangsan@mybatis.tk", "普通用户", new byte[] {1,2,3}, new Date());
			
			// sysUser4使用的是Oracle数据库，暂时无法测试。
			// SysUser sysUser4 = new SysUser("赵无极04", "123456", "Zhangsan@mybatis.tk", "普通用户", new byte[] {1,2,3}, new Date());
			
			Integer num1 = userMapper.insertSysUser(sysUser);
			Integer num2 = userMapper.insertSysUser2(sysUser2);
			Integer num3 = userMapper.insertSysUser3(sysUser3);
			
			System.out.println("num1为：" + num1);  // 返回值为：1
			System.out.println("num2为：" + num3);  // 返回值为：1
			System.out.println("num3为：" + num3);  // 返回值为：1
			System.out.println("sysUser3中的id为：" + sysUser3.getId());  // 返回值为：1025 
			
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			
			// 对事务进行回滚
			sqlSession.rollback();
			
			// 关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
}
