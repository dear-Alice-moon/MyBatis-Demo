package com.moon.mybatis.procedure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.moon.mybatis.mapper.CountryMapper;
import com.moon.mybatis.pojo.Country;
import com.moon.mybatis.test.BaseMapperTest;

/**
 * 测试类，集中进行验证Mybatis的高级查询: 
 *  存储过程
 *  一对一映射  
 * 
 * @author moon  2019/05/01  16:28    
 */
public class CountryMapperTest extends BaseMapperTest {
	
	
	/**
	 * Mybatis调用Oracle数据库中的存储过程，该存储过程涉及游标。
	 */
	@Test
	public void selectCountryByProcedure() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
			
			System.out.println("------------------------ Mybatis, 调用Oracle数据库存储过程, 涉及游标使用. ------------------------");
			
			// 获取第1页，10条内容， 默认查询总数count
			Map<String, Object> params = new HashMap<String, Object>();
			countryMapper.selectCountries(params);
			List<Country> list01 = (List<Country>) params.get("list1");
			List<Country> list02 = (List<Country>) params.get("list2");
			
			System.out.println("list01为： " + JSON.toJSONString(list01));
			System.out.println("list02为： " + JSON.toJSONString(list02));
			
			Assert.assertNotNull(list01);
			Assert.assertNotNull(list02);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("错误信息为： " + e.toString());
			
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
