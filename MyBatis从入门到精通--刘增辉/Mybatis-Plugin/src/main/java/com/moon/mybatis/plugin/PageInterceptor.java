package com.moon.mybatis.plugin;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;


/**
 * MyBatis--通用分页拦截器
 * 
 * 
 * @author moon  2019/09/21  18:21
 * @version  1.0.0
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Intercepts(
	@Signature(
		type = Executor.class,
		method = "query",
		args = {
				MappedStatement.class,
				Object.class,
				RowBounds.class,
				ResultHandler.class
		}
	)
)
public class PageInterceptor implements Interceptor {
	
	private static final List<ResultMapping> EMPTY_RESULTMAPPING = new ArrayList<ResultMapping>(0);
	private Dialect dialect;
	private Field additionalParametersField;
	
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 获取拦截方法的参数
		Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement) args[0];
		Object parameterObject = args[1];
		RowBounds rowBounds = (RowBounds) args[2];
		
		// 调用方法判断是否需要进行分页，如果不需要，直接返回结果。
		if (!dialect.skip(ms.getId(), parameterObject, rowBounds)) {
			
			ResultHandler resultHandler = (ResultHandler) args[3];
			// 当前的目标对象
			Executor executor = (Executor) invocation.getTarget();
			BoundSql boundSql = ms.getBoundSql(parameterObject);
			// 反射获取动态参数
			Map<String, Object> additionalParameters = (Map<String, Object>) additionalParametersField.get(boundSql);
			
			// 判断是否需要进行 count 查询
			if (dialect.beforeCount(ms.getId(), parameterObject, rowBounds)) {
				
				// 根据当前的ms创建一个返回值为Long类型的ms
				// MappedStatement countMs = new MappedStatement(ms, Long.class);  // 这种写法报错！！!  2019/10/19  21:56
				
				
				
			}  // if (dialect.beforeCount(ms.getId(), parameterObject, rowBounds))
			
			
			
			
			
			
		}  // if (!dialect.skip(ms.getId(), parameterObject, rowBounds))
		
		
		
		return null;
	}
	
	
	@Override
	public Object plugin(Object target) {
		
		return null;
	}
	
	
	@Override
	public void setProperties(Properties properties) {
		

	}

}
