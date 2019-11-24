package com.moon.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

/**
 * 基础测试类
 * 
 * @author moon  2019/09/07  21:55
 *
 */
public class BaseMapper {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void init() {
		
		try {
			
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			
			System.out.println("错误信息为: " + e.toString());
			e.printStackTrace();
		}
	}
	
	
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
}
