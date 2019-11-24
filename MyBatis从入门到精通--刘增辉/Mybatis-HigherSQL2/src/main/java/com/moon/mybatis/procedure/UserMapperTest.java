package com.moon.mybatis.procedure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.moon.mybatis.mapper.SysUserMapper3;
import com.moon.mybatis.pojo.SysUser2;
import com.moon.mybatis.test.BaseMapperTest;

/**
 * 测试类，集中进行验证Mybatis的高级查询: 
 *  存储过程
 * 
 * 一对一映射  
 * 
 * @author moon  2019/05/01  16:28    
 */
public class UserMapperTest extends BaseMapperTest {
	
	
	/**
	 * MyBatis框架调用Mysql数据库存储过程             
	 */
	@Test
	public void testSelectUserByProcedure() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper3 userMapper = sqlSession.getMapper(SysUserMapper3.class);
			
			System.out.println("------------------------ Mybatis, 调用第一个存储过程, 使用JavaBean作为参数查询用户信息. ------------------------");
			SysUser2 user = new SysUser2();
			user.setId(1L);
			userMapper.selectUserById(user);
			
			Assert.assertNotNull(user.getUserName());
			System.out.println("用户名为： " + user.getUserName());
			System.out.println("sysUser为： " + JSON.toJSONString(user));
			
			
			System.out.println("------------------------ Mybatis, 调用第二个存储过程, 使用Map<String, Object>作为参数查询用户信息. ------------------------");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userName", "ad");
			params.put("offset", 0);
			params.put("limit", 10);
			
			List<SysUser2> userList = userMapper.selectUserPage(params);
			Long total = (Long) params.get("total");
			System.out.println("总数为：" + total);
			for (SysUser2 user2 : userList) {
				System.out.println("用户名为： " + user2.getUserName());
			}
			System.out.println("userList为： " + JSON.toJSONString(userList));
			
			
			System.out.println("------------------------ Mybatis, 调用第三个存储过程, 多参数插入用户信息. ------------------------");
			SysUser2 user3 = new SysUser2();
			user3.setUserName("test1_procedure");
			user3.setUserPassword("123456");
			user3.setUserEmail("test1_procedure@mybatis.tk");
			user3.setUserInfo("test1_procedure info...");
			user3.setHeadImg(new byte[] {1, 2, 3, 4});
			// 插入用户信息和角色关联信息
			userMapper.insertUserAndRoles(user3, "1,2");
			Assert.assertNotNull(user3.getId());
			System.out.println("user3信息为：" + JSON.toJSONString(user3));
			
			
			System.out.println("------------------------ Mybatis, 调用第四个存储过程, 删除用户信息. ------------------------");
			Integer num = userMapper.deleteUserById(1004L);
			System.out.println("num为： " + num);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("错误信息为：" + e.toString());
			
		} finally {
			
			// 提交事务
			// sqlSession.commit();
			
			// 事务回滚
			sqlSession.rollback();
			
			// 关闭 sqlSession 
			sqlSession.close();
		}
		
	}
	
}
