package com.moon.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.moon.mybatis.enums.Enabled;
import com.moon.mybatis.enums.Enabled2;
import com.moon.mybatis.mapper.SysRole3Mapper;
import com.moon.mybatis.mapper.SysRole4Mapper;
import com.moon.mybatis.pojo.SysRole3;
import com.moon.mybatis.pojo.SysRole4;


/**
 * 测试类，使用枚举处理器。
 * 
 * @author moon 
 *
 */
public class RoleMapperEnumsTest2 extends BaseMapperTest {
	
	
	/**
	 * 使用自定义的枚举类型处理器，测试成功，该测试需要单独测试。    
	 * 
	 * 在进行该函数测试时，需要将在 mybatis-config.xml 中针对 com.moon.mybatis.enums.Enabled2 枚举类型的 MyBatis框架配置信息
	 * 开启，否则会报错。
	 * 
	 * @author moon  2019/06/29  13:30  
	 */
	@Test
	public void testUpdateSysRole3ById2() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysRole4Mapper roleMapper = sqlSession.getMapper(SysRole4Mapper.class);
			// 先查询出角色，然后修改角色的enabled值为 disabled
			SysRole4 role = roleMapper.selectSysRole4ById(1L);
			
			System.out.println("Enabled2.disabled值为： " + Enabled2.disabled.getValue());
			role.setEnabled(Enabled2.disabled);
			roleMapper.updateSysRole4ById(role);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("错误信息为： " + e.toString());
			
		} finally {
			
			// 提交事务
			sqlSession.commit();
			
			// 回滚事务
			// sqlSession.rollback();
			
			// 关闭事务
			sqlSession.close();
		}
	}
	
	
	
	/**
	 * 使用MyBatis提供的枚举类处理器，测试成功，该测试需要单独测试。   
	 * 
	 * 在进行该函数测试时，需要将在 mybatis-config.xml 中针对 com.moon.mybatis.enums.Enabled 枚举类型的 MyBatis框架配置信息
	 * 开启，否则会报错。
	 * 
	 * @author moon  2019/06/29  13:27  
	 */
	@Test
	public void testUpdateSysRole3ById() {
		
		// 获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysRole3Mapper roleMapper = sqlSession.getMapper(SysRole3Mapper.class);
			// 先查询出角色，然后修改角色的enabled值为 disabled 
			SysRole3 role = roleMapper.selectSysRole3ById(1L);
			
			// Assert.assertEquals(Enabled.enabled, role.getEnabled());
			
			System.out.println("Enabled.testa值为: " + Enabled.testa);
			role.setEnabled(Enabled.testa);
			roleMapper.updateSysRole3ById(role);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("错误信息为： " + e.toString());
			
		} finally {
			
			// 提交事务
			sqlSession.commit(); 
			
			// 事务回滚 
			// sqlSession.rollback(); 
			
			// 关闭事务 
			sqlSession.close();
			
		}
	}
	
}
