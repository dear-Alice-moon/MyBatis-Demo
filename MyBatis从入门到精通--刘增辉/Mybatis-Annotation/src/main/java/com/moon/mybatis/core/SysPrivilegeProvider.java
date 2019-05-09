package com.moon.mybatis.core;

import org.apache.ibatis.jdbc.SQL;

public class SysPrivilegeProvider {
	
	
	/**
	 * 直接返回SQL字符串. 
	 * 在返回的字符串中，需要注意的是：privilege_url后的空格不可少，否则报错!   @author moon  2019/02/14  19:11  
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/02/14  18:20  
	 */
	public String selectPrivilegeById2(final Long id) {
		return "SELECT id, privilege_name, privilege_url "
			 + "FROM sys_privilege WHERE id = #{id} ";
	}
	
	
	/**
	 * SQL较长或需要拼接时推荐使用 new SQL(){} 的方式.
	 * 推荐这种写法
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/02/14  17:33  
	 */
	public String selectPrivilegeById(final Long id) {
		
		return new SQL() {
			{
				SELECT("id, privilege_name, privilege_url");
				FROM("sys_privilege");
				WHERE("id = #{id}");
			}
		}.toString();
	}
	
}
