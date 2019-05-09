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
 * @author moon  2019/02/13  19:56  
 */
public class BaseMapperTest {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	
	@BeforeClass
	public static void init() {
		
		try {
			
			// 该行代码报错，找不到"/src/main/resources/mybatis-config.xml"文件.   @moon  2019/02/14  10:11  
			// Reader reader = Resources.getResourceAsReader("/src/main/resources/mybatis-config.xml");  
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException ignore) {
			ignore.printStackTrace();
		}
		
	}
	
	
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
}
