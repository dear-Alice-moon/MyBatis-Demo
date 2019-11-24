package com.moon.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.moon.mybatis.mapper.SysUserMapper2;
import com.moon.mybatis.pojo.SysUser2;

/** 
 * 一对多映射  
 * 
 * @author moon  2019/04/27  11:49      
 */
public class UserMapperTest3 extends BaseMapperTest {
	
	
	/**
	 * 一对多映射
	 * 
	 * @author moon  2019/04/27  11:51  
	 */
	@Test
	public void testSelectUserAndRoleByParams() {
		
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			// 获取 SysUserMapper2接口
			SysUserMapper2 userMapper = sqlSession.getMapper(SysUserMapper2.class);
			
			
			System.out.println("------------------------ Mybatis, 一对多映射，collection集合标签嵌套查询.. ------------------------");
			SysUser2 sysUser = userMapper.selectAllUserAndRolesSelect(1L);
			System.out.println("sysUser为: " + JSON.toJSONString(sysUser));
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("错误信息为: " + e.toString());
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			
			// 对事务进行回滚
			sqlSession.rollback();
			
			// 关闭sqlSession
			sqlSession.close();
			
		}
		
	}
	
}
