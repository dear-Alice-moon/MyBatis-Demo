package com.moon.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.moon.mybatis.enums.Enabled2;
import com.moon.mybatis.mapper.SysRole4Mapper;
import com.moon.mybatis.pojo.SysRole4;

/**
 * 测试类，使用枚举处理器。
 * 使用自定义的类型处理器
 * 
 * @author moon 
 *
 */
public class RoleMapperTest3 extends BaseMapperTest {
	
	
	/**
	 * MyBatis框架中，使用自定义的类型处理器。
	 */
	@Test
	public void testUpdateSysRole4ById() {
		
		// 获取sqlSession
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysRole4Mapper roleMapper = sqlSession.getMapper(SysRole4Mapper.class);
			// 先查询出角色，然后修改角色的enabled值为 disabled
			SysRole4 role = roleMapper.selectSysRole4ById(1L);
			
			role.setEnabled(Enabled2.disabled);
			roleMapper.updateSysRole4ById(role);
			
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
