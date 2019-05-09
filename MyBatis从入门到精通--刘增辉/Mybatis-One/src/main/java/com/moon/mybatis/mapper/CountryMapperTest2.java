package com.moon.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.moon.mybatis.mode.Country;

public class CountryMapperTest2 extends BaseMapperTest {
	
	@Test
	public void testSelectAll() {
		
		SqlSession sqlSession = getSqlSession();
		
		try {
			
			List<Country> countryList = sqlSession.selectList("com.moon.mybatis.mapper.CountryMapper.selectAll");
			printCountryList(countryList);
			
		} finally {
			// 不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	
	private void printCountryList(List<Country> countryList) {
		for (Country country : countryList) {
			System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryName(), country.getCountryCode());
		}
	}
	
	
	
}
