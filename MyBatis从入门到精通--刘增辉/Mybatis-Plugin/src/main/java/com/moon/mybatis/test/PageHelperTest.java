package com.moon.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moon.mybatis.mapper.SysUserMapper;
import com.moon.mybatis.pojo.SysUser;

/**
 * 测试PageHelper分页插件
 * 
 * @author moon  2019/10/19  22:15
 *
 */
public class PageHelperTest extends BaseMapper {
	
	
	
	@Test
	public void testPageHelper() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
			
			PageHelper.startPage(1, 5);  // 使用PageHelper分页插件进行分页操作.
			List<SysUser> userList = userMapper.selectAllUser();
			// 使用PageInfo对结果进行包装
			PageInfo page = new PageInfo(userList);
			
			System.out.println("userList为：" + JSONObject.toJSONString(userList));
			System.out.println("page为：" + JSONObject.toJSONString(page));
			
			
		} catch (Exception e) {
			
			System.out.println("错误信息为：" + e.toString());
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
	
	
}
