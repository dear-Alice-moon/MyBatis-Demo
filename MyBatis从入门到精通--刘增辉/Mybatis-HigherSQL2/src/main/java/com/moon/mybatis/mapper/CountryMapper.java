package com.moon.mybatis.mapper;

import java.util.Map;

public interface CountryMapper {

	/**
	 * 执行Oracle中的存储过程，存储过程涉及游标。
	 * 
	 * @param params
	 * @return
	 */
	Object selectCountries(Map<String, Object> params);
	
	
}