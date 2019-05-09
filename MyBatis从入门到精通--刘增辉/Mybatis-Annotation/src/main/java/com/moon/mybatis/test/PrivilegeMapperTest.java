package com.moon.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.moon.mybatis.mapper.SysPrivilegeMapper;
import com.moon.mybatis.pojo.SysPrivilege;

public class PrivilegeMapperTest extends BaseMapperTest {
	
	
	/**
	 * 针对 SysPrivilegeMapper.java 文件进行测试.
	 * 主要测试 Provider注解
	 * 
	 * @author moon  2019/02/14  19:05  
	 */
	@Test
	public void testSelectSysPrivilege() {
		
		// 创建 sqlSession               
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysPrivilegeMapper privilegeMapper = sqlSession.getMapper(SysPrivilegeMapper.class);
			
			SysPrivilege sysPrivilege = privilegeMapper.selectSysPrivilegeById(1L);
			SysPrivilege sysPrivilege2 = privilegeMapper.selectSysPrivilegeById2(4L);
			
			System.out.println("sysPrivilege值为：" + sysPrivilege.toString());
			System.out.println("----------------------------------------------------");
			System.out.println("sysPrivilege2值为：" + sysPrivilege2.toString());
			
			Assert.assertNotNull(sysPrivilege);
			Assert.assertEquals("用户管理", sysPrivilege.getPrivilegeName());
			Assert.assertNotNull(sysPrivilege2);
			
		} finally {
			
			// 对事务进行回滚
			sqlSession.rollback();    
			// 提交事务
			// sqlSession.commit();
			
			// 关闭 sqlSession
			sqlSession.close();
		}
		
	}
	
}
