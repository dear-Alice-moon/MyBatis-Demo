package com.moon.mybatis.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.moon.mybatis.mode.Country;

public class CountryMapperTest {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void init() {
		try {
			System.out.println("走到 '@BeforeClass' 注解标注的函数了... ");
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException ignore) {
			ignore.printStackTrace();
		}
	}
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<Country> countryList = sqlSession.selectList("selectAll");
		} catch (Exception e) {
			// 不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
	
	private void printCountryList(List<Country> countryList) {
		for (Country country : countryList) {
			System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryName(), country.getCountryCode());
		}
	}
	
	// System.out.printf()   这2行代码有什么区别？？？     2019/01/13  19:20            
	// System.out.println()
	
	
}
