package com.moon.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.moon.mybatis.mapper.SysPrivilegeMapper;
import com.moon.mybatis.pojo.SysPrivilege;

public class PrivilegeMapperTest extends BaseMapperTest {
	
	
	/**
	 * 一对多映射
	 * 
	 * @author moon  2019/04/27  12:04  
	 */
	@Test
	public void testSelectPrivilegeByParams() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysPrivilegeMapper privilegeMapper = sqlSession.getMapper(SysPrivilegeMapper.class);
			
			System.out.println("------------------------ Mybatis, 一对多映射. ------------------------");
			List<SysPrivilege> sysPrivilegeList = privilegeMapper.selectPrivilegeByRoleId(1L);
			System.out.println("List<SysPrivilege>为: " + JSON.toJSONString(sysPrivilegeList));
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("错误信息为: " + e.toString());
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			
			// 事务回滚
			sqlSession.rollback();
			
			// 关闭sqlSession
			sqlSession.close();
		}
		
	}
	
	
}
