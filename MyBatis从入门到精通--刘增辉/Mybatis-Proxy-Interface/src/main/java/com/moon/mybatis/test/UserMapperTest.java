package com.moon.mybatis.test;

import java.lang.reflect.Proxy;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.moon.mybatis.mapper.SysUserMapper;
import com.moon.mybatis.pojo.SysUser;

public class UserMapperTest extends BaseMapperTest {
	
	
	/**
	 * Mapper接口动态代理实现
	 * 
	 * @author moon  2019/02/12  19:19  
	 */
	@Test
	public void testSelectAll() {
		// 获取sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			// 获取 UserMapper接口
			MyMapperProxy userMapperProxy = new MyMapperProxy(SysUserMapper.class, sqlSession);
			SysUserMapper userMapper = (SysUserMapper)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] {SysUserMapper.class}, userMapperProxy);
			
			// 调用 selectAll() 函数
			List<SysUser> user = userMapper.selectAll();
			System.out.println("user值为：" + user.toString());
			
		} finally {
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
		
		
	}
	
}
