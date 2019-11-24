package com.moon.mybatis.test;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.moon.mybatis.mapper.SysUserMapper;
import com.moon.mybatis.pojo.SysUser;

/**
 * 程序入口测试类
 * 
 * @author moon  2019/09/07  21:32
 *
 */
public class UserMapperTest extends BaseMapper {
	
	
	/**
	 * 测试自写小驼峰插件
	 * 
	 * @author moon  2019/09/07  17:24
	 */
	@Test
	public void testPlugin() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			Map<String, Object> valueMap = userMapper.selectByKeyId(1010L);
			SysUser user = userMapper.selectByPrimaryKey(1010L);
			
			System.out.println("返回值valueMap为：" + valueMap);
			
			for (String key : valueMap.keySet()) {
				System.out.print(key + "\t");
			}
			
			System.out.println("\n" + "---------------------------------------");
			System.out.println("user为：" + user.toString());
			
			
		} catch (Exception e) {
			
			System.out.println("错误信息为： " + e.toString());
			e.printStackTrace();
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			
			// 事务回滚
			sqlSession.rollback();
			
			// 关闭事务
			sqlSession.close();
		}
	}
	
	
	/**
	 * 测试项目是否调通
	 * 
	 * @author moon  2019/09/07  21:40
	 */
	@Test
	public void test() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			SysUser user = userMapper.selectByPrimaryKey(1010L);
			
			System.out.println("user为： " + user.toString());
			Assert.assertEquals("宋三", user.getUserName());
			
			
		} catch (Exception e) {
			
			System.out.println("错误信息为: " + e.toString());
			e.printStackTrace();
			
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
