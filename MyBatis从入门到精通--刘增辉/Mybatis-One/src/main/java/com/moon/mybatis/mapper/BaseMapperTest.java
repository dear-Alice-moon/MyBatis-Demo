package com.moon.mybatis.mapper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

/**
 * 基础测试类
 * @author moon 
 *
 */
public class BaseMapperTest {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void init() {
		
		try {
			System.out.println("BaseMapperTest.java类，init()函数......");
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException ignore) {
			ignore.printStackTrace();
		}
		
	}
	
	
	public SqlSession getSqlSession() {
		System.out.println("BaseMapperTest.java类，getSqlSession()函数......");
		return sqlSessionFactory.openSession();
	}
	
	
}
