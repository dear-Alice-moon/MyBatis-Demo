package com.moon.mybatis.plugin;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.RowBounds;


/**
 * MySql实现
 * 
 * @author moon  2019/10/18  23:11
 *
 */
// @SuppressWarnings("rawtypes")
public class MySqlDialect implements Dialect {
	
	
	/**
	 * 跳过 count 和分页查询
	 * 
	 * @param msId               msId执行的MyBatis方法全名
	 * @param parameterObject    parameterObject 方法参数
	 * @param rowBounds          分页参数
	 * @return                   true跳过, 返回默认查询结果; false 则执行分页查询.
	 */
	@Override
	public boolean skip(String msId, Object parameterObject, RowBounds rowBounds) {
		
		// 这里使用 RowBounds 分页
		// 没有 RowBounds 参数时，会使用 RowBounds.DEFAULT 作为默认值
		if (rowBounds != RowBounds.DEFAULT) {
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 执行分页前，返回true会进行count查询，返回false会继续下面的beforePage判断。
	 * 
	 * @param msId                执行的MyBatis方法全名
	 * @param parameterObject     方法参数
	 * @param rowBounds           分页参数    
	 * @return
	 */
	@Override
	public boolean beforeCount(String msId, Object parameterObject, RowBounds rowBounds) {
		
		// 只有使用 PageRowBounds 才能记录总数，否则查询了总数也没用
		if (rowBounds instanceof PageRowBounds) {
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * 生成 count 查询sql
	 * 
	 * @param boundSql           绑定SQL对象
	 * @param parameterObject    方法参数
	 * @param rowBounds          分页参数
	 * @param countKey           count缓存key
	 * @return
	 */
	@Override
	public String getCountSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey countKey) {
		
		// 简单嵌套实现 MySql 的 Count 查询
		return "SELECT COUNT(*) FROM (" + boundSql.getSql() + ") temp";
	}
	
	
	/**
	 * 执行完count查询后
	 * 
	 * @param count              查询结果总数
	 * @param parameterObject    接口参数
	 * @param rowBounds          分页参数
	 */
	@Override
	public void afterCount(long count, Object parameterObject, RowBounds rowBounds) {
		
		// 记录总数，按照 beforeCount 逻辑，只有 PageRowBounds 才会查询 count.
		// 所以这里直接强制转换
		((PageRowBounds)rowBounds).setTotal(count);
	}
	
	
	/**
	 * 执行分页前，返回true会进行分页查询，返回false会返回默认查询结果。
	 * 
	 * @param msId               执行的MyBatis方法全名
	 * @param parameterObject    方法参数
	 * @param rowBounds          分页参数
	 * @return
	 */
	@Override
	public boolean beforePage(String msId, Object parameterObject, RowBounds rowBounds) {
		
		if (rowBounds != RowBounds.DEFAULT) {
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * 生成分页查询sql
	 * 
	 * @param boundSql           绑定SQL对象
	 * @param parameterObject    方法参数
	 * @param rowBounds          分页参数
	 * @param pageKey            分页缓存key
	 * @return
	 * 
	 * @author moon  2019/10/18  23:01
	 */
	@Override
	public String getPageSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey pageKey) {
		
		// pageKey会影响缓存，通过固定的 RowBounds 可以保证二级缓存有效。
		pageKey.update("RowBounds");
		
		return boundSql.getSql() + "LIMIT" + rowBounds.getOffset() + "," + rowBounds.getLimit();
	}
	
	
	/**
	 * 分页查询后，处理分页结果，拦截器中直接return该方法的返回值。
	 * 
	 * @param pageList           分页查询结果
	 * @param parameterObject    方法参数
	 * @param rowBounds          分页参数
	 * @return
	 * 
	 * @author moon  2019/10/18  23:04
	 */
	@Override
	public Object afterPage(List pageList, Object parameterObject, RowBounds rowBounds) {
		
		// 直接返回查询结果
		
		return pageList;
	}
	
	
	/**
	 * 设置参数
	 * 
	 * @param properties  插件属性
	 * 
	 * @author moon  2019/10/18  23:05
	 */
	@Override
	public void setProperties(Properties properties) {
		
		// 没有其他参数
	}

}
