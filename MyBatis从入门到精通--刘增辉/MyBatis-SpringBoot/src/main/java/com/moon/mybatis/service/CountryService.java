package com.moon.mybatis.service;

import java.util.List;

import com.moon.mybatis.pojo.Country;

public interface CountryService {
	
	
	/**
	 * 查询全部数据
	 * 
	 * @return
	 * 
	 * @author moon  2019/11/24  11:35
	 */
	List<Country> selectAll();
	
}
